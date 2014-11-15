/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Timestamp;
import java.util.Date;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author TRathC
 */
public class UsersService {
    
    public static String[] seatArray(String seatname){
        int n = seatname.length()/3;
        String[] seatarray=new String[n];
        int substr=0;
        for(int i=0;i<n;i++){
            seatarray[i] = seatname.substring(substr,substr+3);
            substr+=3;
        }
        return seatarray;
    }
    
    public static String generateSession(String username){
        Timestamp currentTimestamp= new Timestamp(new Date().getTime());
        System.out.println(currentTimestamp);
        String session = username + currentTimestamp.toString();;
        Integer a = session.hashCode();
        return a.toString();
    }
    
    public static String generatePasswordHash(String username,String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = username.getBytes();
        
        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return BytestoString(hash);
    }
    
    private static String BytestoString(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }
}
