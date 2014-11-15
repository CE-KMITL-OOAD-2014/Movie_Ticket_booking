/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.MovieDAO;
import model.dao.ReviewRatingDAO;
import model.pojo.Movie;
import model.pojo.ReviewRating;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Art
 */
@Controller
public class Moviecontroller {

    @RequestMapping(value = "/movieedit", method = RequestMethod.POST)
    public ModelAndView editpage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("movieedit");
            List<Movie> lstm = MovieDAO.listMovie();
            mv.addObject("movie", lstm);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }

    @RequestMapping("/moviedetail")
    public ModelAndView moviedetail(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv;
        try {
            mv = new ModelAndView("moviedetail");
            Movie movie = MovieDAO.getMoviebyName(request.getParameter("mname"));
            List<ReviewRating> reviewratinglist = ReviewRatingDAO.listReviewRatingbyMovie(movie.getMname());
            mv.addObject("review", reviewratinglist);
            mv.addObject("movie", movie);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/movie");
        }
    }
}
