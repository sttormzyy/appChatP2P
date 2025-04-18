/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import red.*;
import controlador.Control;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class Servidor implements Runnable{
    
    private ArrayList<String> clientes = new ArrayList();
    
    private HashMap<String, Servercito> clientes_activos = new HashMap<>();
    
    private HashMap<String, ArrayList<MensajeDeRed>> mensajes_pendientes = new HashMap<>();
    
    private int puerto;
    
    public Servidor(){}
    
    public static void main(String[] args){
        Servidor srv = new Servidor();
        try {
			srv.iniciarServidor(10000);
		} catch (IOException e) {
			System.out.println("Fallo");
		}
        srv.run();
    }
    
    private void iniciarServidor(int puerto) throws IOException{
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado en el puerto " + puerto);

            while (true) {
                // Aceptar la conexión de un cliente
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde: " + clienteSocket.getInetAddress());

                // Crear un hilo para manejar la conexión con este cliente
                Servercito hilo = new Servercito(clienteSocket, this);
                new Thread(hilo).start();  // Iniciar el hilo
            }
        } catch (IOException e) {
            throw new IOException("No se puedo generar conexion con el puerto desde el servidor");
        }
    }
    
    public synchronized void enviarMensaje(MensajeDeRed msj){
        String nicknameDestino = msj.getNicknameDestino();
        Servercito socketDestino = clientes_activos.get(nicknameDestino);
        if ( socketDestino != null ) {
            socketDestino.enviarMensaje(msj);
        } else {
            ArrayList<MensajeDeRed> msjs_pendientes = mensajes_pendientes.get(nicknameDestino);
            if (msjs_pendientes != null) {
                msjs_pendientes.add(msj);
            } else {
                msjs_pendientes = new ArrayList<MensajeDeRed>();
                msjs_pendientes.add(msj);
                mensajes_pendientes.put(nicknameDestino, msjs_pendientes);
            }
        }
    }

    public synchronized boolean verificarClienteActivo(String nickname) {
        if (clientes_activos.get(nickname) != null) {
            return false;
        }
        return true;
    }
    
    public synchronized void agregarClienteActivo(String nickname, Servercito srvEscucha){
        if(!clientes.contains(nickname)){
            clientes.add(nickname);
        }
        
        clientes_activos.put(nickname, srvEscucha);
        
        ArrayList<MensajeDeRed> msj_pendientes = mensajes_pendientes.get(nickname);
        if (msj_pendientes != null) {
            while(!msj_pendientes.isEmpty()) {
                srvEscucha.enviarMensaje(msj_pendientes.get(0));
                msj_pendientes.remove(0);
            }
            mensajes_pendientes.remove(nickname);
        }
    }
    
    public synchronized void eliminarClienteActivo(String nickname) {
        clientes_activos.remove(nickname);
    }
    
    public synchronized ArrayList<String> obtenerListaClientes() {
        return clientes;
    }
    
    @Override
    public void run() {
        try {
            this.iniciarServidor(10000);
        } catch (IOException ex) {
            System.out.println("Servidor no se pudo conectar");
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}