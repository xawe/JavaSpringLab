from openjdk:12-alpine
MAINTAINER github/xawe
COPY ./target/springlab-0.0.1-SNAPSHOT.jar /app/springlab-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java -Dserver.port=$PORT", "-jar", "springlab-0.0.1-SNAPSHOT.jar"]