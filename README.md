# RHEL-Tomcat-OpenJdk Image for OpenShift

tomcat base image with sample war application. War was built from spring boot

Base Image from

- RHEL 7
- Tomcat 8.5.72
- openjdk-1.8.0

Built for OpenShift


Image: docker pull quay.io/szobair/rhel7-tomcat8-jdk1.8

Expose the service: oc expose service frontend
Patch the route as edge: oc patch route frontend -p '{"spec": {"tls": {"termination": "edge"}}}'

Test: {URL}/sample-web2/greet/shah
