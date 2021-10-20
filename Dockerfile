FROM adoptopenjdk/openjdk11
EXPOSE 8080
ADD /target/forum_alura-0.0.1-SNAPSHOT.jar app.jar
ARG POSTGRES_USERNAME
ARG POSTGRES_PASSWORD
ARG POSTGRES_URL
ENV PORT 8080
ENTRYPOINT ["java", "${JAVA_OPTS}", "-XX:+UseContainerSupport", "-Xmx300m", "-Xss512k", "-XX:CICompilerCount=2" ,"-Dserver.port=${PORT}", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
