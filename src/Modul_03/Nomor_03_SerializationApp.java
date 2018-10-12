/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_03_SerializationApp {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        List<Nomor_03_Participant> participants = new ArrayList<Nomor_03_Participant>();

        String first = null, last = null, age;
        int g = 0;
        
            first = JOptionPane.showInputDialog("Masukkan Nama Depan!");
            last = JOptionPane.showInputDialog("Masukkan Nama Belakang!");
            age = JOptionPane.showInputDialog("Masukkan Umur!");
            g = Integer.parseInt(age);

            participants.add(new Nomor_03_Participant(first, last, g));
   

            JOptionPane.showMessageDialog(null, "Participant: "+ participants +"\n");
//        System.out.println("Participant: "+ participants +"\n");

        Nomor_03_SerializationDemo demo = new Nomor_03_SerializationDemo();
        demo.serialize(participants, "d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 03/participantDataConsole.ser");
        System.out.println("Serialization is Done\n");

        System.out.println("Deserialize Object...");
        List<Nomor_03_Participant> newList = demo.deserialize("d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 03/participantDataConsole.ser");
        System.out.println("New List: "+newList);
    }
}
