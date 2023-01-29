FROM amazoncorretto:17-alpine-jdk

MAINTAINER UrielCT

COPY target/PortafolioWeb-0.0.1-SNAPSHOT.jar PortafolioWeb.jar

ENTRYPOINT ["java","-jar","/PortafolioWeb.jar"]