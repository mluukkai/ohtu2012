package ohtuesimerkki;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: juho
 * Date: 3/25/12
 * Time: 7:35 PM
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

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void luettiinkoMitaan()
    {
        Assert.assertEquals(stats.team("EDM").size(), 3);
    }
    
    @Test
    public void loytyykoPelaaja()
    {
        Assert.assertEquals(stats.search("Lemieux").getName(), "Lemieux");
    }
    
    @Test
    public void eiPitaisiLoytyakkaan()
    {
        Assert.assertEquals(stats.search("foobar"), null);
    }
    
    @Test
    public void tahtiPelaajiaLoytyy()
    {
        Assert.assertEquals(stats.topScorers(4).size(), 5);
    }


    @Test
    public void tahtiPelaajiaLoytyyLiianVahan()
    {
        Assert.assertEquals(stats.topScorers(3).size(), 4);
    }

    @Test
    public void tahtiPelaajiaLoytyyYhtaan()
    {
        Assert.assertEquals(stats.topScorers(-1).size(), 0);
    }


}