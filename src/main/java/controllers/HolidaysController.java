package controllers;

import exceptions.NoSuchCollaboratorFoundException;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HolidaysController {
    private UserService userService;

    @Autowired
    public HolidaysController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/holidays")
    public String showHolidaysPage(HttpServletRequest request) throws NoSuchCollaboratorFoundException {
        HttpSession session = request.getSession();

        if (session.getAttribute("username") == null) {
            request.setAttribute("connected", false);
            return "error";
        } else {
            String username = session.getAttribute("username").toString();
            User user = userService.getUserByUserName(username);
            request.setAttribute("user", user);
            return "holidays";
        }
    }

    @PostMapping(value = "/askForHoliday")
    public String updateHolidaysCounter(@RequestParam(name = "holidays") Integer restDays,HttpServletRequest request) throws NoSuchCollaboratorFoundException {
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        userService.updateUserholidays(username,restDays);
        return "redirect:holidays";
    }
}