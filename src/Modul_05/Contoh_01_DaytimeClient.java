/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author CHP_SONE
 */
public class Contoh_01_DaytimeClient {
    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {
        try{
            String hostname = "localhost";

            Socket daytime = new Socket(hostname, SERVICE_PORT);
            System.out.println("Connection established");

            daytime.setSoTimeout(2000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
            System.out.println("Result: "+reader.readLine());
        }catch(IOException ioe){
            System.out.println("Error "+ioe);
        }
    }
}
