# Docker Compose de MariaDB

Basado en https://hub.docker.com/_/mariadb levantar una BD mariaDB y un administrador web.

## Base de datos

- Puerto externo: 33060
- Puerto interno: 3306
- Clave para root: masterkey

La base se crea con una base de datos llamada bd2 y un usuario bd2 con password bd2

Las bases de datos se guardan en la carpeta databases

Para mas configs ver https://hub.docker.com/_/mariadb

## Adminer (administrador web)

- Puerto externo: 8888

Descripcion de adminer: https://hub.docker.com/_/adminer

## Configuracion en Admniner

Al levantar con docker compose ingresar a localhost:8888 y completar con:

- Motor de base de datos: MySQL
- Servidor: bd:3306
- Usuario: bd2
- Contraseña: bd2
- Base de datos: bd2

### Conexion como root

Para conectarse como root completar en el adminer con:

- Motor de base de datos: MySQL
- Servidor: bd:3306
- Usuario: root
- Contraseña: masterkey
- Base de datos:             (dejar vacio)