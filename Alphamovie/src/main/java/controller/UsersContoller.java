/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.lang.Integer.parseInt;
import service.UsersService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CodeDAO;
import model.dao.MovieDAO;
import model.dao.ReviewRatingDAO;
import model.dao.SeatDAO;
import model.dao.UsersDAO;
import model.pojo.Code;
import model.pojo.Movie;
import model.pojo.ReviewRating;
import model.pojo.Seat;
import model.pojo.Showtime;
import model.pojo.ShowtimeId;
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
            String password = UsersService.generatePasswordHash(request.getParameter("username"), request.getParameter("password"));
            user.setPassword(password);
            Users useradd = UsersDAO.addorupdateUser(user);
            mv = new ModelAndView("register");
            mv.addObject("user", useradd);
        } catch (Exception ex) {
            mv = new ModelAndView("redirect:/index");
        }
        return mv;
    }

    @RequestMapping(value = "/reviewrating", method = RequestMethod.POST)
    public ModelAndView ReviewRating(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("moviedetail");
        try {
            ReviewRating review = new ReviewRating(request.getParameter("mname"), request.getParameter("username"), parseInt(request.getParameter("rating")), request.getParameter("review"));
            ReviewRatingDAO.addReviewRating(review);
            Movie movie = MovieDAO.getMoviebyName(request.getParameter("mname"));
            List<ReviewRating> lstr = ReviewRatingDAO.listReviewRatingbyMovie(movie.getMname());
            mv.addObject("review", lstr);
            mv.addObject("movie", movie);
        } catch (Exception ex) {
            Logger.getLogger(UsersContoller.class.getName()).log(Level.SEVERE, "add user failed!", ex);
            mv = new ModelAndView("fail");
            mv.addObject("msg", "fail!");
        }
        return mv;
    }

    @RequestMapping(value = "/code")
    public ModelAndView Code(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("success");
        String[] strarr = request.getParameterValues("seat");
        String seatname = "";
        for (String s : strarr) {
            Seat seat = SeatDAO.getSeatbyId(request.getParameter("time"), parseInt(request.getParameter("cinema")), s);
            seat.setAvalible(false);
            SeatDAO.addorupdateSeat(seat);
            seatname += s;
        }
        String usercode = 'c' + request.getParameter("cinema") + 'm' + request.getParameter("movie") + "time" + request.getParameter("time") + '@' + seatname;
        Integer hashcode = usercode.hashCode();
        Code code = new Code(hashcode.toString(), request.getParameter("time"), parseInt(request.getParameter("cinema")), request.getParameter("mname"), seatname);
        Users user = UsersDAO.getUserbyName(request.getParameter("username"));
        user.setCode(hashcode.toString());
        Users useradd = UsersDAO.addorupdateUser(user);
        CodeDAO.addorupdateCode(code);
        mv.addObject("user", useradd);
        mv.addObject("code", code);
        return mv;
    }
    
    @RequestMapping(value = "/canclebooking", method = RequestMethod.POST)
    public ModelAndView Canclebooking(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("myaccount");
        Users user = UsersDAO.getUserbyName(request.getParameter("username"));
        Code code = CodeDAO.getCodebyName(request.getParameter("code"));
        int cinema = code.getCinema();
        String time = code.getTime();
        String seatname = code.getSeatname();
        int n = seatname.length()/3;
        String[] seatarr=new String[n];
        int substr=0;
        for(int i=0;i<n;i++){
            seatarr[i] = seatname.substring(substr,substr+3);
            substr+=3;
        }
        for(String seat:seatarr){
            Seat setseat = SeatDAO.getSeatbyId(time, cinema, seat);
            setseat.setAvalible(true);
            SeatDAO.addorupdateSeat(setseat);
        }
        CodeDAO.deleteCode(code);
        user.setCode(null);
        Users usercancle = UsersDAO.addorupdateUser(user);
        mv.addObject("user",usercancle);
        return mv;
    }

    @RequestMapping(value = "/booking")
    public ModelAndView bookingPage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("booking");
        ShowtimeId id = new ShowtimeId(request.getParameter("time"), parseInt(request.getParameter("cinema")));
        Showtime showtime = new Showtime(id, request.getParameter("mname"));
        Movie movie = MovieDAO.getMoviebyName(request.getParameter("mname"));
        mv.addObject("movie", movie);
        mv.addObject("showtime", showtime);
        return mv;
    }

    @RequestMapping(value = "/selectseat")
    public ModelAndView selectSeatPage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("selectseat");
        List<Seat> lsts = SeatDAO.listSeatbyShowtime(request.getParameter("time"), parseInt(request.getParameter("cinema")));
        ShowtimeId id = new ShowtimeId(request.getParameter("time"), parseInt(request.getParameter("cinema")));
        Showtime showtime = new Showtime(id, request.getParameter("mname"));
        Movie movie = MovieDAO.getMoviebyName(request.getParameter("mname"));
        mv.addObject("movie", movie);
        mv.addObject("seat", lsts);
        mv.addObject("showtime", showtime);
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
        Code code = CodeDAO.getCodebyName(user.getCode());
        mv.addObject("code", code);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public ModelAndView changepasswordUser(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("myaccount");
        Users usercheck = UsersDAO.getUserbyName(request.getParameter("username"));
        try {
            String password = UsersService.generatePasswordHash(request.getParameter("username"), request.getParameter("oldpassword"));
            if (password.equals(usercheck.getPassword())) {
                password = UsersService.generatePasswordHash(request.getParameter("username"), request.getParameter("newpassword"));
                usercheck.setPassword(password);
                UsersDAO.addorupdateUser(usercheck);
            }
            
        } catch (Exception e) {

        }
        mv.addObject("user", usercheck);
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        try {
            Users usercheck = UsersDAO.getUserbyName(request.getParameter("username"));
            String password = UsersService.generatePasswordHash(request.getParameter("username"), request.getParameter("password"));
            if (password.equals(usercheck.getPassword())) {
                String session = UsersService.generateSession(request.getParameter("username"));
                usercheck.setSession(session);
                UsersDAO.addorupdateUser(usercheck);
                mv.addObject("user", usercheck);
                mv.setViewName("index");
            }
        } catch (Exception e) {
            mv = new ModelAndView("redirect:/index");
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
