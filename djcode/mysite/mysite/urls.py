from django.conf.urls import patterns, include, url
from mysite.views import hello, current_datetime, list, news, delete
from django.contrib.staticfiles.urls import staticfiles_urlpatterns

from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'mysite.views.home', name='home'),
    # url(r'^blog/', include('blog.urls')),

    # url(r'^admin/', include(admin.site.urls)),
    url('^hello/$', hello),
    ('^time/$', current_datetime),
    ('^list/$', list),
    ('^news/$', news),
    ('^del/(.+)/$', delete),
)

urlpatterns += staticfiles_urlpatterns()
