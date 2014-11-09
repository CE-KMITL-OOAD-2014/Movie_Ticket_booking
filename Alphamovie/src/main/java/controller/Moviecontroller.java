/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.MovieDAO;
import model.pojo.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author TRathC
 */
@Controller
public class Moviecontroller {
    
    @RequestMapping(value = "/addmovie", method = RequestMethod.POST)
    public ModelAndView addMovie(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("moviedetail");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("img");
        byte[] img = multipartFile.getBytes();
        try {

            Movie movie = new Movie(request.getParameter("mname"), request.getParameter("releasedate"),
                    request.getParameter("type"), Integer.parseInt(request.getParameter("duration")), request.getParameter("synopsis"), img);
            Movie movieadd = MovieDAO.addMovie(movie);

            mv = new ModelAndView("moviedetail");
            OutputStream os = new ByteArrayOutputStream();
            // wp.getData() = byte[]
            os.write(movieadd.getMimg());
            mv.addObject("data", os);
            mv.addObject("movie", movieadd);
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("username", e);
            return mv;
        }
    }
    
    @RequestMapping("/movieedit")
    public ModelAndView editpage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("movieedit");
        return mv;
    }

    @RequestMapping("/moviedetail")
    public ModelAndView moviedetailpage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        try {
            mv = new ModelAndView("moviedetail");
            Movie movie = MovieDAO.getMoviebyName("Hungergame");
            mv.addObject("movie", movie);
            return mv;
        } catch (NumberFormatException ex) {
            mv = new ModelAndView("success");
            return mv;
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
