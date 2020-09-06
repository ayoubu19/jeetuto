package controllers;


import exceptions.NoSuchCollaboratorFoundException;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CollaboratorsController {
    private UserService userService;


    @Autowired
    public CollaboratorsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/collaborators")
    public String showCollaborators(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("username") == null) {
            request.setAttribute("connected", false);
            return "error";
        } else {
            List<User> collaborators = userService.getCollborattors();
            session.setAttribute("collaborators", collaborators);
            return "collaborators";
        }
    }

    @PostMapping(value = "/deleteCollaborator")
    public String deleteCollaborator(@RequestParam(name = "username") String collaboratorUserName) throws NoSuchCollaboratorFoundException {
        userService.deleteCollaborator(collaboratorUserName);
        return "redirect:collaborators";
    }

    @PostMapping(value = "/addCollaborator")
    public String addCollaborator(@RequestParam(name = "username") String collaboratorUserName,
                                  @RequestParam(name = "nom") String collaboratorNom,
                                  @RequestParam(name = "prenom") String collaboratorPrenom,
                                  @RequestParam(name = "post") String collaboratorPost,
                                  @RequestParam(name = "age") Integer collaboratorAge) {

        User collaboratorToAdd = new User(collaboratorUserName,collaboratorNom, collaboratorPrenom, collaboratorPost,collaboratorAge);
        userService.addCollaborator(collaboratorToAdd);

        return "collaborators";
    }
}

