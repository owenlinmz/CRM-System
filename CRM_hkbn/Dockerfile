FROM tomcat

WORKDIR /usr/local/tomcat/webapps/

ADD ./target/crm.war .

EXPOSE 8080

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]