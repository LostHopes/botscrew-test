FROM gradle:9.1.0-jdk25 AS build
WORKDIR /university
COPY . /university/
RUN ./gradlew clean build --no-daemon


FROM openjdk:25-slim
WORKDIR /university
COPY --from=build /university/build/libs/university-0.0.1-SNAPSHOT.jar /university/university.jar

ENTRYPOINT ["java", "-jar", "/university/university.jar"]