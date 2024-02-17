# Use a base image with Java installed
FROM openjdk:11
#
# # Set the working directory inside the container
WORKDIR /app

# Copy the Java file from the repository to the container
COPY target/library-demo-1.0-SNAPSHOT.jar library-demo.jar

# Define the command to run your Java application
# ENTRYPOINT ["java", "-jar", "/library-demo-1.0-SNAPSHOT.jar"]
