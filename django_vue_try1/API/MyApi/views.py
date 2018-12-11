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
# # from __future__ import print_function
# # from googleapiclient.discovery import build
# from httplib2 import Http
# from oauth2client import file, client, tools
# from apiclient.http import MediaFileUpload


class MyUploadView(APIView):
    parser_class = (MultiPartParser,)
    def post(self, request, format=None):
      print("ENTERINGGGG upload post")
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

  # def uploadToDrive(self, fileToUpload):
  #
  #   file_metadata = {
  #     'name': fileToUpload.name,
  #     'mimeType': 'application/vnd.google-apps.spreadsheet'
  #   }
  #   media = MediaFileUpload(fileToUpload, mimetype='text/csv', resumable=True)
  #   uploadfile = self.service.files().create(body=file_metadata, media_body=media, fields='id').execute()
  #   print('File ID: %s' % uploadfile.get('id'))
  #   return uploadfile.get('id')



  def post(self, request, format=None):
      file_obj = request.FILES.getlist('photos')
      print(file_obj)
      counter = 1
      print("testing")
      if 'photos' not in request.data:
          raise ParseError("Empty content")

      tutorial_thrift = thriftpy.load("common\\JSONParser_thrift.thrift",
                                      module_name="getJSON_thrift")
      client1 = make_client(tutorial_thrift.GetJSONService, "149.165.156.103", 8888, '/getjsonfile')

      print("client connection established")

      d=client1.getJSONFile("R4B")

      print(d)
      return HttpResponse(d)




class get_all_files(APIView):
  parser_class = (MultiPartParser,)

  def get(self, request, format=None):
    # file_obj = request.FILES.getlist('photos')
    # print(file_obj)
    # counter = 1
    # print("testing")
    # if 'photos' not in request.data:
    #   raise ParseError("Empty content")

    tutorial_thrift = thriftpy.load("common\\MongoManagerThrift.thrift",
                                    module_name="getfiles_thrift")
    client1 = make_client(tutorial_thrift.GetAllFilesService, "149.165.156.103", 8888, '/getallfiles')

    print("client connection established")

    d = client1.getAllFiles()

    print(d)
    return HttpResponse(d)


class get_selected_files(APIView):
  parser_class = (MultiPartParser,)

  def get(self, request, format=None):
    # file_obj = request.FILES.getlist('photos')
    # print(file_obj)
    # counter = 1
    # print("testing")
    # if 'photos' not in request.data:
    #   raise ParseError("Empty content")

    tutorial_thrift = thriftpy.load("common\\JSONParser_thrift.thrift",
                                    module_name="getJSON_thrift")
    client1 = make_client(tutorial_thrift.GetJSONService, "149.165.156.103", 8888, '/getjsonfile')

    print("client connection established")

    listOfFiles = request.GET.get('files','')
    #use this in client



    d = client1.getJSONFile(listOfFiles)

    print(d)
    return HttpResponse(d)




class get_selected_coordinates(APIView):
  parser_class = (MultiPartParser,)

    # media = MediaFileUpload(fileToUpload, mimetype='text/csv', resumable=True)
    # uploadfile = self.service.files().create(body=file_metadata, media_body=media, fields='id').execute()
    # print('File ID: %s' % uploadfile.get('id'))
    # return uploadfile.get('id')

  def post(self, request, format=None):
    file_obj = request.FILES.getlist('photos')
    print(file_obj)
    counter = 1
    print("testing")
    if 'photos' not in request.data:
      raise ParseError("Empty content")

    tutorial_thrift = thriftpy.load("common\\JSONParser_thrift.thrift",
                                    module_name="getJSON_thrift")
    client1 = make_client(tutorial_thrift.GetJSONService, "149.165.156.103", 8888, '/getjsonfile')

    print("client connection established")

    d = client1.getJSONFile("R4B")

    print(d)
    return HttpResponse(d)




  # def post(self, request, format=None):
  #   # print("ENTERINGGGG")
  #   file_obj = request.FILES.getlist('photos')
  #   print("from upload function", file_obj)
  #   counter = 1
  #
  #   if 'photos' not in request.data:
  #     raise ParseError("Empty content")
  #   tutorial_thrift = thriftpy.load("common\\UploadService_thrift.thrift",
  #                                   module_name="echo_thrift")
  #   thrift_client = make_client(tutorial_thrift.UploadService, "149.165.156.103", 8888, '/getjsonfile')
  #
  #   fileIDs = []
  #   for f in file_obj:
  #     fileIDs.append(self.uploadToDrive(f))
  #     reqInfo = tutorial_thrift.TransferInfo()
  #     reqInfo.type = tutorial_thrift.TransferType().REQUEST
  #     reqInfo.fileName = f.name
  #     reqInfo.length = len(f)
  #
  #     client.upload(reqInfo)
  #
  #     reqInfo.type = tutorial_thrift.TransferType().PROGRESS
  #     reqInfo.data = f.read()
  #     client.upload(reqInfo)
  #   print("end of upload in django")
  #   print(fileIDs)
  #   return Response("Success")
