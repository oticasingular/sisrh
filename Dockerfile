FROM tomcat:11-jdk17

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/sisrh.war /usr/local/tomcat/webapps/sisrh.war

EXPOSE 8090

CMD ["catalina.sh", "run"]
