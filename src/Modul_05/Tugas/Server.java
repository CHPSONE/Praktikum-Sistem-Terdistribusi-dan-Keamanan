/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_05.Tugas;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author CHP_SONE
 */
public class Server {
    public static final int SERVICE_PORT = 8;

    public void serviceClients() throws IOException, ClassNotFoundException{
        ServerSocket server = new ServerSocket(SERVICE_PORT);
        System.out.println("Service started");
        boolean run = true;
        while (run) {
            try {
                Socket nextClient = server.accept();

                System.out.println("Received request from "+nextClient.getInetAddress()+nextClient.getPort());
                
                BufferedReader in = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
                String pesan = in.readLine();
                System.out.println("pesan masuk\t : " + pesan);
                nextClient.close();
                
                if(pesan.equalsIgnoreCase("exit")){
                    run = false;
                }else{
                    try{
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:/dataBaru.ser"));
                        for(int i=0; i<pesan.length(); i++){
                            out.writeObject(pesan);
                        }
                        out.flush();
                        out.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
            }catch(BindException be){
                System.err.println("Service already running on port "+SERVICE_PORT);
            } catch (IOException ioe) {
                System.out.println("Error: " + ioe);
            }
        }
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
        server.serviceClients();
    }
}
