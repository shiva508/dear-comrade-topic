FROM openjdk:17-alpine
WORKDIR /opt
ENV PORT 8084
EXPOSE 8084
COPY target/dear-comrade-topic-0.0.1-SNAPSHOT.jar /opt/dear-comrade-topic-0.0.1.jar
ENTRYPOINT exec java $JAVA_OPTS -jar dear-comrade-topic-0.0.1.jar