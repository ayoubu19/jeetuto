package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import services.LoginService;
import services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping(value = "/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String authenticateUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (loginService.isUserValid(username, password)) {
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("connected",true);
            return "redirect:profile";
        } else {
            return "error";
        }
    }


}
