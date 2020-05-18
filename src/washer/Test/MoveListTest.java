package washer.Test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import washer.game.MoveList;
import washer.game.Ply;
import java.util.ArrayList;


public class MoveListTest {
    @Mock
    Ply play1;
    Ply play2;

    @Test
    public void TestGetNumMoves0(){
        MoveList moveList = new MoveList();
        Assert.assertEquals(0, moveList.getNumMoves());
    }
    @Test
    public void TestGetNumMoves1(){
        MoveList moveList = new MoveList();
        moveList.addMove(play1);
        Assert.assertEquals(1, moveList.getNumMoves());
    }
    @Test
    public void TestGetNumMoves2(){
        MoveList moveList = new MoveList();
        moveList.addMove(play1);
        moveList.addMove(play2);
        Assert.assertEquals(2, moveList.getNumMoves());
    }

    //Failed this test, No case is defined for incorrect index number
    ///////////
    @Test (expected  = NullPointerException.class)
    public void TestGetMoveAtNull(){
        MoveList moveList = new MoveList();
        Assert.assertEquals(0, moveList.getMoveAt(5));
    }
    //////////////
    @Test
    public void TestGetMoveAt1(){
        MoveList moveList = new MoveList();
        moveList.addMove(play1);
        Assert.assertEquals(play1, moveList.getMoveAt(0));
    }
  
    @Test
    public void getAllMoves0(){
        ArrayList<Ply> p= new ArrayList<Ply>();
        MoveList moveList = new MoveList();
        Assert.assertEquals(p.toString(), moveList.getAllMoves()+"");
    }

    @Test
    public void getAllMoves1(){
        ArrayList<Ply> p= new ArrayList<Ply>();
        p.add(play1);
        MoveList moveList = new MoveList();
        moveList.addMove(play1);
        Assert.assertEquals(p.toString(), moveList.getAllMoves()+"");
    }
    @Test
    public void getAllMoves2(){
        ArrayList<Ply> p= new ArrayList<Ply>();
        p.add(play1);
        p.add(play2);
        MoveList moveList = new MoveList();
        moveList.addMove(play1);
        moveList.addMove(play2);
        Assert.assertEquals(p, moveList.getAllMoves());
    }
    @Test (expected  = NullPointerException.class)
    public void RemoveMoves2(){
        MoveList moveList = new MoveList();
        moveList.addMove(play1);
        moveList.addMove(play2);
        moveList.removeMove();
        Assert.assertEquals(null ,moveList) ;
    }
    @Test
    public void testToString0(){ ;
        MoveList moveList = new MoveList();
        Assert.assertEquals("", moveList.toString()) ;
    }
    @Test
    public void testToString2(){
        MoveList moveList = new MoveList();
        moveList.addMove(play1);
        moveList.addMove(play2);
        Assert.assertEquals("null null ", moveList.toString()) ;
    }
}
