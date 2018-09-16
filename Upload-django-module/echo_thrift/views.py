# Create your views here.
from django.http import HttpResponse
import thriftpy
from django.shortcuts import render
from common.http import make_client
from thriftpy.rpc import client_context
import os

def echo(request):
    tutorial_thrift = thriftpy.load("common\\UploadService_thrift.thrift",
                                    module_name="echo_thrift")

    #client = make_client(tutorial_thrift.EchoService, '127.0.0.1', 8888)
    #return HttpResponse(client.echo(render(request,'index.html',{'what': 'Django File Upload'})))
    #file = "C:\\Users\\Soutri Mukherjee\\Desktop\\abc.jpg"
    #return HttpResponse("testing upload")


#def home(request):
    tutorial_thrift = thriftpy.load("common\\UploadService_thrift.thrift",
                                    module_name="echo_thrift")
    client = make_client(tutorial_thrift.UploadService, '127.0.0.1', 8888)
    file = "C:\\Users\\Soutri Mukherjee\\Desktop\\names.txt"
    bufsize=0
    bytes = open(file, "rb",buffering=bufsize).read()
    #bytes.flush()
    reqInfo= tutorial_thrift.TransferInfo()
    reqInfo.type = tutorial_thrift.TransferType().REQUEST
    reqInfo.fileName = "names.txt"
    reqInfo.length = len(file)
    client = make_client(tutorial_thrift.UploadService, "127.0.0.1", 8888)
    client.upload(reqInfo)

    reqInfo.type = tutorial_thrift.TransferType().PROGRESS
    reqInfo.data = bytes
    client.upload(reqInfo)
    return HttpResponse("Hello! Your file has been uploaded successfully!")


def upload(request):
    if request.method == 'POST':
        handle_uploaded_file(request.FILES['file'], str(request.FILES['file']))
        return HttpResponse("Successful")

    return HttpResponse("Failed")


def handle_uploaded_file(file, filename):

    if not os.path.exists('upload/'):
        os.mkdir('upload/')

    with open('upload/' + filename, 'wb+') as destination:
        for chunk in file.chunks():
            destination.write(chunk)






