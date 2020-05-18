package washer.Test;

import org.junit.Test;
import org.mockito.Mock;
import washer.game.Ply;
import washer.game.Side;
import washer.pieces.Bishop;
import washer.pieces.King;
import washer.pieces.Piece;

import static org.junit.Assert.*;

public class PlyTest {

    @Mock
    Side side;
    @Mock
    Piece piece;
    @Mock
    King king;
    @Mock
    Bishop bishop;



    @Test
    public void testStartlocation() {
        Ply ply = new Ply(5,4,3,king,bishop,
                3,2,false,true,false,false,side.WHITE);
        assertEquals(5, ply.getStart());
        assertEquals(4,ply.getEnd());
        assertEquals(king,ply.getMoved());
        assertFalse(ply.capturedPiece());
        assertTrue(ply.getKBC());
        assertTrue(ply.getKBC());
        assertFalse(ply.getQWC());
    }


    @Test
    public void testEquals(){
        Ply ply1 = new Ply(5,4,3,king,bishop,
                3,2,false,true,false,false,side.WHITE);
        Ply ply2 = new Ply(5,4,3,king,bishop,
                3,2,false,true,false,false,side.WHITE);
        Ply ply3 = new Ply(1,4,6,bishop,bishop,
                3,2,true,true,false,false,side.BLACK);
        assertFalse(ply3.equals(ply2));
        assertTrue(ply1.equals(ply2));
    }

//    @Test
//    public void testHashCode(){
//        Ply ply1 = new Ply(5,4,3,null,null,
//                3,2,false,false,false,false,side.WHITE);
//        assertEquals(4208154108295L,ply1.hashCode());
//    }

    @Test(expected = NullPointerException.class)
    public void testCompareTo(){
        Ply ply1 = new Ply(5,4,3,king,bishop,
                3,2,false,true,false,false,side.WHITE);
        Ply ply2 = new Ply(1,4,6,king,bishop,
                3,2,true,true,false,false,side.WHITE);
        assertEquals(0,ply1.compareTo(ply2));
    }



}