
from django.urls import path
from . import views

urlpatterns = [
    path('', views.echo, name='echo'),
    #path(r'^home/',views.home,name="home"),
    path(r'^upload/', views.upload, name="upload"),
]


