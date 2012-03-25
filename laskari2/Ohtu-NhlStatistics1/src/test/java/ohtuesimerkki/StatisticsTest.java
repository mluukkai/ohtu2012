/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Antti Myyrä
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
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void hakuLoytaaPelaajan() {
        assertEquals("EDM", stats.search("Kurri").getTeam());
    }
    
    @Test
    public void haetaanPelaajaaJotaEiOle() {
        assertEquals(null, stats.search("Ruutu"));
    }
    
    @Test
    public void joukkueenPelaajienPyyntoToimii() {
        List<Player> lista = stats.team("EDM");
        
        assertEquals(3, lista.size());
        assertEquals("Semenko", lista.get(0).getName());
    }
    
    @Test
    public void parhaidenPistemiestenPalautusToimii() {
        List<Player> lista = stats.topScorers(2);
        
        assertEquals("Gretzky", lista.get(0).getName());
        assertEquals("Lemieux", lista.get(1).getName());
        
        assertEquals(2, lista.size()); // Tällä löytyi alkup. metodista bugi, korjattiin.
        assertEquals(-25, lista.get(0).compareTo(lista.get(1)));
    }
}
