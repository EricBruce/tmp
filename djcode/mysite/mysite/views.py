__author__ = 'eric'
# coding=utf8
from django.http import HttpResponse
import datetime
from django.shortcuts import render_to_response
from mysite.models import Article
from django.http import HttpResponseRedirect

'''
    news test
'''


def news(request):
    articles = []
    for a in Article.objects.all():
        article = Article()
        article.id = a.id
        article.title = a.title[0]
        article.desc = a.desc[0]
        article.link = a.link[0]
        article.imgUrl = a.imgUrl[0]
        article.time = a.time[0]
        articles.append(article)
    return render_to_response("news.html", {'articles': articles})


'''
    delete a news
'''


def delete(request, param1):
    Article.delete(Article(id=param1))
    return HttpResponseRedirect('/news')


''''
=============================================================== perfect line ======================
 below is just for test
'''


def hello(request):
    return HttpResponse("Hello world")


def current_datetime(request):
    now = datetime.datetime.now()
    # html = "<html><body>It is now %s.</body></html>" % now
    # t = get_template('current_datetime.html')
    # html = t.render(Context({'current_date': now}))
    # return HttpResponse(html)
    return render_to_response('current_datetime.html', {'current_date': now})


'''
    article list
'''


def list(request):
    articles = []
    for a in Article.objects.all():
        article = Article()
        article.id = a.id
        article.title = a.title[0]
        article.desc = a.desc[0]
        article.link = a.link[0]
        article.imgUrl = a.imgUrl[0]
        article.time = a.time[0]
        articles.append(article)
    return render_to_response("list.html", {'articles': articles})