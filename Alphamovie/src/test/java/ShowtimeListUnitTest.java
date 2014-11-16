/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import model.pojo.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author TRathC
 */
public class ShowtimeListUnitTest {

    @Test
    public void Test() {

        //add Cinema
        Cinema cinema1 = new Cinema(50);
        cinema1.setCinema(1);
        Cinema cinema2 = new Cinema(70);
        cinema2.setCinema(2);

        //add Movie
        Movie movie1 = new Movie("MovieA", null, null, 0, null, null);
        Movie movie2 = new Movie("MovieB", null, null, 0, null, null);
        Movie movie3 = new Movie("MovieC", null, null, 0, null, null);
        Movie movie4 = new Movie("MovieD", null, null, 0, null, null);

        //add Showtime
        ShowtimeId showtimeid1 = new ShowtimeId("10:00", cinema1.getCinema());
        ShowtimeId showtimeid2 = new ShowtimeId("12:00", cinema2.getCinema());
        ShowtimeId showtimeid3 = new ShowtimeId("14:00", cinema2.getCinema());
        Showtime showtime1 = new Showtime(showtimeid1, movie1.getMname());
        Showtime showtime2 = new Showtime(showtimeid2, movie2.getMname());
        Showtime showtime3 = new Showtime(showtimeid3, movie3.getMname());

        //add Movielist
        List<Movie> listmovieincinema1 = new ArrayList<Movie>();
        listmovieincinema1.add(movie1);
        listmovieincinema1.add(movie2);
        listmovieincinema1.add(movie3);

        List<Movie> listmovieincinema2 = new ArrayList<Movie>();
        listmovieincinema2.add(movie3);
        listmovieincinema2.add(movie4);

        cinema1.addMovieList(listmovieincinema1);
        cinema2.addMovieList(listmovieincinema2);

        //add showtimelist
        List<Showtime> listshowtimeinmovie1 = new ArrayList<Showtime>();
        listshowtimeinmovie1.add(showtime1);
        List<Showtime> listshowtimeinmovie2 = new ArrayList<Showtime>();
        List<Showtime> listshowtimeinmovie3 = new ArrayList<Showtime>();
        List<Showtime> listshowtimeinmovie4 = new ArrayList<Showtime>();
        listshowtimeinmovie4.add(showtime2);
        listshowtimeinmovie4.add(showtime3);
        
        movie1.addShowtimeList(listshowtimeinmovie1);
        movie2.addShowtimeList(listshowtimeinmovie2);
        movie3.addShowtimeList(listshowtimeinmovie3);
        movie4.addShowtimeList(listshowtimeinmovie4);
        
        //Check movielist in Cinema1 
        int i = 0;
        for (Movie movie : listmovieincinema1) {
            assertEquals(movie, cinema1.getMovieList().get(i));
            i++;
        }
        //Check movielist in Cinema2
        i = 0;
        for (Movie movie : listmovieincinema2) {
            assertEquals(movie, cinema2.getMovieList().get(i));
            i++;
        }
        //Check movielist in movie1
        i = 0;
        for (Showtime showtime : listshowtimeinmovie1) {
            assertEquals(showtime, movie1.getShowtimeList().get(i));
            i++;
        }
        //Check movielist in movie2
        i = 0;
        for (Showtime showtime : listshowtimeinmovie2) {
            assertEquals(showtime, movie2.getShowtimeList().get(i));
            i++;
        }
        //Check movielist in movie3
        i = 0;
        for (Showtime showtime : listshowtimeinmovie3) {
            assertEquals(showtime, movie3.getShowtimeList().get(i));
            i++;
        }
        //Check movielist in movie4
        i = 0;
        for (Showtime showtime : listshowtimeinmovie4) {
            assertEquals(showtime, movie4.getShowtimeList().get(i));
            i++;
        }

    }
}
