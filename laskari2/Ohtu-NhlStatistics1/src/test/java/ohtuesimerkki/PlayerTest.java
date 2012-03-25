package ohtuesimerkki;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antti Myyrä
 */
public class PlayerTest {
    
    Player pleijeri;
    
    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        pleijeri = new Player("Teemu Selänne", "Winnipeg Jets", 40, 56);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tiedotTallentuvatOikein() {
        assertEquals("Teemu Selänne", pleijeri.getName());
        assertEquals("Winnipeg Jets", pleijeri.getTeam());
        assertEquals(40, pleijeri.getGoals());
        assertEquals(56, pleijeri.getAssists());
    }
    
    @Test
    public void nimenMuutosToimii() {
        pleijeri.setName("Jari Kurri");
        assertEquals("Jari Kurri", pleijeri.getName());
    }
    
    @Test
    public void joukkueenMuutosToimii() {
        pleijeri.setTeam("Anaheim Ducks");
        assertEquals("Anaheim Ducks", pleijeri.getTeam());
    }
    
    @Test
    public void pisteidenMuutosToimii() {
        assertEquals(96, pleijeri.getPoints());
        
        pleijeri.setGoals(pleijeri.getGoals() + 5);
        assertEquals(45, pleijeri.getGoals());
        
        pleijeri.setAssists(pleijeri.getAssists() + 10);
        assertEquals(66, pleijeri.getAssists());
        
        assertEquals(111, pleijeri.getPoints());
    }
    
    @Test
    public void toStringToimii() {
        assertEquals("Teemu Selänne        Winnipeg Jets 40 + 56 = 96", pleijeri.toString());
    }
    
    @Test
    public void vertailuToimii() {
        Player toinen = new Player("Jari Kurri", "Jokerit", 84, 65);
        
        assertEquals(53, pleijeri.compareTo(toinen));
    }
}
