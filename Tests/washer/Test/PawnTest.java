package washer.Test;

import org.junit.Assert;
import org.junit.Test;
import washer.Utilities;
import washer.game.*;
import washer.pieces.Pawn;
import washer.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PawnTest {

    @Test
    public void reevaluate() {
    }

    @Test
    public void getLegalMoves() {
    }


    @Test
    public void TestGetMobilityWhite(){
        int[] WHITE_MOBILITY_BONUS = {
                0, 0, 0, 0, 0, 0, 0, 0,
                5, 10, 10, -20, -20, 10, 10, 5,
                0, -5, -10, 0, 0, -10, -5, 0,
                0, 0, 0, 20, 20, 0, 0, 0,
                5, 5, 10, 25, 25, 10, 5, 5,
                10, 10, 20, 30, 30, 20, 10, 10,
                50, 50, 50, 50, 50, 50, 50, 50,
                0, 0, 0, 0, 0, 0, 0, 0};
        Pawn p = new Pawn(Side.WHITE);
        assertArrayEquals(p.getMobility(),WHITE_MOBILITY_BONUS );
    }
    @Test
    public void TestGetMobilityBlack(){
        int[] BLACK_MOBILITY_BONUS = {
                0, 0, 0, 0, 0, 0, 0, 0,
                50, 50, 50, 50, 50, 50, 50, 50,
                10, 10, 20, 30, 30, 20, 10, 10,
                5, 5, 10, 25, 25, 10, 5, 5,
                0, 0, 0, 20, 20, 0, 0, 0,
                0, -5, -10, 0, 0, -10, -5, 0,
                5, 10, 10, -20, -20, 10, 10, 5,
                0, 0, 0, 0, 0, 0, 0, 0};
        Pawn p = new Pawn(Side.BLACK);
        assertArrayEquals(p.getMobility(), BLACK_MOBILITY_BONUS );
    }
    @Test
    public void TestReevaluateIntBlack(){
        Pawn p = new Pawn(Side.BLACK);
        assertEquals(100,p.reevaluateInt(10));
        assertEquals(100,p.reevaluateInt(0));
        assertEquals(110,p.reevaluateInt(50));
    }
    @Test
    public void TestReevaluateIntWhite(){
        Pawn p = new Pawn(Side.WHITE);
        assertEquals(100,p.reevaluateInt(50));
        assertEquals(100,p.reevaluateInt(0));
        assertEquals(80,p.reevaluateInt(20));
    }
    @Test
    public void TestGetLegalMovesBlack(){
        Pawn p = new Pawn(Side.BLACK);
        Board board = new Board();
        Ply p1 = new Ply(50,20, Piece.BLACK_QUEEN, board.getPieceAt(50),board.getPieceAt(20),0,board.getKWC (), board.getKBC (), board.getQWC (), board.getQBC (), board.getSide ());
        Ply p2 = new Ply(50,20, Piece.BLACK_ROOK, board.getPieceAt(50),board.getPieceAt(20),0,board.getKWC (), board.getKBC (), board.getQWC (), board.getQBC (), board.getSide ());
        Ply p3 = new Ply(50,20, Piece.BLACK_BISHOP, board.getPieceAt(50),board.getPieceAt(20),0,board.getKWC (), board.getKBC (), board.getQWC (), board.getQBC (), board.getSide ());
        Ply p4 = new Ply(50,20, Piece.BLACK_KNIGHT, board.getPieceAt(50),board.getPieceAt(20),0,board.getKWC (), board.getKBC (), board.getQWC (), board.getQBC (), board.getSide ());
        List<Ply> list = new ArrayList<Ply>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Assert.assertArrayEquals(list.toArray(),p.getPromotionalMovesPublic( board,50,20,true, true).toArray());
    }
    @Test
    public void TestGetLegalMovesWhite(){
        Pawn p = new Pawn(Side.WHITE);
        Board board = new Board();
        Ply p1 = new Ply(50,20, Piece.WHITE_QUEEN, board.getPieceAt(50),board.getPieceAt(20),0,board.getKWC (), board.getKBC (), board.getQWC (), board.getQBC (), board.getSide ());
        Ply p2 = new Ply(50,20, Piece.WHITE_ROOK, board.getPieceAt(50),board.getPieceAt(20),0,board.getKWC (), board.getKBC (), board.getQWC (), board.getQBC (), board.getSide ());
        Ply p3 = new Ply(50,20, Piece.WHITE_BISHOP, board.getPieceAt(50),board.getPieceAt(20),0,board.getKWC (), board.getKBC (), board.getQWC (), board.getQBC (), board.getSide ());
        Ply p4 = new Ply(50,20, Piece.WHITE_KNIGHT, board.getPieceAt(50),board.getPieceAt(20),0,board.getKWC (), board.getKBC (), board.getQWC (), board.getQBC (), board.getSide ());
        List<Ply> list = new ArrayList<Ply>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Assert.assertArrayEquals(list.toArray(),p.getPromotionalMovesPublic( board,50,20,false, true).toArray());
    }
    @Test
    public void TestGetEnPassentMove(){
        Pawn p = new Pawn(Side.WHITE);
        Board board = new Board();
        assertEquals(null,p.getEnPassentMovePublic(board, 50, 20,10,false));
    }

    @Test
    public void TestGetEnPassentMove2(){
        Pawn p = new Pawn(Side.BLACK);
        BoardArrayFactory b;

        Board board = new Board();
        assertEquals(null,p.getEnPassentMovePublic(board, 50, 20,17,false));
    }



}