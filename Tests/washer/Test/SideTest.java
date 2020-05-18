package washer.Test;

import org.junit.Test;
import washer.game.Side;

import static org.junit.Assert.*;

public class SideTest {

    @Test
    public void oppositeOfWhite() {
        Side s = Side.WHITE;
       assertTrue(Side.BLACK == s.opposite());
    }
    @Test
    public void oppositeOfBlack() {
        Side s = Side.BLACK;
        assertTrue(Side.WHITE == s.opposite());
    }
}