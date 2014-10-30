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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author TRathC
 */
@Controller
public class UsersContoller {

    @RequestMapping("/adduser")
    public ModelAndView addUsers(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv;
        Users user = new Users();
        String hash = UsersService.hash(request.getParameter("password"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(hash);
        user.setEmail(request.getParameter("email"));
        user.setPhonenumber(request.getParameter("phonenumber"));
        user.setIsadmin(false);
        try {
            
            String username = UsersDAO.addUser(user);
            mv = new ModelAndView("success");
            mv.addObject("username", username);
            return mv;
        } catch (Exception ex) {
            Logger.getLogger(UsersContoller.class.getName()).log(Level.SEVERE, "add user failed!", ex);
            mv = new ModelAndView("fail");
            mv.addObject("msg", "dsadasdsaddsad");
        }
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

    @RequestMapping("/updateuser")
    public ModelAndView updateUser(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("userss");

        Users user = new Users("username", "world", "email123", "111-111-1110", false);
        mv.addObject("users", user);
        UsersDAO.updateUser(user);
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

    @RequestMapping("/home")
    public ModelAndView homepage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }
    
}
