# Codigo guia para TP de sockets en Java

El proyecto sigue la estructura estandar de java/maven.
El mismo esta mavenizado, por lo que no es necesario descargar la libreria de conexion a postgres a mano.

El proyecto consta de 2 paquetes:
- El primero se llama 'todo' y en el mismo se encuentra una clase que sirve de ejemplo para crear sockets, enviar un mensaje y desconectarse.
- El segundo se llama 'switchserver' y es un ejemplo de servidor multihilos con conexion a la base de datos.

## Paquete TODO

Se debe ejecutar la clase ClienteServidor pasandole los siguientes parametros:
- PUERTO -> En caso de pasarle un solo parametro, se instanciara un servidor mono-hilo y escuchara en el puerto pasado por parametros.
- IP y PUERTO -> Se instanciara un cliente que trata de conectarse al servidor en la IP y PUERTO recibido.

El servidor y el cliente simplemente intercambiaran un mensaje indicando el clima y cerraran la conexion.


## Paquete SWITCHSERVER

Para ejecutar el codigo primero es necesario contar con una BD postgres, se probee un archivo docker-compose el cual al ejecutarse creara una BD Postgres y una interfaz web PgAdmin4.

### Preparacion 

En PgAdmin deberan loguearse con la informacion indicada en el docker-compose:
- user: bd2@bd2.com
- password: postgres

Para acceder al mismo entran a http://localhost:7070/

Aqui crearan un servidor nuevo, con el nombre que deseen, y en la seccion de conexion indicaran:
- host: db
- port: 5432
- username: postgres
- password: postgres

Creada la conexion al servidor, podran crear una base de datos o usar la por defecto, y deberan crear una tabla llamada log siguiendo lo indicado en el archivo DDL.sql.

En caso que vayan a utilizar otra configuracion deberan modificar el docker-compose y/o la clase ConnectionManager para que se pueda conectar bien.

### Funcionamiento

El programa es un simple ECHO, osea el servidor escucha conexion, al recibir alguna espera un mensaje y lo repite al cliente.
Al hacer esto tambien guarda el una BD el mensaje recibido y la fecha.

### Ejecucion

Ejecutar la clase App.
Crear primero un Servidor (multi o mono hilos) y dejarlo escuchando en un puerto. (se puede dejar vacio IP y puerto y toma el por defecto)
Crear Clientes, conectarse al servidor y enviar mensajes.

## Importante

El codigo es un ejemplo simple de creacion de hilos, uso de sockets y conexion a la BD.
El mismo tiene poca legibilidad, manejo de errores y falta de buenas practicas.
Se espera que los alumnos usen este codigo de guia y construyan algo mejor.

