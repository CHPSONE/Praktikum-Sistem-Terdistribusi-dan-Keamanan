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
public class Contoh_04_StoppingThread extends Thread {
    public void run(){
        int count = 1;

        System.out.println("I can count. Watch me go!");
        for(;;){
            System.out.print(count++ + " ");

            try{
                Thread.sleep(500);
            }catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Thread counter = new Contoh_04_StoppingThread();
        counter.start();

        System.out.println("Press any enter to stop the thread counting");
        System.in.read();

        counter.stop();
    }
}
