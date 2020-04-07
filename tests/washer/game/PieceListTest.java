package washer.game;

import org.junit.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PieceListTest {

    @Mock
    BoardEntry boardEntry;

    @Test(expected = NullPointerException.class)
    public void test_size(){
        Map<Integer,BoardEntry> map = new HashMap<Integer,BoardEntry>();
        map.put(1,boardEntry);
        PieceList pieceList = new PieceList(map);
        assertEquals(0,pieceList.size());
    }

    @Test
    public void test_size_is_zero(){
        PieceList pieceList = new PieceList();
        assertEquals(0,pieceList.size());
    }
}