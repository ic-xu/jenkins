FROM java:8
VOLUME /tmp
ADD jenkins-0.0.1-SNAPSHOT.jar jenkins.jar
RUN sh -c 'touch /jenkins.jar'
EXPOSE 9100
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/jenkins.jar"]