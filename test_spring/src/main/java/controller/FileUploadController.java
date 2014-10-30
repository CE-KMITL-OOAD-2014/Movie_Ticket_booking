package controller;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.MovieDAO;
import model.pojo.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FileUploadController {
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
        byte[] img = multipartFile.getBytes();
        Movie movie = new Movie();
        movie.setMname("ssfasfsa");
        movie.setType("jdbc");
        movie.setSynopsis("funn");
        movie.setDuration(new Date(02));
        movie.setReleasedate(new Date(02));
        movie.setMimg(img);
        MovieDAO.addMovie(movie);
        
        return new ModelAndView("redirect");
    }
}