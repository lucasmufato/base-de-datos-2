package com.lucasmufato.bd2.todo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * El servidor recibe como parametro el puerto donde esperar conexiones.
 * El cliente recibe IP y puerto a donde conectarse.
 *
 * Los programas se comunican enviando STRINGS, tambien se puede enviar OBJETOS COMPLEJOS, para esto revisar: ObjectOutputStream y ObjectInputStream
 *
 */
public class ClienteServidor {
    public static void main(String[] args) throws IOException {
        if (args.length > 1)
            new Cliente(args[0], Integer.parseInt(args[1]));
        else
            new Servidor(Integer.parseInt(args[0]));
    }
}

class Cliente{
    public Cliente(String ip, Integer puerto) throws IOException {
        // me conecto al ip puerto recibido
        Socket socket = new Socket(ip, puerto);
        // obtengo in y out para comunicarme. En este caso enviare y leere strings
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
        // envio y espero la respuesta
        out.println("Dia lluvioso");
        System.out.println("El servidor me respondio: "+in.readLine());
        // cierro recursos y desconecto
        out.close();
        in.close();
        socket.close();
    }
}

class Servidor{
    public Servidor(Integer puerto) throws IOException {
        // server socket es para recibir conexiones
        ServerSocket ss = new ServerSocket(puerto);
        System.out.println("Soy el server, esperando conexiones en "+puerto);
        while(true){
            // espero que alguien se conecte, cuando alguien se conecta el metodo devuelve un socket con la conexion.
            Socket socket = ss.accept();
            // igual que en el cliente, obtengo los in y out
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
            // leo y despues respondo
            System.out.println("El cliente me informo que el dia es: "+in.readLine());
            out.println("Dia Soleado");
            // cierro recursos y desconecto
            out.close();
            in.close();
            socket.close();
        }
    }
}
