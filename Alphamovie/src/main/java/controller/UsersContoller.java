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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CinemaDAO;
import model.dao.CodeDAO;
import model.dao.MovieDAO;
import model.dao.ReviewRatingDAO;
import model.dao.SeatDAO;
import model.dao.UsersDAO;
import model.pojo.Cinema;
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
 * @author Art
 */
@Controller
public class UsersContoller {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView Register(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv;
        try {
            String password = UsersService.generatePasswordHash(request.getParameter("username"), request.getParameter("password"));
            Users user = new Users(request.getParameter("username"), password,
                    request.getParameter("email"), request.getParameter("phonenumber"),
                    false);
            Users useradd = UsersDAO.addorupdateUser(user);
            mv = new ModelAndView("register");
            mv.addObject("user", useradd);
        } catch (Exception e) {
            mv = new ModelAndView("redirect:/index");
        }
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        try {
            Users usercheck = UsersDAO.getUserbyName(request.getParameter("username"));
            String password = UsersService.generatePasswordHash(request.getParameter("username"), request.getParameter("password"));
            if (password.equals(usercheck.getPassword())) {
                String session = UsersService.generateSession(request.getParameter("username"));
                usercheck.setSession(session);
                UsersDAO.addorupdateUser(usercheck);
                mv.addObject("user", usercheck);
                return mv;
            }
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
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

    @RequestMapping(value = "/reviewrating", method = RequestMethod.POST)
    public ModelAndView ReviewRating(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("moviedetail");
        try {
            ReviewRating review = new ReviewRating(request.getParameter("mname"), request.getParameter("username"), parseInt(request.getParameter("rating")), request.getParameter("review"));
            ReviewRatingDAO.addReviewRating(review);
            Movie movie = MovieDAO.getMoviebyName(request.getParameter("mname"));
            List<ReviewRating> lstreviewrating = ReviewRatingDAO.listReviewRatingbyMovie(movie.getMname());
            mv.addObject("review", lstreviewrating);
            mv.addObject("movie", movie);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }

    @RequestMapping("/selectshowtime")
    public ModelAndView selectshowtimePage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("selectshowtime");

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
        } catch (NumberFormatException ex) {
            return new ModelAndView("redirect:/index");
        }
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ModelAndView bookingPage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("booking");
        try {
            ShowtimeId id = new ShowtimeId(request.getParameter("time"), parseInt(request.getParameter("cinema")));
            Showtime showtime = new Showtime(id, request.getParameter("mname"));
            Movie movie = MovieDAO.getMoviebyName(request.getParameter("mname"));
            mv.addObject("movie", movie);
            mv.addObject("showtime", showtime);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }

    @RequestMapping(value = "/selectseat", method = RequestMethod.POST)
    public ModelAndView selectSeatPage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("selectseat");
            List<Seat> lstseat = SeatDAO.listSeatbyShowtime(request.getParameter("time"), parseInt(request.getParameter("cinema")));
            ShowtimeId id = new ShowtimeId(request.getParameter("time"), parseInt(request.getParameter("cinema")));
            Showtime showtime = new Showtime(id, request.getParameter("mname"));
            Movie movie = MovieDAO.getMoviebyName(request.getParameter("mname"));
            mv.addObject("seatnum", request.getParameter("seatnum"));
            mv.addObject("movie", movie);
            mv.addObject("seat", lstseat);
            mv.addObject("showtime", showtime);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }

    @RequestMapping(value = "/code", method = RequestMethod.POST)
    public ModelAndView Codegenerate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("myaccount");
        try {
            String[] strarr = request.getParameterValues("seat");
            String seatname = "";
            for (String s : strarr) {
                Seat seat = SeatDAO.getSeatbyId(request.getParameter("time"), parseInt(request.getParameter("cinema")), s);
                seat.setAvalible(false);
                SeatDAO.addorupdateSeat(seat);
                seatname += s;
            }
            ShowtimeId id = new ShowtimeId(request.getParameter("time"), parseInt(request.getParameter("cinema")));
            Showtime showtime = new Showtime(id, request.getParameter("mname"));
            Code code = UsersService.generateCode(showtime, seatname);
            Users user = UsersDAO.getUserbyName(request.getParameter("username"));
            user.setCode(code.getCode());
            Users useradd = UsersDAO.addorupdateUser(user);
            CodeDAO.addorupdateCode(code);
            mv.addObject("user", useradd);
            mv.addObject("code", code);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }

    @RequestMapping(value = "/canclebooking", method = RequestMethod.POST)
    public ModelAndView Canclebooking(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("myaccount");
        try {
            Users user = UsersDAO.getUserbyName(request.getParameter("username"));
            Code code = CodeDAO.getCodebyName(request.getParameter("code"));
            int cinema = code.getCinema();
            String time = code.getTime();
            String seatname = code.getSeatname();
            String[] seatarray = UsersService.getseatArray(seatname);
            for (String seat : seatarray) {
                Seat setseat = SeatDAO.getSeatbyId(time, cinema, seat);
                setseat.setAvalible(true);
                SeatDAO.addorupdateSeat(setseat);
            }
            CodeDAO.deleteCode(code);
            user.setCode(null);
            Users usercancle = UsersDAO.addorupdateUser(user);
            mv.addObject("user", usercancle);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }

    @RequestMapping(value = "/myaccount", method = RequestMethod.POST)
    public ModelAndView UserInformationPage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("myaccount");
            Users user = UsersDAO.getUserbyName(request.getParameter("username"));
            Code code = CodeDAO.getCodebyName(user.getCode());
            mv.addObject("code", code);
            mv.addObject("user", user);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateUser(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("myaccount");
            Users user = UsersDAO.getUserbyName(request.getParameter("username"));
            user.setEmail(request.getParameter("email"));
            user.setPhonenumber(request.getParameter("phonenumber"));
            UsersDAO.addorupdateUser(user);
            mv.addObject("user", user);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirec:/index");
        }
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public ModelAndView changePasswordUser(HttpServletRequest request,
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
            mv.addObject("user", usercheck);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }
}
