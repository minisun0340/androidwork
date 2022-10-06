import json

from django.shortcuts import render
from android_rest.models import Board
from android_rest.serializers import BoardSerializer
from django.http import JsonResponse
from rest_framework.parsers import JSONParser

# Create your views here.
# 요청이 들어오면 Board테이블의 전체 레코드를 조회해서 json데이터로 변환해서 리턴하는 메소드
def list(request):
    rsBoard = Board.objects.all()
    print(rsBoard)
    if request.method == 'GET':
        print("test")
        datalist = Board.objects.all() #db에서 모든 데이터 조회하기
        serializer = BoardSerializer(datalist, many=True) #db조회한 데이터를 BoardSerializer객체로 변환
        print(json.dumps(serializer.data, ensure_ascii=False, default=str))
        #BoardSerializer데이터를 json으로 변환해서 리턴
        return JsonResponse(serializer.data, safe=False, json_dumps_params={'ensure_ascii':False})

#안드로이드에서 로그인 요청을 하면 처리할 rest api(메소드)
#클라이언트에서 id와 password를 json데이터로 전달하면 파싱해서  dbms에 조회, search...

def login(request):
    if request.method == 'POST':
        print("request_ok")

        #클라이언트가 전달해주는 json 데이터를 파싱
        data = JSONParser().parse(request)
        print(data)
        #파싱한 json데이터에서 boardNo이름으로 정의된 값을 추출
        boardNo = data["boardNo"]
        print(boardNo)
        #추출한 id를 이용해서 DB에서 데이터 조회하기
        obj = Board.objects.get(boardNo=int(boardNo))
        #   board테이블의 필드명  ------
        print(obj)

        #db에서 조회한 데이터와 패스워드가 일치하면 로그인 사용자가 존재하는 것으로 ok를 안드로이드로 보내고
        #패스워드가 일치하지 않으면 사용자가 없으므로 fail을 안드로이드로 보내기
        #data['writer'] : json데이터(안드로이드가 보낸 데이터)
        # obj.writer : db에서 id로 조회한 레코드에 있는 writer(패스워드)
        if data['writer'] == obj.writer:
            return JsonResponse("ok", safe=False, json_dumps_params={'ensure_ascii':False})
        else :
            return JsonResponse("fail", safe=False, json_dumps_params={'ensure_ascii': False})

