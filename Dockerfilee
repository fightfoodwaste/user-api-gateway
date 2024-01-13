#-FROM openjdk:17 as builder
#WORKDIR extracted
#COPY target/*.jar app.jar
#RUN java -Djarmode=layertools -jar app.jar extract

#FROM openjdk:17
#WORKDIR application
#COPY --from=builder extracted/dependencies/ ./
#COPY --from=builder extracted/spring-boot-loader/ ./
#COPY --from=builder extracted/snapshot-dependencies/ ./
#COPY --from=builder extracted/application/ ./
#EXPOSE 8080
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

FROM eclipse-temurin:17-jdk-alpine as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT [&amp;quot;java&amp;quot;, &amp;quot;-jar&amp;quot;, &amp;quot;/opt/app/*.jar&amp;quot; ]