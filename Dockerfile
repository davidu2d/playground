FROM openjdk:8-jdk-alpine
ENV PORT 8080
EXPOSE 8080
RUN mkdir /opt/app
ADD /build/libs/playground.jar /opt/app
ENTRYPOINT ["java", "-jar", "/opt/app/playground.jar"]