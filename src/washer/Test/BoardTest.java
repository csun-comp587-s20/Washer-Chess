package washer.Test;

import org.junit.Test;
import washer.game.Board;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void TestGetLocation(){
        Board board = new Board();
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            int rInt = r.nextInt();
            int fint = board.getFile(i);
            assertTrue(fint<=7 && fint>=0);
        }
    }
}