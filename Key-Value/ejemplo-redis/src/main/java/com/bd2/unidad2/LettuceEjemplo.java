package com.bd2.unidad2;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.RedisURI.Builder;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * Hello Redis!
 *
 * Programa de ejemplo de conexion a una BD Redis 5.0.7 con el driver Letucce para java 1.8.
 *
 * El programa guarda 2 claves, una con la cantidad de conexiones a la BD y otra con mensaje "hola" u "hola redis"
 * dependiendo la cantidad de conexiones que se realizaron.
 *
 * En caso de que redis no este levantado o en otro puerto tira un RedisConnectionException.
 *
 * No es necesario crear ninguna BD ni estructura particular, con solo tener Redis levantando tal como se instalo ya funciona.
 *
 * En la primer corrida como las claves no exiten, al buscarlas la libreria devuelve null
 *
 */
public class LettuceEjemplo {
    //datos de conexion a la BD con valores por defecto de la instalacion de redis 5.0.7
    private static String IP = "localhost";
    private static int PORT = 16379;
    private static int DB = 0;

    private static String VARIABLE = "mensaje";
    private static String CONEXIONES = "conexiones";

    public static void main( String[] args )
    {
        System.out.println( "Conectandose a la BD" );

        //conexion a la BD, se deja detalladas las clases ya que la libreria provee distintas formas de conectarse como sincronica - asincronica
        final RedisURI url = Builder.redis(IP, PORT)
            .withDatabase(DB)
            .build();
        final RedisClient redisClient = RedisClient.create(url);
        final StatefulRedisConnection<String, String> statefulRedisConnection = redisClient.connect();
        final RedisCommands<String, String> syncConnection = statefulRedisConnection.sync();
        // Se puede dejar en una sola linea como:
        // RedisClient.create( Builder.redis(IP, PORT).withDatabase(DB).build() ).connect().sync();

        // Obetengo las 2 variables de la BD, ojo que pueden ser nulas!
        final String cont = syncConnection.get(CONEXIONES);
        final String var = syncConnection.get(VARIABLE);
        // Muestro ambas variables sin modificar
        System.out.println("Esta es la conexion nro:"+(cont==null?"0":cont));
        System.out.println("La variable dice: "+System.lineSeparator()+var);

        //modifico las variables, en caso que no existieran seteo las keys
        if(cont==null){
            syncConnection.set(CONEXIONES, "1");
            syncConnection.set(VARIABLE, "Hola");
        }else{
            // de si existiar, INCREMENTO el nro de conexiones
            syncConnection.incr(CONEXIONES);

            switch(var){
                case "Hola":
                    //AGREGO al valor existente el resto del saludo
                    syncConnection.append(VARIABLE, " redis!");
                    break;
                case "Hola redis!":
                    // Piso el valor existente
                    syncConnection.set(VARIABLE, "Hola");
            }
        }
        System.out.println("Desconectando");
        statefulRedisConnection.close();


    }
}
