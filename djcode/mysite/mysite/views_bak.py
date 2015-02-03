__author__ = 'eric'
from django.http import HttpResponse
import datetime
from django.template.loader import get_template
from django.template import Context
from django.shortcuts import render_to_response

def hello(request):
    return HttpResponse("Hello world")

def current_datetime(request):
    now = datetime.datetime.now()
    # html = "<html><body>It is now %s.</body></html>" % now
    # t = get_template('current_datetime.html')
    # html = t.render(Context({'current_date': now}))
    # return HttpResponse(html)
    return render_to_response('current_datetime.html', {'current_date': now})