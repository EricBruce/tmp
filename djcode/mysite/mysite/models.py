__author__ = 'eric'
from mongoengine import Document, StringField, URLField, DateTimeField, connect
import time

from mysite.settings import DBNAME
connect(DBNAME)

class Article(Document):
    id     = StringField()
    title   = StringField()
    desc    = StringField()
    link     = URLField()
    imgUrl  = URLField()
    time    = DateTimeField()


if __name__ == '__main__':
    a1 = Article(title='t1', desc='d1', link='http://www.baidu.com',
                 imgUrl='http://www.baidu.com/image',
                 time=time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time())))
    a1.save()
    a2 = Article(title='t2', desc='d2', link='http://www.baidu.com',
                 imgUrl='http://www.baidu.com/image',
                 time=time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time())))
    a2.save()
    a3 = Article(title='t3', desc='d3', link='http://www.baidu.com',
                 imgUrl='http://www.baidu.com/image',
                 time=time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time())))
    a3.save()
    print 'Hello World'