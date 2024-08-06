# Use Amazon Corretto 17 as the base image
FROM amazoncorretto:17.0.11

# Set the working directory in the container
WORKDIR /app

# Copy the executable jar file into the container
COPY target/cc_summer-0.0.1-SNAPSHOT.jar /app/cc_summer-0.0.1-SNAPSHOT.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/cc_summer-0.0.1-SNAPSHOT.jar"]