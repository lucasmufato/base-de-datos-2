# Firebird 3 + Cloud Beaver 4

Para levantar el entorno

```docker-compose up```

La base de datos queda en el puerto 30501 externo y en el 3050 interno.

Al IDE web de Cloud Beaver se accede desde: http://localhost:8978

Crear usuario y clave de administracion y finalizar el alta de administrador

## Configurar la conexion a firebird

En connection manager hacer una conexion nueva con el driver de firebird, completar con:

- Host: fb3
- Port: 3050
- Database: /firebird/data/BD2
- User name: SYSDBA
- Password: masterkey 


## Conexion remota a la VM

Ejecutar:

ssh -p2244 -L 8978:localhost:8978 bdd@bd2.my.to