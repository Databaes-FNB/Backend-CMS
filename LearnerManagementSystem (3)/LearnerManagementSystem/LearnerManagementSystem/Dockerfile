# Use an official OpenJDK runtime as a parent image
FROM openjdk:23

# Set the working directory inside the container
WORKDIR /C:/Users/CAPACITI-JHB/Documents/T Matona/JAVA/LearnerManagementSystem (3)/LearnerManagementSystem/LearnerManagementSystem

# Copy the built JAR file into the container
COPY target/LearnerManagementSystem-0.0.1-SNAPSHOT.jar /

# Expose the port your application runs on
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "myapp.jar"]