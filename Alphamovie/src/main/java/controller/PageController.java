/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CinemaDAO;
import model.dao.MovieDAO;
import model.pojo.Cinema;
import model.pojo.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Art
 */
@Controller
public class PageController {

    @RequestMapping(value = "/index")
    public ModelAndView indexpage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping("/showtime")
    public ModelAndView showtimepage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("showtime");

            List<Movie> lstmovie = new ArrayList<Movie>();
            List<Cinema> lstcinema = CinemaDAO.listCinema();
            for (Cinema cinema : lstcinema) {
                cinema.addMovieList(CinemaDAO.listMovieinCinema(cinema.getCinema()));
                lstmovie = cinema.getMovieList();
                for (Movie movie : lstmovie) {
                    movie.addShowtimeList(MovieDAO.listShowtimeinMovie(movie.getMname(), cinema.getCinema()));
                }
            }
            mv.addObject("cinema", lstcinema);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }

    @RequestMapping("/movie")
    public ModelAndView moviepage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("movie");
            List<Movie> lstmovie = MovieDAO.listMovie();
            mv.addObject("movie", lstmovie);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }
}
