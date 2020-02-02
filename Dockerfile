FROM openjdk:8
ADD target/dockerDemo.jar dockerDemo.jar
ENTRYPOINT ["java","-jar","dockerDemo.jar"]