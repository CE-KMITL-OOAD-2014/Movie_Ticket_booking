/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.pojo.Movie;
import model.pojo.Users;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import service.AdminService;
import service.MovieService;

/**
 *
 * @author TRathC
 */
public class MovieListUnitTest {
    
    @Test
    public void Test(){
        
        byte[] img = {0x0};
        List<Movie> mlist = new ArrayList<Movie>();
        
        Users admin = new Users("admin", "admin", "admin.email", "000-000-0000", true);
        Users user1 = new Users("user1","user1", "user1.email", "111-111-1111", false);
        Users user2 = new Users("user2","user2", "user2.email", "111-111-1111", false);
        
        Movie movie1 = new Movie("MovieA", "0-0-0000", "TypeA", 1, "SynopsisA", img);
        Movie movie2 = new Movie("MovieB", "0-0-0000", "TypeB", 2, "SynopsisB", img);
        Movie movie3 = new Movie("MovieC", "0-0-0000", "TypeC", 3, "SynopsisC", img);
        Movie movie4 = new Movie("MovieD", "0-0-0000", "TypeD", 4, "SynopsisD", img);
        
        assertEquals(true,mlist.add(AdminService.adminAddMovie(admin, movie1)));
        assertEquals(true,mlist.add(AdminService.adminAddMovie(admin, movie2)));
        assertEquals(true,mlist.add(AdminService.adminAddMovie(admin, movie3)));
        assertEquals(true,mlist.add(AdminService.adminAddMovie(admin, movie4)));

        /*List <Movie> listforuser1 = MovieService.allMovie(user1,mlist);
        List <Movie> listforuser2 = MovieService.allMovie(user2,mlist);
        
        assertEquals(listforuser1, listforuser2);
        assertEquals(movie1,listforuser1.get(0));
        assertEquals(movie2,listforuser1.get(1));
        assertEquals(movie3,listforuser1.get(2));
        assertEquals(movie4,listforuser1.get(3));
        assertEquals(movie1,listforuser2.get(0));
        assertEquals(movie2,listforuser2.get(1));
        assertEquals(movie3,listforuser2.get(2));
        assertEquals(movie4,listforuser2.get(3));*/
    }
}
