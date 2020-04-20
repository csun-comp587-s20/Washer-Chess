package washer.Test;

import com.sun.org.glassfish.external.amx.AMXGlassfish;

import org.junit.Assert;
import org.junit.Test;
import washer.game.Board;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
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
        Assert.assertTrue(board.isValidLocation(70));
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
    public void TestSquareAttached(){

    }

}