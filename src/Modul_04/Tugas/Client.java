/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_04.Tugas;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHP_SONE
 */
public class Client {
    public static final int SERVICE_PORT = 8;
    public static final int BUFSIZE = 256;
    
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException{
        List<Mahasiswa> participants = new ArrayList<Mahasiswa>();
        String NIM, Nama, Asal, Kelas;
        
        SerializationDemo demo = new SerializationDemo();
        String direktori = "d:/DataMahasiwa.ser";

    
        String hostname = "localhost";
        InetAddress addr = InetAddress.getByName(hostname);

        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(2000);
        
        boolean run = true;
        
            System.out.println("Menu");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Save");
            System.out.println("5. Print");
            System.out.println("6. Send Data to Server");
            System.out.println("Ketik 'exit' untuk keluar!\n");
            
        
        while(run){
            System.out.print("======================================\nPilih menu...");
            InputStream input = System.in;
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufReader = new BufferedReader(reader);
            String id = bufReader.readLine();
            int idx;
            
            if(id.equalsIgnoreCase("1")){
                System.out.println("\nInsert data");
                System.out.print("Masukkan NIM: ");
                NIM = bufReader.readLine();
                
                System.out.print("Masukkan Nama: ");
                Nama = bufReader.readLine();
                
                System.out.print("Masukkan Asal: ");
                Asal = bufReader.readLine();
                
                System.out.print("Masukkan Kelas: ");
                Kelas = bufReader.readLine();
                
                participants.add(new Mahasiswa(NIM, Nama, Asal, Kelas));
                System.out.println("\n"+participants);
                
//                demo.serialize(participants, direktori);
            }else if(id.equalsIgnoreCase("2")){
                System.out.print("\nUpdate data Index: ");
                idx = Integer.parseInt(bufReader.readLine());
                if(idx>participants.size()-1){
                    System.out.println("Not Found!");
                    break;
                }
                
                System.out.print("Data: "+participants.get(idx));
                System.out.print("Masukkan NIM: ");
                NIM = bufReader.readLine();
                
                System.out.print("Masukkan Nama: ");  
                Nama = bufReader.readLine();
                
                System.out.print("Masukkan Asal: ");    
                Asal = bufReader.readLine();
                
                System.out.print("Masukkan Kelas: ");  
                Kelas = bufReader.readLine();
                
                Mahasiswa m = new Mahasiswa (NIM, Nama, Asal, Kelas);
                participants.remove(idx);
                participants.add(idx, m);
                System.out.println("\n"+participants);
                
//                demo.serialize(participants, direktori);
            }else if(id.equalsIgnoreCase("3")){
                System.out.print("\nDelete data Index: ");
                idx = Integer.parseInt(bufReader.readLine());
                if(idx>participants.size()-1){
                    System.out.println("Not Found!");
                    break;
                }
                
                Mahasiswa m = participants.get(idx);
                participants.remove(idx);
                System.out.println("\n"+participants);
                
//                demo.serialize(participants, direktori);
            }else if(id.equalsIgnoreCase("4")){
                System.out.println("\nSerializing...");
                demo.serialize(participants, direktori);
                System.out.println("Serialize finish");
            }else if(id.equalsIgnoreCase("5")){
                System.out.println("\nDeserializing...");
                
                int i = 0;
                for (Mahasiswa mhs : demo.deserialize(direktori)) {
                    System.out.printf("%d. %s", i++, mhs);
                    System.out.println("");
                }
            }else if(id.equalsIgnoreCase("6")){
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                PrintStream pout = new PrintStream(bout);
                pout.print(participants);

                byte[] barray = bout.toByteArray();

                DatagramPacket packet = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
                System.out.println("\nSending packet...");
                socket.send(packet);
                System.out.println(packet+" send!");
            }else if(id.equalsIgnoreCase("exit")){
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                PrintStream pout = new PrintStream(bout);
                pout.print(id);

                byte[] barray = bout.toByteArray();

                DatagramPacket packet = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
                socket.send(packet);    
                socket.close();
                run=false;
            }
        }
    }
}
