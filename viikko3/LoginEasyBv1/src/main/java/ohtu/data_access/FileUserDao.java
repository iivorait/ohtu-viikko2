package ohtu.data_access;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileUserDao implements UserDao {

    private List<User> users;
    private final String filename;

    public FileUserDao(String filename) {
        users = new ArrayList<User>();
        this.filename = filename;
        this.readFromFile();
    }        

    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        users.add(user);
        this.addToFile(user);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
    
    private void addToFile(User user) {
        //kirjoitetaan tunnukset muodossa username password
        FileWriter kirjoittaja;
        try {
            kirjoittaja = new FileWriter(filename, true);
            kirjoittaja.append(user.getUsername() + " " + user.getPassword() + "\n");
            kirjoittaja.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void readFromFile() {
        Scanner lukija = null;

        try {
            File tiedosto = new File(filename);
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return; // poistutaan metodista
        }

        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] tunnukset = rivi.split("\\s+");
            if(tunnukset[0] != null && tunnukset[1] != null) {
                User user = new User(tunnukset[0], tunnukset[1]);
                users.add(user);
            }
        }

        lukija.close();
    }
}
