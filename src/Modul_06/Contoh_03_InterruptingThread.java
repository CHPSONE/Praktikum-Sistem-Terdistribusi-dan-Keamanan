/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_06;

import java.io.IOException;

/**
 *
 * @author CHP_SONE
 */
public class Contoh_03_InterruptingThread extends Thread{
    public void run(){
        System.out.println("I feel sleepy. Wake me in eight hours");

        try{
            Thread.sleep(1000 * 60 * 60 * 8);
            System.out.println("That was a nice nap");
        }catch(InterruptedException ie){
            System.out.println("Just five more minute....");
        }
    }

    public static void main(String[] args) throws IOException {
        Thread sleepy = new Contoh_03_InterruptingThread();

        sleepy.start();

        System.out.println("Press enter to interrupt the thread");
        System.in.read();
        
        sleepy.interrupt();
    }
}
