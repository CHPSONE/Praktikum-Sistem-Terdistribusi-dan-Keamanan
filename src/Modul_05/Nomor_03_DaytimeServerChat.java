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
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_03_DaytimeServerChat {
    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(SERVICE_PORT);
            System.out.println("Daytime service started");
            boolean run=true;
            while (run) {
                Socket nextClient = ss.accept();
                System.out.println("Received request from :\n" + "Alamat \t : " + nextClient.getInetAddress() + " :" + "Port \t : " + nextClient.getPort());
                BufferedReader br = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
                String data = br.readLine();

                System.out.println("Result \t : " + data);
                OutputStream os = nextClient.getOutputStream();
                PrintStream ps = new PrintStream(os);
                if (data.equalsIgnoreCase("assalamualaikum")) {
                    ps.println("waalaikumsalam");
                } else {
                    ps.println(data + " juga");
                }
                os.flush();
                os.close();
                nextClient.close();

//                if(br.readLine().equalsIgnoreCase("exit")){
//                    run=false;
//                }
            }
        } catch (BindException be) {
            System.out.println("Error " + be);
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }
}
