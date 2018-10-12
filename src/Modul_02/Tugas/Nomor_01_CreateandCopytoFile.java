/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_02.Tugas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_01_CreateandCopytoFile {
    public static void main(String[] args) throws IOException {
        try{            
            String destination = "d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 02/Tugas_Nomor_01.txt";
            OutputStream fileOutput = new FileOutputStream(destination);

            String source = "d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 02/writedocument.txt";
            InputStream fileInput = new FileInputStream(source);
            System.out.println("Copy data from "+source+" to "+destination+"\n");

            System.out.println("Data file "+destination);
            String d = "";

            int data = fileInput.read();
            while(data!=-1){
                char z =(char)data;
                data = fileInput.read();
                d += z;
            }

            for(int i=0; i<d.length(); i++){
                fileOutput.write((byte)d.charAt(i));
            }

            System.out.print(d+"\n");

            fileInput.close();
            fileOutput.close();
        }catch(IOException ioe){
            System.out.println("I/O error : "+ioe);
        }
    }
}
