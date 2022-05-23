FROM java:8-jdk-alpine
COPY ./ParcelRegistration/target/ParcelRegistration-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch ParcelRegistration-0.0.1-SNAPSHOT.jar'
ARG PORT=8082
EXPOSE ${PORT}
ENTRYPOINT ["java","-jar","ParcelRegistration-0.0.1-SNAPSHOT.jar"]
EXPOSE 8082
