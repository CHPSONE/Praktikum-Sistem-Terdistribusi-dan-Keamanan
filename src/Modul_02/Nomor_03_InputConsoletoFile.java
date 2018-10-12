/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_02;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_03_InputConsoletoFile {
    public static void main(String[] args) throws IOException {
        try{
            String destination = "d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 02/Nomor_03.txt";
            OutputStream output = new FileOutputStream(destination);
            System.out.println("Opened "+destination+" for writing\n");

            System.out.println("Write your data... ");

            InputStream input = System.in;
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufReader = new BufferedReader(reader);
            String data = bufReader.readLine();

            for(int i=0; i<data.length(); i++){
                output.write((byte) data.charAt(i));
            }

            output.close();
            System.out.println("\nOutput stream closed");
        }catch(IOException ioe){
            System.out.println("I/O error : "+ioe);
        }
    }
}
