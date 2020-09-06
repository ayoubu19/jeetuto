package services;

import exceptions.NoSuchCollaboratorFoundException;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService() {

    }

    public List<User> getCollborattors() {
        return userRepository.getCollaborators();
    }

    public User getUserByUserName(String username) throws NoSuchCollaboratorFoundException {
        return this.userRepository.findUserByUserName(username);
    }
    public void updateUserholidays(String username,Integer holidays) throws NoSuchCollaboratorFoundException {
        User user =this.userRepository.findUserByUserName(username);
        user.setHolidayCounter(user.getHolidayCounter()-holidays);
    }

    public void deleteCollaborator(String collaboratorUserName) throws NoSuchCollaboratorFoundException {
        this.userRepository.removeCollaborator(collaboratorUserName);
    }

    public void addCollaborator(User collaborator) {
        this.userRepository.addCollaborator(collaborator);
    }


}
