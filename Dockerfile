FROM rhel-tomcat

MAINTAINER Shah Zobair <szobair@redhat.com>

COPY server.xml /opt/tomcat/conf/server.xml
COPY sample-web2.war /opt/tomcat/webapps
