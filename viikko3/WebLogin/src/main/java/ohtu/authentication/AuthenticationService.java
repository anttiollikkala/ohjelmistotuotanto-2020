package ohtu.authentication;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();

        if (password.length() < 8) {
            status.addError("password should have at least 8 characters");
        }

        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length() < 3) {
            status.addError("username should have at least 3 characters");
        }

        if (!password.equals(passwordConfirmation)) {
            status.addError("password and password confirmation do not match");
        }

        boolean fail = true;
        for (char ch : password.toCharArray()) {
            if (ch < 'A' | (ch > 'Z' && ch < 'a') | ch > 'z') {
                fail = false;
                break;
            }
        }
        
        if (fail) status.addError("password should also contain non alphabetical characters");

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }

        return status;
    }

}
