package controllers;

import models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogOutController {
    @GetMapping(value = "/logout")
    public String showLogOutPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            request.setAttribute("connected", false);
            return "error";
        } else {
            session.invalidate();
            return "logout";
        }

    }
}