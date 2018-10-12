/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_10;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author CHP_SONE
 */
public class Contoh_03_Client {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        Contoh_01_DataInterface data = (Contoh_01_DataInterface) Naming.lookup("rmi://localhost:1099/data");
        System.out.println("Client is connect to Server");

        data.FirstMethod();
        data.SecondMethod();

        System.out.println("Finish");
    }
}
