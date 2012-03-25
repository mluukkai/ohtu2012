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

/**
 *
 * @author Antti Myyrä
 */
public class PlayerReaderTest {
    
    public PlayerReaderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lukijaToimiiOikein() {
        PlayerReader lukija = new PlayerReader("http://nhlstatistics.herokuapp.com/players.txt");
        
        List lista = lukija.getPlayers();
        
        assertEquals(876, lista.size());
    }
    
    @Test
    public void virheellinenUrlHuomataan() {
        PlayerReader lukija = new PlayerReader("http://nhlstatistics.herokuapp.com/players.tx");
    }
}
