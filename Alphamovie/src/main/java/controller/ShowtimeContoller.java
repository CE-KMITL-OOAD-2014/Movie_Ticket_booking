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
import model.pojo.Cinema;
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

    @RequestMapping("/showtimeedit")
    public ModelAndView editpage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("showtimeedit");
        return mv;
    }
}
