# Imagen base
FROM openjdk:18-jdk-alpine3.15

# Directorio de trabajo
WORKDIR /app

# Copia los archivos necesarios para construir la aplicación
COPY . .

# Compila la aplicación
RUN javac /app/Main.java

# Comando para ejecutar la aplicación
CMD ["java", "/app/Main"]
