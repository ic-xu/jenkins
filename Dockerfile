FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD jenkins-0.0.1-SNAPSHOT.jar jenkins.jar
RUN sh -c 'touch /jenkins.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/jenkins.jar"]