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

public class Contoh_02_InAddress {
    public static void main(String[] args) {
        try{
            System.out.println("# Get hostname from current IP");
            String ip = "127.0.0.1";
            System.out.println("Hostname from ip \""+ip+"\": "+InetAddress.getByName(ip).getHostName());

            System.out.println("\n# Get host address from current name");
            String host = "localhost";
            System.out.println("Host/IP: "+InetAddress.getByName(host).getHostAddress());
            System.out.println("Host/IP: "+InetAddress.getByName(host));

            System.out.println("\n# Check connection");
            InetAddress ia = InetAddress.getByName(host);
            if(ia.isReachable(3000)){
                System.out.println(ia+" is Reachable");
            }else{
                System.out.println(ia+" is UnReachable");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
