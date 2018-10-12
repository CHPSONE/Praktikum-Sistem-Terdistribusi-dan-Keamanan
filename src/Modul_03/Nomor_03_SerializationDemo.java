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
import java.util.List;

public class Nomor_03_SerializationDemo {
    public void serialize(List<Nomor_03_Participant> pList, String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(pList);
        }catch(IOException ex){
            System.out.println("A Problem Occured during Serialization\n"+ex.getMessage());
        }
    }

    public List<Nomor_03_Participant> deserialize(String fileName) throws ClassNotFoundException{
        List<Nomor_03_Participant> pList = null;
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            pList = (List<Nomor_03_Participant>) in.readObject();
        }catch(IOException ex){
            System.out.printf("A Problem Occured during Deserializing %s%n", fileName);
            System.out.println(ex.getMessage());
        }
        return pList;
    }
}
