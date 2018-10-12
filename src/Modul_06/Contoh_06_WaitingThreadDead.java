/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_06;

/**
 *
 * @author CHP_SONE
 */
public class Contoh_06_WaitingThreadDead extends Thread{
    public void run(){
        System.out.println("This thread feels a little ill...");

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ie){
            System.out.println(ie);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread dying = new Contoh_06_WaitingThreadDead();
        dying.start();

        System.out.println("Waiting for thread death");

        dying.join();
        System.out.println("Thread has died");
    }
}
