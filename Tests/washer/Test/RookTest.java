package washer.Test;

import org.junit.Test;
import washer.game.Board;
import washer.game.Ply;
import washer.game.Side;
import washer.pieces.Bishop;
import washer.pieces.Pawn;
import washer.pieces.Rook;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RookTest {
    @Test
    public void TestGetMobilityWhite(){
        int[] WHITE_MOBILITY_BONUS = {
                0, 0, 0, 5, 5, 0, 0, 0,
                -5, 0, 0, 0, 0, 0, 0, -5,
                -5, 0, 0, 0, 0, 0, 0, -5,
                -5, 0, 0, 0, 0, 0, 0, -5,
                -5, 0, 0, 0, 0, 0, 0, -5,
                -5, 0, 0, 0, 0, 0, 0, -5,
                5, 10, 10, 10, 10, 10, 10, 5,
                0, 0, 0, 0, 0, 0, 0, 0
        };
        Rook r = new Rook(Side.WHITE, true);
        assertArrayEquals(r.getMobility(),WHITE_MOBILITY_BONUS);
    }
    @Test
    public void TestGetMobilityBlack(){
        int[] BLACK_MOBILITY_BONUS = {
                0, 0, 0, 0, 0, 0, 0, 0,
                5, 10, 10, 10, 10, 10, 10, 5,
                -5, 0, 0, 0, 0, 0, 0, -5,
                -5, 0, 0, 0, 0, 0, 0, -5,
                -5, 0, 0, 0, 0, 0, 0, -5,
                -5, 0, 0, 0, 0, 0, 0, -5,
                -5, 0, 0, 0, 0, 0, 0, -5,
                0, 0, 0, 5, 5, 0, 0, 0
        };
        Rook r = new Rook(Side.BLACK, true);
        assertArrayEquals(r.getMobility(),BLACK_MOBILITY_BONUS);
    }
    @Test
    public void TestIsKSideTrue(){
        Rook r = new Rook(Side.BLACK, true);
        assertTrue(r.isKSide());
    }
    @Test
    public void TestIsKSideFalse(){
        Rook r = new Rook(Side.BLACK, false);
        assertFalse(r.isKSide());
    }
    @Test
    public void TestFindDirectionalMove(){
        Rook b = new Rook(Side.BLACK,true);
        List<Ply> list = new ArrayList<Ply>();
        Board board = new Board();
        assertArrayEquals(list.toArray(),b.findDirectionalMovesPublic(board, -20,5,false).toArray());
    }
    @Test
    public void TestFindDirectionalMove2(){
        Rook b = new Rook(Side.WHITE,true);
        List<Ply> list = new ArrayList<Ply>();
        Board board = new Board();
        assertArrayEquals(list.toArray(),b.findDirectionalMovesPublic(board, -20,5,true).toArray());
    }
}