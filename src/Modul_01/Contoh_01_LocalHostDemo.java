/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_01;

/**
 *
 * @author LAB_TI
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Contoh_01_LocalHostDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Looking up local host");
        InetAddress localAddress = InetAddress.getLocalHost();
        System.out.println("Name: "+localAddress.getHostName());
        System.out.println("IP Address: "+localAddress.getHostAddress());
        System.out.println(localAddress);
    }

}
