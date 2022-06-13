FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/parcel-registration-0.0.1-SNAPSHOT.jar ParcelRegistration.jar
ENTRYPOINT ["java","-jar","ParcelRegistration.jar"]
