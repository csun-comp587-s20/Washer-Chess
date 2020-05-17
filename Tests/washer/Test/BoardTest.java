package washer.Test;

import com.sun.org.glassfish.external.amx.AMXGlassfish;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import washer.game.*;
import washer.pieces.King;
import washer.pieces.Piece;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Mock
    King king;
    @Mock
    Ply ply;
    @Mock
    Piece piece;
    @Mock
    PieceList pieceList1;
    @Mock
    PieceList pieceList2;
    @Mock
    Side side;
    @Mock
    Outcome outcome;

    public Map<Integer,Set<Ply>> generatePly(){
        Map<Integer, Set<Ply>> map = new HashMap<Integer, Set<Ply>>();
        Set<Ply> set = new HashSet<Ply>();
        set.add(ply);
        map.put(1,set);
        return map;
    }

    public Board generateBoard(){
        BoardEntry boardEntry1 = new BoardEntry(1,king);
        BoardEntry[] boardEntries1 = new BoardEntry[]{boardEntry1};
        PlyTable plyTable = new PlyTable(generatePly());
        Map<Integer, BoardEntry> map = new HashMap<Integer,BoardEntry>();
        BoardEntry boardEntry = new BoardEntry(6);
        map.put(1,boardEntry);
        PieceList pieceList = new PieceList(map);
        Board board = new Board(boardEntries1,plyTable,pieceList1,pieceList2,10,2,true,true,true,true,side,outcome.INSUFFICIENT_MATERIAL_DRAW);
        return board;
    }

    @Test
    public void TestGetLocation(){
        Board board = new Board();
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            int rInt = r.nextInt();
            int fint = board.getFile(i);
            assertTrue(fint<=7 && fint>=0);
        }
    }
    @Test
    public void TestIsValidateLocationT(){
        Board board =new Board();
        assertTrue(board.isValidLocation(70));
    }
    @Test
    public void TestIsValidateLocationF(){
        Board board = new Board();
        Assert.assertFalse(board.isValidLocation(150));
    }
    @Test
    public void  testGetFile(){
        Board board = new Board();
        for(int i=0; i <= 50; i++){
            assertEquals(i%8, board.getFile(i));
        }
    }
    @Test
    public void testGetFile1(){
        Board board =  new Board();
        for(int i = 0; i<150; i++) {
            assertEquals(i/16, board.getRank(i));
        }
    }
    @Test
    public void TestTo8x8(){
        Board board = new Board();
        int n;
        for(int i = 0; i<50; i++) {
            n = i%8;
            n = i + n;
            n = n/2;
            assertEquals(n, board.to8x8(i));
        }
    }
    @Test
    public void test_isDraw(){
        Board board = new Board(generateBoard());
        assertTrue(board.isDraw());
    }

}