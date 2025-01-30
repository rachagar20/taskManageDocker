# Use OpenJDK as the base image
FROM openjdk:21

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/dockerDemo-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
