# Base image for the Docker container.
FROM maven:3.8.7-eclipse-temurin-19

# Set the working directory for the container.
WORKDIR /app

# Copy the rest of the project into the container.
COPY . .

# Expose the port that the application is running on.
EXPOSE 8080

# Start the application.
CMD ["mvn", "spring-boot:run"]
