FROM maven:3.8.4-openjdk-17:latest as xpertview_build
COPY . .
RUN mvn clean package -DSkipTests

FROM openjdk-17-alpine as xpertview_runtime
COPY --from=xpertview_build /xpertview/xpertview-0.0.1-SNAPSHOT.jar /xpertview/xpertview.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","-Dserver.port=8081", "/xpertview/xpertview.jar"]
