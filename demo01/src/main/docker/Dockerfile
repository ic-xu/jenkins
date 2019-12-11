FROM java:8
VOLUME /tmp
ADD *.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 9100
#ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]