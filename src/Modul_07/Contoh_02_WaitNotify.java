/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_07;

import java.io.IOException;

/**
 *
 * @author CHP_SONE
 */
public class Contoh_02_WaitNotify extends Thread{
    public void run(){
        System.out.println("Hit enter to stop waiting thread");
        try{
            System.in.read();
        }catch(IOException ioe){
            System.out.println(ioe);
        }

        synchronized (this){
            this.notifyAll();
        }

        System.out.println("The wait is over");
    }
    
    public static void main(String[] args) throws Exception{
        Thread notificationThread = new Contoh_02_WaitNotify();
        notificationThread.start();

        synchronized (notificationThread){
            notificationThread.wait();
        }
    }
}
