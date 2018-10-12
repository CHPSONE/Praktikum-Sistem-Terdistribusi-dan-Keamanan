/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_05;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_02_DaytimeServer {
    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {
        try {
            boolean run = true;
            ServerSocket server = new ServerSocket(SERVICE_PORT);
            System.out.println("Connection established");
            while (run) {
                Socket nextClient = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
                String pesan = in.readLine();
                System.out.println("pesan dari \t :" + nextClient.getInetAddress() + " " + nextClient.getPort());
                System.out.println("pesan masuk\t : " + pesan);
                nextClient.close();

                if(pesan.equalsIgnoreCase("exit")){
                    run=false;
                }
            }
        } catch (BindException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }
    }
}
