package washer.Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import washer.game.Board;
import washer.game.Ply;
import washer.game.Side;
import washer.pieces.Bishop;
import washer.pieces.Queen;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;

public class QueenTest {

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void TestGetMobilityBlack(){
        int[] BLACK_MOBILITY_BONUS = {
                -20, -10, -10, -5, -5, -10, -10, -20,
                -10, 0, 0, 0, 0, 0, 0, -10,
                -10, 0, 5, 5, 5, 5, 0, -10,
                -5, 0, 5, 5, 5, 5, 0, -5,
                0, 0, 5, 5, 5, 5, 0, -5,
                -10, 5, 5, 5, 5, 5, 0, -10,
                -10, 0, 5, 0, 0, 0, 0, -10,
                -20, -10, -10, -5, -5, -10, -10, -20
        };
        Queen q = new Queen(Side.BLACK);
        assertArrayEquals(q.getMobility(), BLACK_MOBILITY_BONUS);
    }
    @Test
    public void TestGetMobilityWith(){
        int[] WHITE_MOBILITY_BONUS = {
                -20, -10, -10, -5, -5, -10, -10, -20,
                -10, 0, 5, 0, 0, 0, 0, -10,
                -10, 5, 5, 5, 5, 5, 0, -10,
                0, 0, 5, 5, 5, 5, 0, -5,
                -5, 0, 5, 5, 5, 5, 0, -5,
                -10, 0, 5, 5, 5, 5, 0, -10,
                -10, 0, 0, 0, 0, 0, 0, -10,
                -20, -10, -10, -5, -5, -10, -10, -20
        };
        Queen q = new Queen(Side.WHITE);
        assertArrayEquals(q.getMobility(), WHITE_MOBILITY_BONUS);
    }
    @Test
    public void TestReevaluateBlack(){
        Queen q = new Queen(Side.BLACK);
        assertEquals(880, q.reevaluateInt(0));
        assertEquals(890, q.reevaluateInt(5));
    }
    @Test
    public void TestReevaluateWhite(){
        Queen q = new Queen(Side.WHITE);
        assertEquals(880, q.reevaluateInt(0));
        assertEquals(890, q.reevaluateInt(5));
    }
    @Test
    public void TestFindDirectionalMove(){
        Queen q = new Queen(Side.BLACK);
        List<Ply> list = new ArrayList<Ply>();
        Board board = new Board();
        assertArrayEquals(list.toArray(),q.findDirectionalMovesPublic(board, -20,5,false).toArray());
    }
    @Test
    public void TestFindDirectionalMove2(){
        Queen q = new Queen(Side.WHITE);
        List<Ply> list = new ArrayList<Ply>();
        Board board = new Board();
        assertArrayEquals(list.toArray(),q.findDirectionalMovesPublic(board, -20,5,true).toArray());
    }
}