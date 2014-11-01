/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.dao.MovieDAO;
import model.pojo.Movie;
import model.pojo.Users;

/**
 *
 * @author TRathC
 */
public class MovieService {
    
    public static String addMovie(Movie movie){
        return MovieDAO.addMovie(movie);
    }
    
    public static List<Movie> allMovie(Users user,List<Movie> mlist){
        if(UsersService.login(user)!=null);
        List<Movie> lst = mlist;
        return lst;
    }
}
