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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Contoh_01_FileInputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputStream fileInput = new FileInputStream("d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 02/document.txt");
        int data = fileInput.read();
        while(data!=-1){
            System.out.print((char)data);
            data = fileInput.read();
        }
        fileInput.close();
        System.out.println("");
    }
}
