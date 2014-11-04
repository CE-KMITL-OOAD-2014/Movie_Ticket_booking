/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Date;
import model.dao.MovieDAO;
import model.pojo.Movie;
import model.pojo.Users;

/**
 *
 * @author TRathC
 */
public class AdminService {

    public static Movie adminAddMovie(Users user, Movie movie) {
        if (user.isIsadmin()) {
            return movie;
        } else {
            return null;
        }
    }
    
    public static String adminDeleteMovie(Users user, String moviename) {
        if (user.isIsadmin()) {
            return moviename;
        } else {
            return user.getUsername()+"Cannot Delete Movie";
        }
    }
}
