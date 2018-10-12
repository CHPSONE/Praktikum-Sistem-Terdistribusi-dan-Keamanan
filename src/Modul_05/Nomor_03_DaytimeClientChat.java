/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_03_DaytimeClientChat {

    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        try {

            boolean run=true;
            while (run) {

                String hostname = "localhost";
                Socket daytime = new Socket(hostname, SERVICE_PORT);
                System.out.println("Connection established");
                daytime.setSoTimeout(2000);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String kata = br.readLine();
                System.out.println("Data yang diinputkan : " + kata);

                OutputStream os = daytime.getOutputStream();
                PrintStream ps = new PrintStream(os);
                ps.println(kata);
                String pesan;
                BufferedReader br1 = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
                System.out.println("result\t: " + br1.readLine());
                System.out.println("");
                os.flush();
                os.close();
                daytime.close();

//                if(br1.readLine().equalsIgnoreCase("exit")){
//                    run=false;
//                }
            }

        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }
}
