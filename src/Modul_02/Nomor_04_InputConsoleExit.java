/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_04_InputConsoleExit {
    public static void main(String[] args) throws IOException {
        try{
            System.out.println("Masukkan Text. Ketik 'exit' untuk keluar");

            InputStream input = System.in;
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufReader = new BufferedReader(reader);
            String data = bufReader.readLine();

            boolean run = true;
            while(run){
                System.out.println("Anda menulis: "+data+"\n");

                if(data.equalsIgnoreCase("exit")){
                    run = false;
                    System.out.println("Terima Kasih");
                }else{
                        String data2 = bufReader.readLine();
                        data=data2;
                }
            }
        }catch(IOException ioe){
            System.out.println("I/O error : "+ioe);
        }
    }
}
