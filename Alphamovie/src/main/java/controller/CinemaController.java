/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CinemaDAO;
import model.pojo.Cinema;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Art
 */
@Controller
public class CinemaController {

    @RequestMapping(value = "/cinemaedit", method = RequestMethod.POST)
    public ModelAndView editpage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ModelAndView mv = new ModelAndView("cinemaedit");
            List<Cinema> lstcinema = CinemaDAO.listCinema();
            mv.addObject("cinema", lstcinema);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }
    }

}
