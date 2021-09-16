# Docker

Docker es un proyecto de código abierto que automatiza el despliegue de aplicaciones dentro de contenedores de software, proporcionando una capa adicional de abstracción y automatización de virtualización de aplicaciones en múltiples sistemas operativos. 
Docker utiliza características de aislamiento de recursos del kernel Linux, tales como cgroups y espacios de nombres (namespaces) para permitir que "contenedores" independientes se ejecuten dentro de una sola instancia de Linux, evitando la sobrecarga de iniciar y mantener máquinas virtuales.

## Uso

Se provee un pdf explicando como utilizar docker para instalar firebird 3 y conectarse mediante flamerobin.
Para el resto de las aplicaciones se recomienda el uso de docker-compose. (tambien se puede usar para firebird)

# Docker Compose

Docker Compose es una herramienta desarrollada para ayudar a definir y compartir aplicaciones de varios contenedores. Con Compose, puede crear un archivo YAML para definir los servicios y, con un solo comando, ponerlo todo en marcha o eliminarlo.

La gran ventaja de usar Compose es que puede definir la pila de la aplicación en un archivo, mantenerlo en la raíz del repositorio del proyecto (ahora tendrá control de versiones) y permitir que un tercero contribuya al proyecto. Un usuario solo tendría que clonar el repositorio e iniciar la aplicación Compose.

## Configuracion

Se definieron varias carpetas con readme y docker-compose.yml.
Cada carpeta contiene una aplicacion
Todos las aplicaciones contiene una base de datos y una interfaz web para la misma. (menos firebird)

## Uso

Desde una terminal entre dentro del directorio correspondiente a la aplicacion que quiere utilizar.

### Creacion de los contenedores
Ejecute: docker-compose up -d

### Detener los contenedores
Ejecute: docker-compose stop

### Activar los contenedores
Ejecute: docker-compose start

### Eliminar los contenedores
Ejecute: docker-compose down


