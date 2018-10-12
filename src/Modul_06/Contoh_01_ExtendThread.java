/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_06;

/**
 *
 * @author CHP_SONE
 */
public class Contoh_01_ExtendThread extends Thread{
    int threadNumber;

    public Contoh_01_ExtendThread(int num){
        threadNumber = num;
    }

    public void run(){
        System.out.println("I'm thread number: "+threadNumber);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            System.out.println(threadNumber+" is finished");
        }

        System.out.println(threadNumber+" is finished");
    }

    public static void main(String[] args) {
        System.out.println("Creating thread 1");
        Thread t1 = new Contoh_01_ExtendThread(1);

        System.out.println("Creating thread 2");
        Thread t2 = new Contoh_01_ExtendThread(2);

        t1.start();
        t2.start();
    }
}
