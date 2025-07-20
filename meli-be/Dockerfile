FROM maven:3.9.6-eclipse-temurin-17 as builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# ✅ Copia el script SQL
COPY src/main/resources/db/init/init-db.sql /app/db/init/init-db.sql
# ✅ Define ruta del script como variable de entorno
ENV INIT_SQL_PATH=/app/db/init/init-db.sql

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
