/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_04;

/**
 *
 * @author CHP_SONE
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Contoh_05_EchoServer {
    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 4096;
    private DatagramSocket socket;

    public Contoh_05_EchoServer(){
        try{
            socket = new DatagramSocket(SERVICE_PORT);
            System.out.println("Server active on port "+socket.getLocalPort());
        }catch(Exception e){
            System.out.println("Unable to bind port");
        }
    }

    public void serviceClients(){
        byte[] buffer = new byte[BUFSIZE];
        for(;;){
            try{
                DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                socket.receive(packet);
                System.out.println("Packet received from "+packet.getAddress()+":"+packet.getPort()+" of length "+packet.getLength());
                socket.send(packet);
            }catch(IOException ioe){
                System.out.println("Error: "+ioe);
            }
        }
    }

    public static void main(String[] args) {
        Contoh_05_EchoServer server = new Contoh_05_EchoServer();
        server.serviceClients();
    }
}
