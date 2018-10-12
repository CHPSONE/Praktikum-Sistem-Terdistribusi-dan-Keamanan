/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_10;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author CHP_SONE
 */
public class Contoh_01_Data extends UnicastRemoteObject implements Contoh_01_DataInterface{
    public Contoh_01_Data() throws RemoteException{

    }

    public void FirstMethod() throws RemoteException {
        System.out.println("Running First Method");
    }

    public void SecondMethod() throws RemoteException {
        System.out.println("Running Second Method");
    }

}
