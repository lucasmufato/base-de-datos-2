# REDIS y REDIS COMMANDER

Para levantar el entorno

```docker-compose up -d```
Al correr el comando deberia mostrar varias lineas, terminando con:
```
Creating redis-commander-bd2 ... done
Creating redis-bd2           ... done
```
Y se devuelve el control en la terminal.

La base de datos queda en el puerto 6379 adentro del docker.
Para acceder desde afuera, se debe utilizar el puerto 16379.

Al redis commander se accede desde: http://localhost:8881

Al entrar ya tiene una conexion con el redis
