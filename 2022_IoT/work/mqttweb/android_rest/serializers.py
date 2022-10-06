from rest_framework import serializers
from .models import Board

# 테이블의 조회한 데이터 (queryset)를 model
# 이 db데이터를 json이나 xml로 쉽게 변환할 수 있도록 지원되는 기능
# Board model을 변환 즉 serialize해주어야 하므로 ModelSerializer를 사용한다.
# => DB에서 조회된 데이터를 models.py에 정의된 Board에 맞게 xml이나 json으로 자동변환해줄 객체
class BoardSerializer(serializers.ModelSerializer):
    class Meta:
        model = Board
        fields = ['boardNo', 'title', 'content', 'writer', 'write_date']
