package com.lucasmufato.bd2.switchserver.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 * Purpose: Representa a un servidor multi o mono hilo que que genera una o varias instancias de
 * EchoClient las cuales es comunican con quien se conecto al socket
 * <p>
 * <br>
 *
 * @author : lucasmufato
 **/
public class Servidor {

  public static final int DEFAULT_PORT = 3344;
  public static final boolean DEFAULT_THREADS = false;
  public static final boolean SAVE_TO_DB = true;

  private int port = DEFAULT_PORT;
  private boolean multiHilo = DEFAULT_THREADS;
  private boolean saveToDb = SAVE_TO_DB;

  private ServerSocket serverSocket;
  private ArrayList<Thread> threads;

  public Servidor(final int port,final boolean multiHilo) {
    this.port = port;
    this.multiHilo = multiHilo;
    if(multiHilo){
      this.threads = new ArrayList<Thread>();
    }
  }

  public Servidor() {
  }

  public void escuchar() {
    try {
      this.serverSocket = new ServerSocket(this.port);
      System.out.println("Mi IP es: "+InetAddress.getLocalHost().getHostAddress());
      while(true){
        Socket socket = this.serverSocket.accept();
        System.out.println("Recibi una conexion");
        if(this.multiHilo){
          System.out.println("Generando hilos");
          this.manageThreads(socket);
        }else{
          System.out.println("Creando unico EchoClient");
          EchoClient echoClient = new EchoClient(socket, this.saveToDb);
          echoClient.run();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  private void manageThreads(final Socket socket) {
    Thread thread = new Thread(new EchoClient(socket, this.saveToDb));
    this.threads.add(thread);
    thread.start();
  }

}
