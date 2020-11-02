package ohtuesimerkki;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            return players;
        }
    };

    private Statistics statistics;

    @Before
    public void setUp() {
        statistics = new Statistics(readerStub);


    }

    @Test
    public void searchByNameFindsExistingByNameCorrectly() {
        Player player = this.statistics.search("Semenko");
        assert (player != null);
    }

    @Test
    public void searchByNameFindsExistingByNameCorrectly2() {
        Player player = this.statistics.search("NonExisting");
        assert (player == null);
    }

    @Test
    public void searchByNameFindsExistingByTeamCorrectly() {
        List<Player> player = this.statistics.team("EDM");
        assert (player.size() == 3);
    }

    @Test
    public void searchByNameFindsExistingByTeamCorrectly2() {
        List<Player> player = this.statistics.team("NonExisting");
        assert (player.size() == 0);
    }

    @Test
    public void topScorersCorrectOrder() {
        List<Player> players = this.statistics.topScorers(4);
        Integer last = null;
        for (Player player : players) {
            if (last == null) last = player.getPoints();
            else {
                assert(player.getPoints() <= last);
                last = player.getPoints();
            }
        }
    }
}
