/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_10;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author CHP_SONE
 */
public class Contoh_02_Server {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);

        Contoh_01_Data data = new Contoh_01_Data();
        registry.rebind("Data", data);

        System.out.println("Server is running");
    }
}
