FROM registry.access.redhat.com/rhel7

MAINTAINER Shah Zobair <szobair@redhat.com>

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

RUN mkdir /opt/tomcat/

WORKDIR /opt/tomcat

RUN curl -O https://downloads.apache.org/tomcat/tomcat-8/v8.5.72/bin/apache-tomcat-8.5.72.tar.gz && \
    tar xvfz apache*.tar.gz && \
    mv apache-tomcat-8.5.72/* /opt/tomcat/. && \
    java -version && \
    export JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk

RUN useradd tomcat -u 1001 \
 #&& groupmod tomcat -g 1001 \
 && chown -R tomcat:tomcat /opt/tomcat

WORKDIR /opt/tomcat/webapps

EXPOSE 8080
USER 1001
CMD ["/opt/tomcat/bin/catalina.sh", "run"]
