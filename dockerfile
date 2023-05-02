# Imagen base
FROM openjdk:11-jdk-slim

# Directorio de trabajo
WORKDIR /app

# Copia los archivos necesarios para construir la aplicación
COPY . .

# Compila la aplicación
RUN javac Main.java

# Comando para ejecutar la aplicación
CMD ["java", "Main"]