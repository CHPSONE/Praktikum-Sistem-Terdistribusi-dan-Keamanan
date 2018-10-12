/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_07;

/**
 *
 * @author CHP_SONE
 */
public class Contoh_01_Counter {
    private int countValue;

    public Contoh_01_Counter(){
        countValue = 0;
    }

    public Contoh_01_Counter(int start){
        countValue = start;
    }

    public synchronized void increaseCount(){
        int count = countValue;

        try{
            Thread.sleep(5);
        }catch(InterruptedException ie){
            System.out.println(ie);
        }

        count += 1;
        countValue = count;
    }

    public synchronized int getCount(){
        return countValue;
    }
}
