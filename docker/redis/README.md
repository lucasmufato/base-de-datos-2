# REDIS y REDIS COMMANDER

Para levantar el entorno

```docker-compose up```
Al correr el comando deberia mostrar varias lineas, terminando con:
```redis-commander    | Redis Connection redis:6379 using Redis DB #0```


La base de datos queda en el puerto 6379 adentro del docker.
Para acceder desde afuera, se debe utilizar el puerto 16379.

Al redis commander se accede desde: http://localhost:8881

Al entrar ya tiene una conexion con el redis
