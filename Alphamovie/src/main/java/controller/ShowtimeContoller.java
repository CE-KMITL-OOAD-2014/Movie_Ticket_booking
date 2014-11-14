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
import model.dao.ShowtimeDAO;
import model.pojo.Cinema;
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
        ModelAndView mv = new ModelAndView("showtimeedit");
        try {
            ShowtimeId id = new ShowtimeId(request.getParameter("time"),parseInt(request.getParameter("cinema")));
            Showtime showtime = new Showtime(id,request.getParameter("mname"));
            Showtime showtimeadd = ShowtimeDAO.addShowtime(showtime);
            Cinema cinema = CinemaDAO.getCinemabyNum(showtimeadd.getId().getCinema());
            int seatmax = cinema.getSeatmax();
            SeatId seatid = new SeatId();
            Seat seat = new Seat();
            String seatname = "A1";
            for(int i=1;i<=seatmax;i++){
                if(i%10==0){
                    
                }
                else {
                }
                
            }
            
            mv.addObject("cinema", showtimeadd);
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
        return mv;
    }
}
