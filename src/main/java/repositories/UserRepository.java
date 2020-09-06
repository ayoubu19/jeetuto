package repositories;

import exceptions.NoSuchCollaboratorFoundException;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> collborators = new ArrayList<>(List.of(

            new User( "elbouzaidi", "mohammed", "mohammed", "1234567"
                    , "pilote", 27, -26),

            new User("elbouzaidi", "amine", "amine", "1234567",
                    "ied", 27, 12),

            new User("elbouzaidi", "imad", "imad", "1234567",
                    "ied", 27, 3),

            new User("elbouzaidi", "ayoub", "ayoub", "1234567",
                    "ied", 27, 13)

    ));

    public UserRepository() {
    }

    public List<User> getCollaborators() {
        return collborators;
    }


    public User findUserByUserName(String username) throws NoSuchCollaboratorFoundException {
        return this.collborators
                .stream()
                .filter(user -> username.equals(user.getUserName()))
                .findFirst()
                .orElseThrow(NoSuchCollaboratorFoundException::new);
    }


    public void removeCollaborator(String username) throws NoSuchCollaboratorFoundException {
        User userToDelete = findUserByUserName(username);
        this.collborators.remove(userToDelete);
    }

    public void addCollaborator(User collaborator) {
        this.collborators.add(collaborator);
    }
}
