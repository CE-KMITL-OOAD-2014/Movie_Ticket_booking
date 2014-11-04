/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
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
import service.MovieService;

/**
 *
 * @author TRathC
 */
@Controller
public class Moviecontroller {

    @RequestMapping(value = "/addmovie", method = RequestMethod.POST)
    public ModelAndView addMovie(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("success");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("img");
        byte[] img = multipartFile.getBytes();
        try {
            Movie movie = new Movie(request.getParameter("mname"), new Date(20120811) , 
                    request.getParameter("type"), new Date(20120811),request.getParameter("synopsis"), img);
            MovieDAO.addMovie(movie);
            String mname = MovieService.addMovie(movie);
            mv.addObject("username", mname);
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("username", e);
            return mv;
        }
    }

}
