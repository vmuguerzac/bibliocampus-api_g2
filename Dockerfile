# Cómo construir y ejecutar la API en Render.

# ---- Etapa 1: compilar con Maven (la imagen trae Maven y el JDK 21) ----
FROM maven:3.9-eclipse-temurin-21 AS construccion
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q -DskipTests package

# ---- Etapa 2: ejecutar (solo el JRE 21 y el JAR: la imagen final es más liviana) ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=construccion /app/target/*.jar app.jar

# El perfil "prod": H2 en memoria y sin consola de H2
ENV SPRING_PROFILES_ACTIVE=prod

# Usar como máximo el 75 % de la memoria del contenedor (el plan gratuito tiene poca)
CMD ["java", "-XX:MaxRAMPercentage=75", "-jar", "app.jar"]