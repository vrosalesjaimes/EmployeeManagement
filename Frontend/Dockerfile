# Usamos la imagen base de Node para el desarrollo de Angular
FROM node:18

# Establecemos el directorio de trabajo
WORKDIR .

# Copiamos los archivos necesarios al contenedor
COPY Frontend/package.json Frontend/package-lock.json .

# Instalamos las dependencias del proyecto
RUN npm install

# Copiamos el resto de los archivos del frontend
COPY Frontend/ .

# Exponemos el puerto necesario para el servidor de desarrollo de Angular
EXPOSE 4200

# Comando para iniciar el servidor de desarrollo de Angular
CMD ["npm", "start"]

