/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CinemaDAO;
import model.dao.MovieDAO;
import model.dao.SeatDAO;
import model.dao.ShowtimeDAO;
import model.pojo.Cinema;
import model.pojo.Movie;
import model.pojo.Seat;
import model.pojo.SeatId;
import model.pojo.Showtime;
import model.pojo.ShowtimeId;
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

    @RequestMapping(value= "/showtimeedit", method = RequestMethod.POST)
    public ModelAndView editpage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("showtimeedit");
        List<Movie> lstm = MovieDAO.listMovie();
        List<Cinema> lstc = CinemaDAO.listCinema();
        mv.addObject("cinema",lstc);
        mv.addObject("movie",lstm);
        return mv;
    }
}
