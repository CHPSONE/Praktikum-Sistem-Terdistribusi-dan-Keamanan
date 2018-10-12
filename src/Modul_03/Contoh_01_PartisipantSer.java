/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_03;

/**
 *
 * @author CHP_SONE
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Contoh_01_PartisipantSer implements Serializable {
    private String firstName;
    private String lastName;
    private int age;

    public Contoh_01_PartisipantSer(String firstName, String lastName, int age){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }

    public void printData(){
        System.out.println("Nama\t: "+firstName+" "+lastName);
        System.out.println("Usia\t: "+age);
    }

    public void saveObject(Contoh_01_PartisipantSer Obj){
        try{
            FileOutputStream fos = new FileOutputStream("d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 03/data.ser");
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(Obj);
            ous.flush();
            ous.close();
        }catch(IOException ioe){
            System.out.println("A problem accured during serialize.\n"+ioe.getMessage());
        }
    }

    public void readObject(Contoh_01_PartisipantSer Obj) throws ClassNotFoundException{
        try{
            FileInputStream fis = new FileInputStream("d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 03/data.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Obj = (Contoh_01_PartisipantSer) ois.readObject();
            Obj.printData();
            fis.close();
        }catch(IOException ex){
            System.out.println("A problem occured during serialize.\n"+ex);
            System.exit(1);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Contoh_01_PartisipantSer is = new Contoh_01_PartisipantSer("Dee","aja",22);
        is.saveObject(is);
        is.readObject(is);
    }
}
