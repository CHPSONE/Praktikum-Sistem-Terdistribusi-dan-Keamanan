/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_05.Tugas;

/**
 *
 * @author CHP_SONE
 */
import java.io.Serializable;

public class Mahasiswa implements Serializable{
    private final String NIM;
    private final String Nama;
    private final String Asal;
    private final String Kelas;

    public Mahasiswa(String NIM, String Nama, String Asal, String Kelas){
        this.NIM = NIM;
        this.Nama = Nama;
        this.Asal = Asal;
        this.Kelas = Kelas;
    }

    public String getNIM(){
        return NIM;
    }

    public String getNama(){
        return Nama;
    }

    public String getAsal(){
        return Asal;
    }

    public String getKelas(){
        return Kelas;
    }

    @Override
    public String toString(){
        return NIM + " - " + Nama + ". " + Asal + ". Kelas " + Kelas + "\n";
    }
}
