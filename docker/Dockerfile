FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar

ENTRYPOINT ["java","-Dserver.port=$PORT $JAVA_OPTS", "-jar", "application.jar"]
