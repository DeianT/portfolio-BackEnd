FROM amazoncorretto:17-alpine-jdk
MAINTAINER emaaristimuno
COPY target/demo-0.0.1-SNAPSHOT.jar target/demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"]