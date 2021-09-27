#Contenido

La imagen contiene un mongoDb y su interfaz grafica mongo-express.
El usuario es "root" y la contraseña "masterkey".
La base de datos expone el puerto 27000
La GUI expone el puerto 8081

## Ejecucion

Para levantar los servicios ejecutar(en la carpeta donde esta el docker-compose.yml) :
´´´
docker-compose up -d
´´´

Para eliminarlos ejecutar:
´´´
docker-compose down
´´´

## Mongo shell

Para usar mongo shell debe estar el servicio levantado y entramos al mismo usa 

´´´
docker exec -it mongo-4.4_db  bash
´´´

Una ves dentro de contenedor ejecutar mongo con los parametros de conexion:
´´´
mongo -u root -p masterkey
´´´

Para salir de mongo shell usamos el comando _quit()_
Para salir de la terminal dentro del contenedor usamos _exit_