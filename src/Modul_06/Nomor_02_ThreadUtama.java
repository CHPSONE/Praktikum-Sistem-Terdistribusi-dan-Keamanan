/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_06;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_02_ThreadUtama {
    public static void main(String[] args) {
        Thread t1 = new Nomor_02_Kirim();
        Thread t2 = new Nomor_02_Terima();
        
        t1.start();
        t2.start();
    }
}
