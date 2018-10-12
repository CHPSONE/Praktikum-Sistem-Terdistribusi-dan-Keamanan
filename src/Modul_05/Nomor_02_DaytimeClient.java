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

/**
 *
 * @author CHP_SONE
 */
public class Nomor_02_DaytimeClient {
    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {
        try{

            boolean run=true;
            while(run){
                String hostname = "localhost";

                Socket daytime = new Socket(hostname, SERVICE_PORT);

                daytime.setSoTimeout(3000);
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                String data = null;

                System.out.println("\nWrite your message...");
                data = input.readLine();

                OutputStream out = daytime.getOutputStream();
                PrintStream p = new PrintStream(out);
                p.print(data+ "\nOn\t:" + new java.util.Date());

                out.flush();
                out.close();
                daytime.close();

                if(data.equalsIgnoreCase("exit")){
                    run=false;
                }
            }
        }catch(IOException ioe){
            System.out.println("Error "+ioe);
        }
    }
}
