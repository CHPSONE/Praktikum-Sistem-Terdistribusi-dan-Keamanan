/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_02;

/**
 *
 * @author CHP_SONE
 */
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Contoh_06_AudioInputStreamDemo {
    public static void main(String[] args) throws Exception {
        String audioFile = "d:/UIN Maliki Malang/Semester 5/Sistem Terdistribusi & Keamanan/Praktikum/Modul 02/Seo Juhyun - Morning Call.mp3";
        
        InputStream in = new FileInputStream(audioFile);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }
}
