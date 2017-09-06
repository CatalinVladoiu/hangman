# Adaptation of Dockerfile at https://stackoverflow.com/questions/27719353/dockerfile-for-tomcat

FROM tomcat:alpine

MAINTAINER EAN

WORKDIR /usr/local/tomcat

COPY target/hangman.war /usr/local/tomcat/webapps/hangman.war
#COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
#COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml

EXPOSE 8080
