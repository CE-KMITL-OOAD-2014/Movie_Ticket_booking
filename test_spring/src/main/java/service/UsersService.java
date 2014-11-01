/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import model.dao.UsersDAO;
import model.pojo.Movie;
import model.pojo.Users;

/**
 *
 * @author TRathC
 */
public class UsersService {
    
    public static String register(Users user) throws Exception{
        return UsersDAO.addUser(user);
    }
    
    public static String editInformation(Users user){
        return UsersDAO.updateUser(user);
    }
    
    public static String login(Users user){
        String session = null;
        return session;
    }
    
    public static String hash(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(pass.getBytes());

        byte byteData[] = md.digest();
        
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
