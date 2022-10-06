from django.db import models


# Create your models here.
class Board(models.Model):
    boardNo = models.AutoField(db_column='boardNo', primary_key=True)
    title = models.CharField(db_column='title', max_length=255)
    content = models.TextField(db_column='content', )
    writer = models.CharField(db_column='writer', max_length=50)
    write_date = models.DateField(db_column='write_date', )

    class Meta:
        managed = False
        db_table = 'board'

    def __str__(self):
        return "제목 : " + self.title + ", 작성자 : " + self.writer + ", boardNo" + str(self.boardNo)
