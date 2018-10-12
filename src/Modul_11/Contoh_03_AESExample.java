/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul_11;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author CHP_SONE
 */
public class Contoh_03_AESExample {
    static Cipher cipher;

    public static String encrypt(String plainText, SecretKey secretKey) throws Exception{
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }
    
    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception{
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
    
    public static void main(String[] args) throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("AES");
        
        String plainText = "AES Symmetric Encryption Decryption";
        System.out.println("Plain Text before Encryption   \t: "+plainText);
        
        String encryptedText = encrypt(plainText, secretKey);
        System.out.println("Encrypted Text after Encryption\t: "+encryptedText);
        
        String decryptedText = decrypt(encryptedText, secretKey);
        System.out.println("Decrypted Text after Decryption\t: "+decryptedText);
    }
}
