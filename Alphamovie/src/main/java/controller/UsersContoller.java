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
            //String hash = UsersService.hash(request.getParameter("password"));
            Users useradd = UsersService.register(user);
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");

        Users user = new Users(request.getParameter("username"), request.getParameter("password"),
                request.getParameter("email"), request.getParameter("phonenumber"), false);
        
        Users usercheck = UsersDAO.getUserbyName(user.getUsername());
        if (user.getPassword().equals(usercheck.getPassword())) {
            String hash = UsersService.hash(request.getParameter("username"));
            usercheck.setSession(hash);
            UsersDAO.addorupdateUser(usercheck);
            mv.addObject("user", usercheck);
        }
        return mv;
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logout(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        
        Users usercheck = UsersDAO.getUserbyName(request.getParameter("username"));
        usercheck.setSession(null);
        UsersDAO.addorupdateUser(usercheck);
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

}
