FROM registry.access.redhat.com/rhel7

MAINTAINER Shah Zobair <szobair@redhat.com>

# Disclaimer: This Image is not an official image from Apache or Red Hat.
# So, it will not be maintained and only be used as a test purpose 
# in Develpment Environments.

RUN yum --disablerepo=* \
        --enablerepo=rhel-7-server-rpms \
        --enablerepo=rhel-7-server-extras-rpms \
        --enablerepo=rhel-7-server-optional-rpms \
        update -y && \
    yum --disablerepo='*' \
        --enablerepo=rhel-7-server-rpms \
        --enablerepo=rhel-7-server-extras-rpms \
        install -y java-1.8.0-openjdk* && \
    yum clean all

ENV CATALINA_HOME /opt/tomcat
ENV JAVA_HOME /usr/lib/jvm/jre-1.8.0-openjdk
ENV PATH $CATALINA_HOME/bin:$JAVA_HOME:$PATH
RUN mkdir -p "$CATALINA_HOME"
WORKDIR $CATALINA_HOME

RUN curl -O https://downloads.apache.org/tomcat/tomcat-8/v8.5.72/bin/apache-tomcat-8.5.72.tar.gz && \
    tar xvfz apache*.tar.gz && \
    mv apache-tomcat-8.5.72/* $CATALINA_HOME/. && \
    java -version

RUN useradd tomcat -u 1001 \
 && chown -R tomcat:tomcat $CATALINA_HOME \
 && chmod 755 -R $CATALINA_HOME \
 && chmod 777 -R $CATALINA_HOME/lib $CATALINA_HOME/temp $CATALINA_HOME/work $CATALINA_HOME/logs $CATALINA_HOME/bin $CATALINA_HOME/webapps \
 && chmod +x /opt/tomcat/bin/catalina.sh

WORKDIR $CATALINA_HOME/webapps

EXPOSE 8080
USER 1001
CMD ["catalina.sh", "run"]
