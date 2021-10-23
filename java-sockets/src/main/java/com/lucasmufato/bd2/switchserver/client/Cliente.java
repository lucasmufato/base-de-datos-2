package com.lucasmufato.bd2.switchserver.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Purpose: Client para conectarse por sockete al servidor y enviarle mensaje en modo text
 * <p>
 * <br>
 *
 * @author : lucasmufato
 **/
public class Cliente {

  public static final String DEFAULT_IP = "localhost";
  private final String ip;
  private final int puerto;

  public Cliente(String ip, int puerto) {
    this.ip = ip;
    this.puerto = puerto;
  }

  public void iniciar(){
    try {
      Socket socket = new Socket(ip, puerto);
      PrintWriter out =
          new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in =
          new BufferedReader(
              new InputStreamReader( socket.getInputStream() )
          );
      String msj;
      Scanner scanner = new Scanner(System.in);
      System.out.println("Conectado! ingrese comandos. 'exit' para salir.");
      while (!(msj = scanner.nextLine()).equals("exit")) {
        out.println(msj);
        String respuesta = in.readLine();
        System.out.println(respuesta);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
