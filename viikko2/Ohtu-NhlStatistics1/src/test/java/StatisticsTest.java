/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iivo
 */
public class StatisticsTest {
    
    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void pelaajanHaku() {
         stats = new Statistics(readerStub);
         Player kurri = stats.search("Kurri");
         assertNotNull(kurri);
     }
     
     @Test
     public void pelaajanHakuKunEiLoydy() {
         stats = new Statistics(readerStub);
         Player bond = stats.search("Bond");
         assertNull(bond);
     }
     
     @Test
     public void joukkueenHaku() {
         stats = new Statistics(readerStub);
         List team = stats.team("EDM");
         assertEquals(3, team.size());
     }
     
     @Test
     public void huipunHaku() {
         stats = new Statistics(readerStub);
         List top = stats.topScorers(2);
         assertEquals(3, top.size()); //huipulla pelaajat 0, 1 ja 2
     }
     
}
