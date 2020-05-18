package washer.Test;

import org.junit.Test;
import org.mockito.Mock;
import washer.game.BoardEntry;
import washer.game.PieceList;
import washer.game.PieceListFactory;
import washer.pieces.King;
import washer.pieces.Piece;
import washer.pieces.Queen;

import java.util.*;

import static org.junit.Assert.*;

public class PieceListFactoryTest {

    @Mock
    Piece piece;
    @Mock
    King king;
    @Mock
    Queen queen;

    @Test
    public void test_copy(){
        PieceListFactory pieceListFactory = new PieceListFactory();
        Map<Integer, BoardEntry> map = new HashMap<Integer,BoardEntry>();
        BoardEntry boardEntry = new BoardEntry(1,king);
        map.put(1,boardEntry);
        PieceList pieceList = new PieceList(map);
        assertEquals(map.toString(),pieceListFactory.copy(pieceList).toString());
    }

    @Test
    public void test_copy_using_two_different_lists(){
        PieceListFactory pieceListFactory = new PieceListFactory();
        Map<Integer, BoardEntry> map = new HashMap<Integer,BoardEntry>();
        BoardEntry boardEntry1 = new BoardEntry(1,king);
        BoardEntry boardEntry2 = new BoardEntry(2,queen);
        map.put(1,boardEntry1);
        map.put(2,boardEntry2);
        Map<Integer,BoardEntry> set = new LinkedHashMap<Integer,BoardEntry >();
        set.put(1,boardEntry1);
        set.put(2,boardEntry2);
        PieceList pieceList = new PieceList(map);
        assertEquals(set.toString(),pieceListFactory.copy(pieceList).toString());
    }
}