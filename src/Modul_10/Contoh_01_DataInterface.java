/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_10;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author CHP_SONE
 */
public interface Contoh_01_DataInterface extends Remote{
    public void FirstMethod() throws RemoteException;
    public void SecondMethod() throws RemoteException;
}
