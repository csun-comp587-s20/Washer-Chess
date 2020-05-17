package washer.Test;

import org.junit.Test;
import org.mockito.Mock;
import washer.game.*;
import washer.pieces.King;
import washer.pieces.Knight;
import washer.pieces.Piece;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static washer.game.Side.WHITE;

public class PieceListTest {

    @Mock
    Knight knight;
    @Mock
    King king;
    @Mock
    Side side;
    @Mock
    PieceListFactory pieceListFactory;

    @Test
    public void test_size(){
        Map<Integer, BoardEntry> map = new HashMap<Integer,BoardEntry>();
        BoardEntry boardEntry = new BoardEntry(6);
        map.put(1,boardEntry);
        PieceList pieceList = new PieceList(map);
        assertEquals(1,pieceList.size());
    }

    @Test
    public void test_size_is_zero(){
        PieceList pieceList = new PieceList();
        assertEquals(0,pieceList.size());
    }

    /*Bug Alert*/
    /*The constructor for the PieceList class needs to be refactored to return the proper size
     * Refactored the code to get the proper result*/
    @Test
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

    @Test
    public void test_getEntries(){
        Map<Integer, BoardEntry> map = new HashMap<Integer,BoardEntry>();
        BoardEntry boardEntry = new BoardEntry(6);
        map.put(1,boardEntry);
        PieceList pieceList = new PieceList(map);
        assertEquals(map,pieceList.getEntries());
    }

    @Test
    public void test_valuesReturnedInsideBoardEntry(){
        Map<Integer, BoardEntry> map = new HashMap<Integer,BoardEntry>();
        BoardEntry boardEntry1 = new BoardEntry(6,king);
        BoardEntry boardEntry2 = new BoardEntry(6,knight);
        map.put(1,boardEntry1);
        map.put(2,boardEntry2);
        ArrayList<BoardEntry> arrayList = new ArrayList<BoardEntry>();
        arrayList.add(boardEntry1);
        arrayList.add(boardEntry2);
        PieceList pieceList = new PieceList(map);
        assertArrayEquals(arrayList.toArray(),pieceList.values().toArray());
    }

    @Test
    public void test_boardEntry_getEntry_values_for_different_boardEntries(){
        BoardEntry boardEntry1 = new BoardEntry(6);
        BoardEntry boardEntry2 = new BoardEntry(6);
        Map<Integer, BoardEntry> map1 = new HashMap<Integer,BoardEntry>();
        Map<Integer, BoardEntry> map2 = new HashMap<Integer,BoardEntry>();
        map1.put(1, boardEntry2);
        map2.put(1,boardEntry2);
        PieceList pieceList1 = new PieceList(map1);
        PieceList pieceList2 = new PieceList(map1);
        assertEquals(pieceList2.getEntry(1),pieceList1.getEntry(1));
    }

//    @Test
//    public void test_calculateScore(){
//        Map<Integer, BoardEntry> map = new HashMap<Integer,BoardEntry>();
//        BoardEntry boardEntry = new BoardEntry(6,king);
//        BoardEntry boardEntry1 = new BoardEntry(boardEntry);
//        map.put(1,boardEntry1);
//        PieceList pieceList = new PieceList(map);
//        assertEquals(2,pieceList.calculateScore());
//    }
}