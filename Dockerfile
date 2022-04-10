FROM  openjdk:1.8
EXPOSE 8081
ADD target/DevOpsCalculator-0.0.1-SNAPSHOT.jar calculator.jar
ENTRYPOINT ["java", "-jar", "calculator.jar"]