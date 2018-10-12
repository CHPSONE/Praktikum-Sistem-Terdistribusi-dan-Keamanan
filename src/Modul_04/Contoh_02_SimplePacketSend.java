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
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Contoh_02_SimplePacketSend {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException{
        DatagramSocket socket = new DatagramSocket();

        String message = "Assalamu'alaikum wr wb";

        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getLocalHost(), 2000);

        socket.send(packet);
        socket.close();
    }
}
