package com.lucasmufato.bd2.switchserver;

import com.lucasmufato.bd2.switchserver.client.Cliente;
import com.lucasmufato.bd2.switchserver.server.Servidor;
import java.util.Scanner;

public class App{

    private static Scanner scanner;

    public static void main( String[] args )
    {
        System.out.println( "Iniciando programa." );
        scanner = new Scanner(System.in);
        System.out.println( "Ingrese C para cliente o S para servidor" );
        String entrada = scanner.nextLine();
        switch (entrada.toUpperCase()){
            case "C":
                administrarCliente();
                break;
            case "S":
                administrarServidor();
                break;
            default:
                System.out.println("Le erraste de parametro. ");
                break;
        }
        System.out.println("Saliendo");

    }

    private static void administrarServidor() {
        int port = Servidor.DEFAULT_PORT;
        boolean multiHilo = Servidor.DEFAULT_THREADS;
        System.out.println("Ingrese el puerto a escuchar, por defecto es: "+ port);
        String read = scanner.nextLine();
        if(!read.isBlank()){
            try{
                port = Integer.valueOf(read);
            }catch(NumberFormatException e){
                System.out.println("No ingresaste un nro correcto, usando default.");
            }

        }
        System.out.println("Ingrese M para multihilo o A para monohilo, por defecto es: " + multiHilo);
        read = scanner.nextLine();
        if(!read.isBlank()){
            switch (read.trim().toUpperCase()){
                case "M":
                    multiHilo = true;
                    break;
                case "A":
                    multiHilo = false;
                    break;
                default:
                    System.out.println("Ingresaste otra cosa, usando default");
            }
        }
        System.out.println("Inicializando servidor");
        Servidor servidor = new Servidor(port, multiHilo);
        System.out.println("Escuchando peticiones...");
        servidor.escuchar();
    }

    private static void administrarCliente() {
        String ip = Cliente.DEFAULT_IP;
        int puerto = Servidor.DEFAULT_PORT;
        System.out.println("Ingrese la IP del servidor, default es: "+ip);
        String read = scanner.nextLine();
        if(!read.isBlank()){
            ip = read.trim();
        }
        System.out.println("Ingrese el puerto, default es: "+puerto);
        read = scanner.nextLine();
        if(!read.isBlank()){
            try{
                puerto = Integer.valueOf(read);
            }catch(NumberFormatException e){
                System.out.println("No ingresaste un nro correcto, usando default.");
            }
        }
        System.out.println("Creando cliente");
        Cliente cliente = new Cliente(ip, puerto);
        System.out.println("Conectandose");
        cliente.iniciar();
    }
}
