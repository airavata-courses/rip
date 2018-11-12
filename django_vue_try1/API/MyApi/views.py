from rest_framework.exceptions import ParseError
from rest_framework.parsers import MultiPartParser
from rest_framework.response import Response
from rest_framework.views import APIView
from django.http import HttpResponse
import json
import os
from django.core.files.storage import default_storage
from django.core.files.base import ContentFile
from django.conf import settings
import thriftpy
from common.http import make_client


class MyUploadView(APIView):
    parser_class = (MultiPartParser,)

    def post(self, request, format=None):
        file_obj = request.FILES.getlist('photos')
        print("from upload function",file_obj)
        counter = 1

        if 'photos' not in request.data:
            raise ParseError("Empty content")
        tutorial_thrift = thriftpy.load("common\\UploadService_thrift.thrift",
                                        module_name="echo_thrift")
        client = make_client(tutorial_thrift.UploadService, "149.165.156.103", 8888, '/upload')

        for f in file_obj:

            reqInfo = tutorial_thrift.TransferInfo()
            reqInfo.type = tutorial_thrift.TransferType().REQUEST
            reqInfo.fileName = f.name
            reqInfo.length = len(f)

            client.upload(reqInfo)

            reqInfo.type = tutorial_thrift.TransferType().PROGRESS
            reqInfo.data = f.read()
            client.upload(reqInfo)
        print("end of upload in django")
        return Response("Success")


class download_file(APIView):
  parser_class = (MultiPartParser,)


  def post(self, request, format=None):
      file_obj = request.FILES.getlist('photos')
      print(file_obj)
      counter = 1
      print("testing")
      if 'photos' not in request.data:
          raise ParseError("Empty content")
      #establish connection with thrift
      tutorial_thrift = thriftpy.load("common\\JSONParser_thrift.thrift",
                                      module_name="getJSON_thrift")
      client1 = make_client(tutorial_thrift.GetJSONService, "149.165.156.103", 8888, '/getjsonfile')

      # for f in file_obj:
      #
      #     reqInfo = tutorial_thrift.TransferInfo()
      #     reqInfo.type = tutorial_thrift.TransferType().REQUEST
      #     reqInfo.fileName = f.name
      #     reqInfo.length = len(f)
      print("client connection established")

      d=client1.getJSONFile("R4B")

      print(d)

      # reqInfo.type = tutorial_thrift.TransferType().PROGRESS
      # reqInfo.data = f.read()
      # client.upload(reqInfo)

      return HttpResponse(d)


