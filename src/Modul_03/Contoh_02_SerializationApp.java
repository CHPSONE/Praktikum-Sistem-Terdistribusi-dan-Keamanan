/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_03;

/**
 *
 * @author CHP_SONE
 */
import java.util.ArrayList;
import java.util.List;

public class Contoh_02_SerializationApp {
    public static void main(String[] args) throws ClassNotFoundException {
        List<Contoh_02_Participant> participants = new ArrayList<Contoh_02_Participant>();

        participants.add(new Contoh_02_Participant("Dee","Aja",22));
        participants.add(new Contoh_02_Participant("Ani","Fahmi",21));
        participants.add(new Contoh_02_Participant("Haya","Hayati",20));
        participants.add(new Contoh_02_Participant("Aya","Hayati",19));

        System.out.println("Participant: "+ participants +"\n");

        Contoh_02_SerializationDemo demo = new Contoh_02_SerializationDemo();
        demo.serialize(participants, "d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 03/participantData.ser");
        System.out.println("Serialization is Done\n");

        System.out.println("Deserialize Object...");
        List<Contoh_02_Participant> newList = demo.deserialize("d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 03/participantData.ser");
        System.out.println("New List: "+newList);
    }
}
