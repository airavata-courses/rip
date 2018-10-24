from rest_framework.exceptions import ParseError
from rest_framework.parsers import MultiPartParser
from rest_framework.response import Response
from rest_framework.views import APIView
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
        print(file_obj)
        counter = 1

        if 'photos' not in request.data:
            raise ParseError("Empty content")
        tutorial_thrift = thriftpy.load("common\\UploadService_thrift.thrift",
                                        module_name="echo_thrift")
        client = make_client(tutorial_thrift.UploadService, "127.0.0.1", 8888, '/upload')
        
        for f in file_obj:

            reqInfo = tutorial_thrift.TransferInfo()
            reqInfo.type = tutorial_thrift.TransferType().REQUEST
            reqInfo.fileName = f.name
            reqInfo.length = len(f)

            client.upload(reqInfo)

            reqInfo.type = tutorial_thrift.TransferType().PROGRESS
            reqInfo.data = f.read()
            client.upload(reqInfo)

        return Response("Success")
