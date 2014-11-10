package controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CinemaDAO;
import model.dao.MovieDAO;
import model.dao.ShowtimeDAO;
import model.pojo.Cinema;
import model.pojo.Movie;
import model.pojo.Showtime;
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
    
    @RequestMapping("/showtime")
    public ModelAndView movieshowtimepage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("showtime");
        
            List<Showtime> lsts = null;
            List<Showtime> lstshow = new ArrayList<Showtime>();
            List<Cinema> lstc = CinemaDAO.listCinema();
            for(Cinema c:lstc){
                lsts = ShowtimeDAO.listMovieinCinema(c.getCinema());
                for(Showtime s: lsts){
                    lstshow.add(s);
                }
            }
            mv.addObject("showtime", lstshow);
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
}