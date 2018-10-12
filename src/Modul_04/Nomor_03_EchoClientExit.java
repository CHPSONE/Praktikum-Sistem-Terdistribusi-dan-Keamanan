/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_04;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_03_EchoClientExit {
    public static final int SERVICE_PORT = 8;
    public static final int BUFSIZE = 256;

    public static void main(String[] args) throws SocketException, IOException{
        String hostname = "localhost";
        InetAddress addr = InetAddress.getByName(hostname);

        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(2000);
        
        boolean run = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(run){
            System.out.println("Write your message here...");
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            PrintStream pout = new PrintStream(bout);
            pout.print(reader.readLine());

            byte[] barray = bout.toByteArray();

            DatagramPacket packet = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
            System.out.println("\nSending packet to "+hostname+"\n");
            socket.send(packet);

            System.out.println("Waiting for packet...\n");

            byte[] recbuf = new byte[BUFSIZE];

            DatagramPacket receivePacket = new DatagramPacket(recbuf, BUFSIZE);

            boolean timeout = false;
            try{
                socket.receive(receivePacket);
                
                String data = new String(receivePacket.getData(), 0, receivePacket.getLength());
                if(data.equals("exit")){
                    socket.close();
                    run = false;
                }
            }catch(InterruptedIOException ioe){
                timeout = true;
            }

            if(!timeout){
                System.out.println("Packet received!");
                System.out.println("Details : "+receivePacket.getAddress());

                ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData(), 0, receivePacket.getLength());

                BufferedReader reader2 = new BufferedReader(new InputStreamReader(bin));
                System.out.println(reader2.readLine()+"\n===================================\n");
            }else{
                System.out.println("Packet lost!\n===================================\n");
            }
        }
    }
}
