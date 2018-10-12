/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_06;

import java.io.IOException;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_03_KirimRunnable extends Thread implements Runnable{
    public void run(){
        int count;
        System.out.println("Bilangan Ganjil");
        for(count=1; count<=20; count++){
            if(count%2 != 0){
                System.out.print(count++ + " ");
            }
            
            try{
                Thread.sleep(500);
            }catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Thread counter = new Nomor_03_KirimRunnable();
        counter.start();
    }
}
