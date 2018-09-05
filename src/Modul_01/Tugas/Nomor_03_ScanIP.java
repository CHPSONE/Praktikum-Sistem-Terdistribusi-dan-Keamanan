/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_01.Tugas;

import java.net.InetAddress;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_03_ScanIP {
    public static void main(String[] args) {
        System.out.println("Scan IP");
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
