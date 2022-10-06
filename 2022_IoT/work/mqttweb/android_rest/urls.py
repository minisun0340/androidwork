
from django.contrib import admin
from django.urls import path
from android_rest import views

urlpatterns = [
    path('list', views.list, name="list"),
    path('login', views.login, name="login"),

]
