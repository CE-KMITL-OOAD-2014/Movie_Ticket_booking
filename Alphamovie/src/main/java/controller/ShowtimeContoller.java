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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Art
 */
@Controller
public class ShowtimeContoller {

    @RequestMapping(value = "/addshowtime")
    public ModelAndView addShowtime(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("test");
        try {
            ShowtimeId id = new ShowtimeId(request.getParameter("time"), parseInt(request.getParameter("cinema")));
            Showtime showtime = new Showtime(id, request.getParameter("mname"));
            Showtime showtimeadd = ShowtimeDAO.addorUpdateShowtime(showtime);
            Cinema cinema = CinemaDAO.getCinemabyNum(showtimeadd.getId().getCinema());
            int seatmax = cinema.getSeatmax();
            SeatId seatid = null;
            Seat seat = null;
            char seatnum = 'A';
            String seatname;
            Integer n = 1;
            Integer nn =0;
            for (int i = 1; i <= seatmax; i++) {
                if (i % 10 == 0) {
                    nn=1;
                    n=0;
                    seatname = seatnum + nn.toString()+ n.toString();
                    seatid = new SeatId(showtimeadd.getId().getTime(), cinema.getCinema(), seatname);
                    seat = new Seat(seatid, 1, true);
                    SeatDAO.addSeat(seat);
                    n++;
                    seatnum = (char) (seatnum + 1);
                } else {
                    nn=0;
                    seatname = seatnum +nn.toString()+ n.toString();
                    seatid = new SeatId(showtimeadd.getId().getTime(), cinema.getCinema(), seatname);
                    seat = new Seat(seatid, 1, true);
                    SeatDAO.addSeat(seat);
                    n++;
                }
            }
            List <Seat> lstseat = SeatDAO.listSeat();
            mv.addObject("seat", lstseat);
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            return mv;
        }
    }

    @RequestMapping("/showtimeedit")
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
