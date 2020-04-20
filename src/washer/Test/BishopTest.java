package washer.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import jdk.nashorn.internal.objects.annotations.Where;
import washer.game.Board;
import washer.game.Ply;
import washer.game.Side;
import java.util.List;
import java.util.Random;
import washer.pieces.Bishop;
import washer.pieces.Piece;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class BishopTest {
    @Mock
    Side  side;

    @Mock
    Board board;

    @Test
    public void TestGetMobilityWhite(){
        int[] WHITE_MOBILITY_BONUS = {
                -20, -10, -10, -10, -10, -10, -10, -20,
                -10, 5, 0, 0, 0, 0, 5, -10,
                -10, 10, 10, 10, 10, 10, 10, -10,
                -10, 0, 10, 10, 10, 10, 0, -10,
                -10, 5, 5, 10, 10, 5, 5, -10,
                -10, 0, 5, 10, 10, 5, 0, -10,
                -10, 0, 0, 0, 0, 0, 0, -10,
                -20, -10, -10, -10, -10, -10, -10, -20};
        Bishop b = new Bishop(Side.WHITE);
        assertArrayEquals(b.getMobility(),WHITE_MOBILITY_BONUS );
    }
    @Test
    public void TestGetMobilityBlack(){
        int[] BLACK_MOBILITY_BONUS = {
                -20, -10, -10, -10, -10, -10, -10, -20,
                -10, 0, 0, 0, 0, 0, 0, -10,
                -10, 0, 5, 10, 10, 5, 0, -10,
                -10, 5, 5, 10, 10, 5, 5, -10,
                -10, 0, 10, 10, 10, 10, 0, -10,
                -10, 10, 10, 10, 10, 10, 10, -10,
                -10, 5, 0, 0, 0, 0, 5, -10,
                -20, -10, -10, -10, -10, -10, -10, -20};
        Bishop b = new Bishop(Side.BLACK);
        assertArrayEquals(b.getMobility(),BLACK_MOBILITY_BONUS);
    }

    @Test
    public void TestReevaluate(){
        Bishop b = new Bishop(Side.BLACK);
       // assertEquals(320, b.reevaluateInt(-1));
        assertEquals(320, b.reevaluateInt(10));
        assertEquals(335, b.reevaluateInt(30));
        assertEquals(335, b.reevaluateInt(53));
        assertEquals(330, b.reevaluateInt(70));
        assertEquals(330, b.reevaluateInt(100));
    }

    @Test
    public void findDirectionalMove(){

        //assertLinesMatch();
    }
}