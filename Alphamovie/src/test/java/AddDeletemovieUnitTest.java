/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Date;

import model.pojo.Movie;
import model.pojo.Users;
import service.AdminService;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TRathC
 */
public class AddDeletemovieUnitTest {
   
    @Test
    public void test()
    {
        byte[] img = {0x0};
        //Create 2 user
        Users admin = new Users("admin", "admin", "admin.email", "000-000-0000", true);
        Users user = new Users("user","user", "user.email", "111-111-1111", false);
        
        //add Movie
        Movie movie1 = new Movie("MovieA", "0-0-0000", "TypeA", 1, "SynopsisA", img);
        Movie movie2 = new Movie("MovieB", "0-0-0000", "TypeB", 2, "SynopsisB", img);

        
        Movie movie1adminadd = AdminService.adminAddMovie(admin,movie1);
        Movie movie2adminadd = AdminService.adminAddMovie(admin,movie2);
        Movie movie1useradd = AdminService.adminAddMovie(user,movie1);
        String movie2admindelete = AdminService.adminDeleteMovie(admin,movie2adminadd.getMname());
        
        assertEquals(movie1,movie1adminadd);
        
        assertNotSame(movie2adminadd,movie1adminadd);
        
        assertEquals(null,movie1useradd);
        
        assertEquals(movie2adminadd.getMname(),movie2admindelete);
        
    }
    
}
