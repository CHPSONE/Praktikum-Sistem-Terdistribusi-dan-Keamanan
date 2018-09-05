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
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Contoh_05_ImageInputStreamDemo {
    public static void main(String[] args) {
        Image image = null;
        try{
            File sourceimage = new File("d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 02/Tiger Head.png");
            image = ImageIO.read(sourceimage);
        }catch(IOException e){
            System.out.println(e);
        }
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
