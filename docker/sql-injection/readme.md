# Web Goat

## Learn the hack - Stop the attack
WebGoat is a deliberately insecure application that allows interested developers just like you to test vulnerabilities commonly found in Java-based applications that use common and popular open source components.

## Description
Web application security is difficult to learn and practice. Not many people have full blown web applications like online book stores or online banks that can be used to scan for vulnerabilities. In addition, security professionals frequently need to test tools against a platform known to be vulnerable to ensure that they perform as advertised. All of this needs to happen in a safe and legal environment.

Even if your intentions are good, we believe you should never attempt to find vulnerabilities without permission. The primary goal of the WebGoat project is simple: create a de-facto interactive teaching environment for web application security. In the future, the project team hopes to extend WebGoat into becoming a security benchmarking platform and a Java-based Web site Honeypot.

WARNING 1: While running this program your machine will be extremely vulnerable to attack. You should disconnect from the Internet while using this program. WebGoat’s default configuration binds to localhost to minimize the exposure.

WARNING 2: This program is for educational purposes only. If you attempt these techniques without authorization, you are very likely to get caught. If you are caught engaging in unauthorized hacking, most companies will fire you. Claiming that you were doing security research will not work as that is the first thing that all hackers claim.


## USO

Abrir una linea de comandos dentro de la carpeta que contiene este readme y ejecutar:
docker-compose up -d


En el browser entrar a: http://127.0.0.1:8080/WebGoat/login


Registrar un usuario nuevo (con datos falsos)

Entrar a: (A1) Injection -> SQL injection introduccion. 	Ir a la seccion 6 para la teoria y desp practica de inyeccion de SQL


### Docker

https://hub.docker.com/r/webgoat/goatandwolf


### Git

https://github.com/WebGoat/WebGoat



services:
   db:
      image: webgoat/webgoat-8.0
      ports:
       - '8080:8080'