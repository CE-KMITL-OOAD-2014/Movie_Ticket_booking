/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import service.UsersService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.MovieDAO;
import model.dao.ReviewRatingDAO;
import model.dao.UsersDAO;
import model.pojo.Movie;
import model.pojo.ReviewRating;
import model.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author TRathC
 */
@Controller
public class UsersContoller {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView Register(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv;
        try {
            List<Users> lst = UsersDAO.listUser();
            for (Users u : lst) {
                if (u.getUsername().equals((request.getParameter("username")))) {
                    mv = new ModelAndView("fail");
                    return mv;
                }
            }
            Users user = new Users(request.getParameter("username"), request.getParameter("password"),
                    request.getParameter("email"), request.getParameter("phonenumber"),
                    false);
            String password = UsersService.generatePasswordHash(request.getParameter("username"),request.getParameter("password"));
            user.setPassword(password);
            Users useradd = UsersDAO.addorupdateUser(user);
            mv = new ModelAndView("register");
            mv.addObject("user", useradd);
            return mv;
        } catch (Exception ex) {
            Logger.getLogger(UsersContoller.class.getName()).log(Level.SEVERE, "add user failed!", ex);
            mv = new ModelAndView("fail");
            mv.addObject("msg", "register fail!");
        }
        return mv;
    }
    
    @RequestMapping(value = "/reviewrating", method = RequestMethod.POST)
    public ModelAndView ReviewRating(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("moviedetail");
        try {
            ReviewRating review = new ReviewRating(request.getParameter("mname"),request.getParameter("username"), parseInt(request.getParameter("rating")), request.getParameter("review"));
            ReviewRatingDAO.saveorupdateReviewRating(review);
            Movie movie = MovieDAO.getMoviebyName(request.getParameter("mname"));
            List<ReviewRating> lstr = ReviewRatingDAO.listReviewRatingbyMovie(movie.getMname());
            mv.addObject("review", lstr);
            mv.addObject("movie", movie);
        } catch (Exception ex) {
            Logger.getLogger(UsersContoller.class.getName()).log(Level.SEVERE, "add user failed!", ex);
            mv = new ModelAndView("fail");
            mv.addObject("msg","fail!");
        }
        return mv;
    }
    
    @RequestMapping(value="/hello")
    public ModelAndView testPage(HttpServletRequest request,
            HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView("success");
         List<String> lst = new ArrayList<String>();
        mv.addObject("seat",request.getParameterValues("seat"));
        return mv;
    }
    
    @RequestMapping(value="/booking")
    public ModelAndView bookingPage(HttpServletRequest request,
            HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView("booking");
        return mv;
    }
    
    @RequestMapping(value="/selectseat")
    public ModelAndView selectSeatPage(HttpServletRequest request,
            HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView("selectseat");
        mv.addObject("seatnum",request.getParameter("seatnum"));
        return mv;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateUser(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("myaccount");
        Users user = UsersDAO.getUserbyName(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPhonenumber(request.getParameter("phonenumber"));
        UsersDAO.addorupdateUser(user);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(value = "/myaccount", method = RequestMethod.POST)
    public ModelAndView UserInformationpage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("myaccount");
        Users user = UsersDAO.getUserbyName(request.getParameter("username"));
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public ModelAndView changepasswordUser(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("myaccount");
        Users usercheck = UsersDAO.getUserbyName(request.getParameter("username"));
        String password = UsersService.generatePasswordHash(request.getParameter("username"), request.getParameter("oldpassword"));
        if (password.equals(usercheck.getPassword())) {
            password = UsersService.generatePasswordHash(request.getParameter("username"), request.getParameter("newpassword"));
            usercheck.setPassword(password);
            UsersDAO.addorupdateUser(usercheck);
        }
        mv.addObject("user", usercheck);
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        Users usercheck = UsersDAO.getUserbyName(request.getParameter("username"));
        String password = UsersService.generatePasswordHash(request.getParameter("username"), request.getParameter("password"));
        if (password.equals(usercheck.getPassword())) {
            String session = UsersService.generateSession(request.getParameter("username"));
            usercheck.setSession(session);
            UsersDAO.addorupdateUser(usercheck);

            mv.addObject("user", usercheck);
            mv.setViewName("index");
        }
        return mv;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Users usercheck = UsersDAO.getUserbyName(request.getParameter("username"));
        usercheck.setSession(null);
        UsersDAO.addorupdateUser(usercheck);
    }
}
