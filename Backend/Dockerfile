# Usamos la imagen base de Java 20
FROM openjdk:19-alpine

# Instalamos PostgreSQL en el contenedor
RUN apk update && apk add postgresql

# Establecemos el directorio de trabajo
WORKDIR .

# Copiamos los archivos necesarios al contenedor
COPY Backend/target/inventary-0.0.1-SNAPSHOT.jar inventary-0.0.1-SNAPSHOT.jar
COPY Backend/database.sql /docker-entrypoint-initdb.d/

# Exponemos el puerto necesario para el backend
EXPOSE 8080

# Comando para iniciar PostgreSQL
CMD ["pg_ctl", "-D", "/var/lib/postgresql/data", "-l", "logfile", "start"]

# Comando para iniciar la aplicación backend
CMD ["java", "-jar", "inventary-0.0.1-SNAPSHOT.jar"]

