FROM amazoncorretto:17-alpine-jdk
MAINTAINER emaaristimuno
COPY target/portfolio-0.0.1-SNAPSHOT.jar target/portfolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","target/portfolio-0.0.1-SNAPSHOT.jar"]