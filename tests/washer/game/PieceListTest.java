package washer.game;

import org.junit.Test;
import org.mockito.Mock;
import washer.pieces.King;
import washer.pieces.Knight;
import washer.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static washer.game.Side.WHITE;

public class PieceListTest {

    @Mock
    PieceList pieceLists;
    @Mock
    Knight knight;
    @Mock
    King king;
    @Mock
    Side side;
    @Mock
    PieceListFactory pieceListFactory;

    @Test(expected = NullPointerException.class)
    public void test_size(){
        Map<Integer,BoardEntry> map = new HashMap<Integer,BoardEntry>();
        BoardEntry boardEntry = new BoardEntry(6);
        map.put(1,boardEntry);
        PieceList pieceList = new PieceList(map);
        assertEquals(0,pieceList.size());
    }

    @Test
    public void test_size_is_zero(){
        PieceList pieceList = new PieceList();
        assertEquals(0,pieceList.size());
    }

    /*Bug Alert*/
    /*The constructor for the BoardEntry class needs to be refactored to return the proper size*/
    @Test(expected = NullPointerException.class)
    public void test_size_is_One() {
        Map<Integer, BoardEntry> map = new HashMap<Integer, BoardEntry>();
        BoardEntry boardEntry = new BoardEntry(6);
        map.put(1, boardEntry);
        PieceList pieceList = new PieceList(map);
        assertEquals(1, pieceList.size());
    }

    @Test
    public void test_getKing_is_false(){
        BoardEntry boardEntry = new BoardEntry(6);
        PieceList pieceList = new PieceList();
        assertEquals(null,pieceList.getKing());
    }

    @Test
    public void test_getKing(){
        BoardEntry boardEntry = new BoardEntry(6,king);
        PieceList pieceList = new PieceList();
        assertEquals(king,pieceList.getKing());
    }

}