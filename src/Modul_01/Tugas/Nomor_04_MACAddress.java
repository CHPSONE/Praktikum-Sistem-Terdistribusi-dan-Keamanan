/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_01.Tugas;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.NetworkInterface;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_04_MACAddress {
     public static void main(String[] args) throws UnknownHostException {
        try {
            String input = "10.5.80.184";
            InetAddress n = InetAddress.getByName(input);
            NetworkInterface mac = NetworkInterface.getByInetAddress(n);
            byte[] host = mac.getHardwareAddress() ;
                
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < host.length; i++) {
                sb.append(String.format("%02X%s", host[i], (i < host.length - 1) ? "-" : ""));		
            }
                
            System.out.println("Mac Address: "+sb.toString());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
