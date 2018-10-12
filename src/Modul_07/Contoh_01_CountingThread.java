/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_07;

/**
 *
 * @author CHP_SONE
 */
public class Contoh_01_CountingThread implements Runnable {
    Contoh_01_Counter myCounter;
    int countAmount;

    public Contoh_01_CountingThread(Contoh_01_Counter counter, int amount){
        myCounter = counter;
        countAmount = amount;
    }

    public void run() {
        for(int i=1; i<=countAmount; i++){
            myCounter.increaseCount();
            System.out.print(myCounter.getCount()+" ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Contoh_01_Counter c = new Contoh_01_Counter();

        Runnable runner = new Contoh_01_CountingThread(c, 10);
        System.out.println("Starting counting threads");
        Thread t1 = new Thread(runner);
        Thread t2 = new Thread(runner);
        Thread t3 = new Thread(runner);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("\nCounter value is "+c.getCount());
    }
}
