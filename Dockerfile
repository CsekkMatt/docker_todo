FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD todo/target/todo-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]