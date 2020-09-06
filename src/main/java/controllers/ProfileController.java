package controllers;

import exceptions.NoSuchCollaboratorFoundException;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {
    private UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/profile")
    public String showProfilePage(HttpServletRequest request) throws NoSuchCollaboratorFoundException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            request.setAttribute("connected", false);
            return "error";
        } else {
            String username = session.getAttribute("username").toString();
            User user = userService.getUserByUserName(username);
            request.setAttribute("user", user);
            return "profile";
        }
    }
}
