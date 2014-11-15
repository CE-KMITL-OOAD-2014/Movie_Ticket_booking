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
import model.dao.CodeDAO;
import model.dao.MovieDAO;
import model.dao.ReviewRatingDAO;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Art
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/adminmanage", method = RequestMethod.POST)
    public ModelAndView managePage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("adminmanage");
        return mv;
    }

    @RequestMapping(value = "/addcinema")
    public ModelAndView addCinema(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("cinemaedit");
        try {
            Integer seat = parseInt(request.getParameter("seat"));
            seat *= 10;
            Cinema cinema = new Cinema(seat);
            CinemaDAO.addCinema(cinema);
            List<Cinema> lstc = CinemaDAO.listCinema();
            mv.addObject("cinema", lstc);
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            return mv;
        }
    }

    @RequestMapping(value = "/addmovie", method = RequestMethod.POST)
    public ModelAndView addMovie(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("movieedit");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        try {
            MultipartFile multipartFile = multipartRequest.getFile("img");
            byte[] img = multipartFile.getBytes();
            Movie movie = new Movie(request.getParameter("mname"), request.getParameter("releasedate"),
                    request.getParameter("type"), Integer.parseInt(request.getParameter("duration")), request.getParameter("synopsis"), img);
            MovieDAO.addorupdateMovie(movie);
            List<Movie> lstm = MovieDAO.listMovie();

            mv.addObject("movie", lstm);
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            return mv;
        }
    }

    @RequestMapping(value = "/deletemovie", method = RequestMethod.POST)
    public ModelAndView deleteMovie(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("movieedit");
        try {
            MovieDAO.deleteMovie(request.getParameter("mname"));
            ReviewRatingDAO.deleteReviewRatingbyMovie(request.getParameter("mname"));
            Showtime showtime = ShowtimeDAO.deleteShowtimebyMovie(request.getParameter("mname"));
            SeatDAO.deleteSeatbyShowtime(showtime.getId().getTime());
            CodeDAO.deleteCodebyMovie(request.getParameter("mname"));
            
            List<Movie> lstm = MovieDAO.listMovie();

            mv.addObject("movie", lstm);
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            return mv;
        }
    }

    @RequestMapping(value = "/addshowtime")
    public ModelAndView addShowtime(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("test");
        try{
            ShowtimeId id = new ShowtimeId(request.getParameter("time"), parseInt(request.getParameter("cinema")));
            Showtime showtime = new Showtime(id, request.getParameter("mname"));
            Showtime showtimeadd = ShowtimeDAO.addorupdateShowtime(showtime);
            Cinema cinema = CinemaDAO.getCinemabyNum(showtimeadd.getId().getCinema());
            int seatmax = cinema.getSeatmax();
            SeatId seatid = null;
            Seat seat = null;
            char seatnum = 'A';
            String seatname;
            Integer n = 1;
            Integer nn = 0;
            for (int i = 1; i <= seatmax; i++) {
                if (i % 10 == 0) {
                    nn = 1;
                    n = 0;
                    seatname = seatnum + nn.toString() + n.toString();
                    seatid = new SeatId(showtimeadd.getId().getTime(), cinema.getCinema(), seatname);
                    seat = new Seat(seatid, 1, true);
                    SeatDAO.addorupdateSeat(seat);
                    n++;
                    seatnum = (char) (seatnum + 1);
                } else {
                    nn = 0;
                    seatname = seatnum + nn.toString() + n.toString();
                    seatid = new SeatId(showtimeadd.getId().getTime(), cinema.getCinema(), seatname);
                    seat = new Seat(seatid, 1, true);
                    SeatDAO.addorupdateSeat(seat);
                    n++;
                }
            }
            List<Showtime> lsts = ShowtimeDAO.listShowtime();
            mv.addObject("showtime", lsts);
            return mv;
        } catch (Exception e) {
           e.printStackTrace();
            return mv;
        }
    }
}
