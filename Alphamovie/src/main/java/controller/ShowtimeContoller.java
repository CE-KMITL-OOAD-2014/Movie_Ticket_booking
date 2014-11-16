/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Art
 */
@Controller
public class ShowtimeContoller {

    @RequestMapping(value = "/showtimeedit", method = RequestMethod.POST)
    public ModelAndView editpage(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            ModelAndView mv = new ModelAndView("showtimeedit");
            List<Movie> lstmovie = MovieDAO.listMovie();
            List<Cinema> lstcinema = CinemaDAO.listCinema();
            List<Showtime> lstshowtime = ShowtimeDAO.listShowtime();
            mv.addObject("cinema", lstcinema);
            mv.addObject("movie", lstmovie);
            mv.addObject("showtime", lstshowtime);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }
}
