/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author B_MW (Wai & May)
 */
@Controller
@RequestMapping("/welcome")
public class NewSimpleFormController1
{
    public ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        ModelAndView model = new ModelAndView("HelloWorldPage");
        model.addObject("msg", "hello world1");

        return model;
    }
    
    @RequestMapping(value = "/blah")
    public ModelAndView me(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        ModelAndView model = new ModelAndView("HelloWorldPage");
        model.addObject("msg", "hello world1 Blah Blah");

        return model;
    }
}
