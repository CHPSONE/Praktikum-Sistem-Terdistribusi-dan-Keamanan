/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_05.Tugas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHP_SONE
 */
public class Client {
    public static final int SERVICE_PORT = 8;
    
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException{
        List<Mahasiswa> participants = new ArrayList<Mahasiswa>();
        String NIM, Nama, Asal, Kelas;
        
        SerializationDemo demo = new SerializationDemo();
        String direktori = "d:/DataMahasiwa.ser";

        String hostname = "localhost";
        Socket daytime = new Socket(hostname, SERVICE_PORT);
        System.out.println("Connection established\n");

        daytime.setSoTimeout(4000);
        
            System.out.println("Menu");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Save");
            System.out.println("5. Print");
            System.out.println("6. Send Data to Server");
            System.out.println("Ketik 'exit' untuk keluar!\n");
            
        boolean run = true;
        while(run){
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("======================================\nPilih menu...");
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
                OutputStream out = daytime.getOutputStream();
                PrintStream p = new PrintStream(out);
                p.print(participants+ "\nOn\t:" + new java.util.Date());

                out.flush();
                out.close();
                daytime.close();
                System.out.println("Data send!");
            }else if(id.equalsIgnoreCase("exit")){
                OutputStream out = daytime.getOutputStream();
                PrintStream p = new PrintStream(out);
                p.print(id+ "\nOn\t:" + new java.util.Date());

                out.flush();
                out.close();
                daytime.close();
                run=false;
            }
        }
    }
}
