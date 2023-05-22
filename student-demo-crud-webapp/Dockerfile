FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY student-demo-crud-webapp/target/student-demo-crud-webapp-0.0.1-SNAPSHOT.jar studentdemocrudwebapp.jar
EXPOSE 8004
ENTRYPOINT exec java $JAVA_OPTS -jar studentdemocrudwebapp.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar studentdemocrudwebapp.jar
