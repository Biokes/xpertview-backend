FROM maven:3.8.7 as xpertview_build
COPY . .
RUN mvn clean package -DSkipTests

FROM openjdk:17
COPY --from=xpertview_build target/*.jar xpertview.jar
ENTRYPOINT ["java", "-jar","-Dserver.port=8081", "/xpertview/xpertview.jar"]
