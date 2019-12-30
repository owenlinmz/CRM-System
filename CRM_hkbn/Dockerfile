FROM tomcat

WORKDIR /usr/local/tomcat/webapps/

ADD ./target/CRM_hkbn-0.0.1-SNAPSHOT.war .

EXPOSE 8080

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]