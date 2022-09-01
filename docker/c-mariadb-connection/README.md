# Conexion entre programa escrito en C y un mariaDB

## Precondicion levantar el docker-compose del mariadb antes de ejecutar el paso 2.


## Paso 1, creacion de la imagen


Estando parador en este directorio, creamos una imagen basandonos en el compilador GCC y le pasamos el codigo fuente. Esta imagen va a compilar el codigo al momento que se crea.

Cuando corramos una instancia de la imagen, la misma va a ejecutar el codigo con el que se creo la imagen.

Para crear la imagen ejecutamos el comando:


docker build -t bd2mariaconector .

De esta forma a la imagen le asignamos el nombre "bd2mariaconector" asi podemos crear contendores usando su nombre.

Toda la definicion de la creacion de la imagen estan dentro del Dockerfile.


## Paso 2, ejecucion de la imagen

Si ya tenemos la imagen creada satisfactoriamente podemos crear una instancia nueva haciendo:

docker run --network=mariadb_default bd2mariaconector

esto deberia correr la imagen y deberia conectarse bien y mostrar el contenido de la tabla de la base de datos


### expansion del codigo

En caso de cambios al codigo, ejecutar paso 1 devuelta, al crear la imagen compila el codigo y en caso de errores no creara la imagen y los mostrara por pantalla