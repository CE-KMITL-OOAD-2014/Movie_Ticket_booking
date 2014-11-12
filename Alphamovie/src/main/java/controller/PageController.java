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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Art
 */
@Controller
public class PageController {

    @RequestMapping("/index")
    public ModelAndView indexpage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping("/showtime")
    public ModelAndView movieshowtimepage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("showtime");

            List<Movie> lstm = new ArrayList<Movie>();
            List<Cinema> lstc = CinemaDAO.listCinema();
            for (Cinema c : lstc) {
                c.addMovieList(CinemaDAO.listMovieinCinema(c.getCinema()));
                lstm.addAll(c.getMovieList());
            }
            for (Movie m : lstm) {
                m.addShowtimeList(MovieDAO.listShowtimeinMovie(m.getMname()));
            }
            mv.addObject("cinema", lstc);
            return mv;
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    @RequestMapping("/movie")
    public ModelAndView moviepage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("movie");
            List<Movie> lst = MovieDAO.listMovie();
            mv.addObject("movie", lst);
            return mv;
        } catch (NumberFormatException ex) {
            return null;
        }
    }
    
    @RequestMapping("/signin")
    public ModelAndView signinpage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("signin");
            return mv;
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
