from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.
def index(request):
    return render(request, 'index.html')

def mqttTest(request):
    return render(request, 'mqtt_pub.html')

def mqttsub(request):
    return render(request, 'mqtt_sub.html')

def mqttpir(request):
    return render(request, 'mqtt_pir.html')

def mqttvideo(request):
    return render(request, 'mqttvideo.html')