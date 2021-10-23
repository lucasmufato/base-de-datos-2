package com.lucasmufato.bd2.switchserver.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Purpose: Manages the connection for the database
 * <p>
 * <br>
 *
 * @author : lucasmufato
 **/
public class ConnectionManager {

  private static ConnectionManager connectionManager;

  private final Connection connection;

  private String user;
  private String password;
  private String ip;
  private String port;
  private String database;

  /**
   * UNA forma de armar un singleton. la conexion a la BD es unica.
   *
   * @return conexion a la BD o tira exception
   */
  synchronized public static Connection getConection(){
    if (connectionManager == null){
      connectionManager = new ConnectionManager();
    }
    return connectionManager.connection;
  }

  /**
   * datos de conexion romerisados
   */
  private ConnectionManager() {
    this.user = "postgres";
    this.password = "postgres";
    this.ip = "localhost";
    this.port = "5470";
    this.database = "bd2";
    this.connection = this.connect();
  }
  /**
   * me conecto a la BD de postgres
   *
   * @return a Connection object
   */
  private Connection connect() {
    Connection conn = null;
    try {
      String url = "jdbc:postgresql://"+ip+":"+port+"/"+database;
      conn = DriverManager.getConnection(url, user, password);
      conn.setAutoCommit(true);
      System.out.println("Me conecte correctamente a la BD");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return conn;
  }



}
