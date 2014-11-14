/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import model.dao.UsersDAO;
import model.pojo.Movie;
import model.pojo.Users;

/**
 *
 * @author TRathC
 */
public class UsersService {
    
    public static Users register(Users user) throws Exception{
        return UsersDAO.addorupdateUser(user);
    }
    
    public static Users editInformation(Users user){
        return UsersDAO.addorupdateUser(user);
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
