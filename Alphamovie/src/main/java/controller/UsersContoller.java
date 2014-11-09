/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.UsersService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.UsersDAO;
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

    @RequestMapping(value ="/myaccount", method = RequestMethod.POST) 
    public ModelAndView addUsers(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv;
        Users user = new Users(request.getParameter("username"),request.getParameter("password"),
                                    request.getParameter("email"), request.getParameter("phonenumber"), 
                                        false);
        String hash = UsersService.hash(request.getParameter("password"));
        Users usera = UsersService.register(user);
        try {
            mv = new ModelAndView("myaccount");
            mv.addObject("user", usera);
            return mv;
        } catch (Exception ex) {
            Logger.getLogger(UsersContoller.class.getName()).log(Level.SEVERE, "add user failed!", ex);
            mv = new ModelAndView("fail");
            mv.addObject("msg", "register fail!");
        }
        return mv;
    }

    @RequestMapping(value = "/updateinformation", method = RequestMethod.POST)
    public ModelAndView updateUser(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("myaccout");

        Users user = new Users(request.getParameter("username"), request.getParameter("password"),
                request.getParameter("email"), request.getParameter("phonenumber"), false);
        Users userupdate = UsersService.register(user);
        mv.addObject("user", userupdate);
        return mv;
    }
    
    @RequestMapping("/alluser")
    public ModelAndView listUser(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("userss");
        List<Users> lst = UsersDAO.listUser();
        mv.addObject("users", lst);
        return mv;
    }

    @RequestMapping("/deleteuser")
    public ModelAndView deleteUser(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("HelloWorldPage");
        Users user = new Users("username", "world", "email123", "111-111-1110", false);
        mv.addObject("users", user);
        UsersDAO.deleteUser(user);
        return mv;
    }

    @RequestMapping("/index")
    public ModelAndView indexpage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
