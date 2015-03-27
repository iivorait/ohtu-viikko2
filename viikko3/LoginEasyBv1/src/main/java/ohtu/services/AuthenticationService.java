package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ohtu.data_access.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private UserDao userDao;

    @Autowired
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

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password

        //käyttäjätunnuksen on oltava merkeistä a-z koostuva vähintään 3 merkin pituinen merkkijono
        if(!username.matches("[a-z]*") || username.length() < 3) {
            return true;
        }
        
        //salasanan on oltava pituudeltaan vähintään 8 merkkiä ja sen tulee sisältää vähintään yksi numero ...
        if(password.length() < 8 || !password.matches(".*\\d.*")) {
            return true;
        }
        
        
        //... tai erikoismerkki
        Pattern regex = Pattern.compile("[!$&+,:;=?@#|]");
        Matcher matcher = regex.matcher(password);
        if (!matcher.find()){
            return true;
        }
        
        return false;
    }
}
