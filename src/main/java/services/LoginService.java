package services;

import org.springframework.beans.factory.annotation.Autowired;
import repositories.UserRepository;

public class LoginService {
    private UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginService() {
    }

    public Boolean isUserValid(String username, String password) {
        return this.userRepository
                .getCollaborators()
                .stream()
                .anyMatch(user -> username.equals(user.getUserName()) && password.equals(user.getPassword()));
    }

}
