/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_02;

/**
 *
 * @author CHP_SONE
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Contoh_02_FileOutputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String destination = "d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 02/writedocument.txt";
        OutputStream output = new FileOutputStream(destination);
        System.out.println("Opened "+destination+" for writing");
        
        String data = "try to write data using output stream";
        for(int i=0; i<data.length(); i++){
            output.write((byte) data.charAt(i));
        }
        
        output.close();
        System.out.println("Output stream closed");
    }
}
