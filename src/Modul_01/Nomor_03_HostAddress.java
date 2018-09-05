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

public class Nomor_03_HostAddress {
    public static void main(String[] args) throws UnknownHostException, java.lang.SecurityException {
        System.out.println("Looking Up Host Address");
        try {
            String host = "localhost";
            InetAddress[] ia = InetAddress.getAllByName(host);

            System.out.println("Host Name: "+host);
            System.out.print("Host Address: ");

            for (int i = 0; i < ia.length; i++) {
                System.out.println(ia[i]);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
