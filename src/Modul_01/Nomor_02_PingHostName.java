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
import java.io.IOException;
import javax.swing.*;

public class Nomor_02_PingHostName {
    public static void main(String[] args) throws UnknownHostException, IOException {
        String host = JOptionPane.showInputDialog("Pilih Host! \n1. Host Name\n2. Host Address");
        int h = Integer.parseInt(host);
        switch (h){
            case 1: String name = JOptionPane.showInputDialog("Masukkan Host Name!");
                    InetAddress n = InetAddress.getByName(name);
                    if(n.isReachable(3000)){
                        JOptionPane.showMessageDialog(null, n+" is Reachable");
                    }else{
                        JOptionPane.showMessageDialog(null, n+" is UnReachable");
                    }
                break;
            case 2: String address = JOptionPane.showInputDialog("Masukkan Host Address!");
                    InetAddress a = InetAddress.getByName(address);
                    if(a.isReachable(3000)){
                        JOptionPane.showMessageDialog(null, a+" is Reachable");
                    }else{
                        JOptionPane.showMessageDialog(null, a+" is UnReachable");
                    }
                break;
            default : JOptionPane.showMessageDialog(null, "Host tidak ada");
        }
        System.exit(0);
    }
}
