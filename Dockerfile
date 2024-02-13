FROM openjdk:17
ADD target/assessment-0.0.1-SNAPSHOT.jar assessment-docker.jar
ENTRYPOINT ["java","-jar","/assessment-docker.jar"]