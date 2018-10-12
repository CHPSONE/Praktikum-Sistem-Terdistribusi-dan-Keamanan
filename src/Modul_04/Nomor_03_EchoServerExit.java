/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_03_EchoServerExit {

    public static final int SERVICE_PORT = 8;
    public static final int BUFSIZE = 4096;
    private DatagramSocket socket;

    public Nomor_03_EchoServerExit() {
        try {
            socket = new DatagramSocket(SERVICE_PORT);
            System.out.println("Server active on port " + socket.getLocalPort());
        } catch (Exception e) {
            System.out.println("Unable to bind port");
        }
    }

    public void serviceClients() throws IOException {
        byte[] buffer = new byte[BUFSIZE];
        boolean run = true;
        while (run) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                socket.receive(packet);
                System.out.println("Packet received from " + packet.getAddress() + ":" + packet.getPort() + " of length " + packet.getLength());
                
                String data = new String(packet.getData(), 0, packet.getLength());
                if(data.equals("exit")){
                    run = false;
                }
                
                socket.send(packet);
            } catch (IOException ioe) {
                System.out.println("Error: " + ioe);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Nomor_03_EchoServerExit server = new Nomor_03_EchoServerExit();
        server.serviceClients();
    }
}
