package washer.Test;

import org.junit.Test;
import org.mockito.Mock;
import washer.game.Board;
import washer.game.Side;
import washer.pieces.King;
import washer.pieces.Knight;

import static org.junit.Assert.*;

public class KnightTest {

    @Mock
    Side side;

    @Mock
    Board board;

    @Test
    public void TestGetMobilityWhite(){
        int[] WHITE_MOBILITY_BONUS = {
                -50, -40, -30, -30, -30, -30, -40, -50,
                -40, -20, 0, 5, 5, 0, -20, -40,
                -30, 5, 10, 15, 15, 10, 5, -30,
                -30, 5, 15, 20, 20, 15, 5, -30,
                -30, 0, 15, 20, 20, 15, 0, -30,
                -30, 0, 10, 15, 15, 10, 0, -30,
                -40, -20, 0, 0, 0, 0, -20, -40,
                -50, -40, -30, -30, -30, -30, -40, -50  };
        Knight kinght = new Knight(Side.WHITE);
        assertArrayEquals(kinght.getMobility(), WHITE_MOBILITY_BONUS );
    }
    @Test
    public void TestGetMobilityBlack(){
        int[] BLACK_MOBILITY_BONUS = {
                -50, -40, -30, -30, -30, -30, -40, -50,
                -40, -20, 0, 0, 0, 0, -20, -40,
                -30, 0, 10, 15, 15, 10, 0, -30,
                -30, 5, 15, 20, 20, 15, 5, -30,
                -30, 0, 15, 20, 20, 15, 0, -30,
                -30, 5, 10, 15, 15, 10, 5, -30,
                -40, -20, 0, 5, 5, 0, -20, -40,
                -50, -40, -30, -30, -30, -30, -40, -50 };
        Knight knight = new Knight (Side.BLACK);
        assertArrayEquals(knight.getMobility(),BLACK_MOBILITY_BONUS);
    }
}