/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_01.Tugas;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_03_ScanIP {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Scan IP");
        String input = "192.168.1.0";
        String output = null;
        try {
            
            InetAddress local = InetAddress.getByName(input);
            byte[] ip = local.getAddress();

            for (int i = 1; i <= 254; i++) {
                InetAddress address = InetAddress.getByAddress(ip);
                ip[3]=(byte)i;
                output = address.toString();

                if(address.isReachable(3000)){
                    System.out.println(output+" is Active");
                }else{
                    System.out.println(output+" is not Active");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
