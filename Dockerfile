FROM openjdk:8-jre-slim
COPY target/lab.jar /app/app.jar

ENV LANG C.UTF-8

WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]
