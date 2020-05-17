package washer.Test;

import org.junit.Test;
import org.mockito.Mock;
import washer.game.Board;
import washer.game.BoardArrayFactory;
import washer.game.BoardEntry;
import washer.pieces.King;
import washer.pieces.Piece;
import washer.pieces.Queen;

import static org.junit.Assert.*;

public class BoardArrayFactoryTest {

    @Mock
    King king;

    @Test
    public void test_copyBoard_for_two_different_boardEntries(){
        BoardArrayFactory boardArrayFactory = new BoardArrayFactory();
        BoardEntry boardEntry1 = new BoardEntry(1,king);
        BoardEntry boardEntry2 = new BoardEntry(1,king);
        BoardEntry[] boardEntries1 = new BoardEntry[]{boardEntry1};
        BoardEntry[] boardEntries2 = new BoardEntry[]{boardEntry2};

        assertFalse(boardArrayFactory.copyBoard(boardEntries1).equals(boardArrayFactory.copyBoard(boardEntries2)));
    }

}