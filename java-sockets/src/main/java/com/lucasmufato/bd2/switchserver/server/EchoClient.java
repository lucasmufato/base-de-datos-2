package com.lucasmufato.bd2.switchserver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Purpose: Se encarga de la comunicacion con el socket, implementa Runnable para ser transformado
 * a un thread.
 * <p>
 * <br>
 *
 * @author : lucasmufato
 **/
public class EchoClient implements Runnable{

  private final Socket socket;
  private final boolean saveToDb;
  private Connection connection;

  public EchoClient(Socket socket, boolean saveToDb) {
    this.socket = socket;
    this.saveToDb = saveToDb;
    if(saveToDb){
       this.connection = ConnectionManager.getConection();
    }
  }

  @Override
  public void run() {
    InetAddress inetAddress = socket.getInetAddress();
    System.out.println("Conected client is in: "+inetAddress.getHostAddress());
    try {
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
              new InputStreamReader( socket.getInputStream() )
        );
      String msj;
      while( (msj = in.readLine()) != null && !msj.equals("exit") ) {
        out.println("echo: "+msj);
        System.out.println("echo: " + msj);
        if( this.saveToDb ){
          PreparedStatement ps = connection
              .prepareStatement("INSERT into log(echo) VALUES(?)");
          ps.setString(1, msj);
          ps.execute();
          System.out.println("escribi a BD");
        }

      }
      System.out.println("Recibi un exit. Saliendo.");
      socket.close();
    } catch (IOException | SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
