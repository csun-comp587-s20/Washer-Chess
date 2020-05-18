package washer.Test;

import org.junit.Test;
import org.mockito.Mock;
import washer.game.Board;
import washer.game.Side;
import washer.pieces.Bishop;
import washer.pieces.King;

import java.util.Random;

import static org.junit.Assert.*;

public class KingTest {

    @Mock
    Side side;

    @Mock
    Board board;

    @Test
    public void TestGetMobilityWhite(){
        int[] WHITE_MIDDLE_GAME_MOBILITY_BONUS = {
                20, 30, 10, 0, 0, 10, 30, 20,
                20, 20, 0, 0, 0, 0, 20, 20,
                -10, -20, -20, -20, -20, -20, -20, -10,
                -20, -30, -30, -40, -40, -30, -30, -20,
                -30, -40, -40, -50, -50, -40, -40, -30,
                -30, -40, -40, -50, -50, -40, -40, -30,
                -30, -40, -40, -50, -50, -40, -40, -30,
                -30, -40, -40, -50, -50, -40, -40, -30 };
        King king = new King(Side.WHITE);
        assertArrayEquals(king.getMobility(), WHITE_MIDDLE_GAME_MOBILITY_BONUS );
    }
    @Test
    public void TestGetMobilityBlack(){
        int[] BLACK_MIDDLE_GAME_MOBILITY_BONUS = {
                -30, -40, -40, -50, -50, -40, -40, -30,
                -30, -40, -40, -50, -50, -40, -40, -30,
                -30, -40, -40, -50, -50, -40, -40, -30,
                -30, -40, -40, -50, -50, -40, -40, -30,
                -20, -30, -30, -40, -40, -30, -30, -20,
                -10, -20, -20, -20, -20, -20, -20, -10,
                20, 20, 0, 0, 0, 0, 20, 20,
                20, 30, 10, 0, 0, 10, 30, 20 };
        King king = new King(Side.BLACK);
        assertArrayEquals(king.getMobility(),BLACK_MIDDLE_GAME_MOBILITY_BONUS);
    }

    @Test
    public void checkBooleanReturnIsFalse(){
        King king = new King(Side.WHITE);
        boolean check = true;
        assertFalse(king.isChecked());
    }

    @Test
    public void checkBooleanReturnUsingRandomGenerator(){
        King king = new King(Side.WHITE);
        double x = (int)(Math.random() * 5 +1);
        boolean check;
        double counter = (int) x%2;

        if (counter == 0){
            check = true;
            assertFalse(king.isChecked());
        }
        else{
            check = false;
            assertEquals(false,king.isChecked());
        }
    }
    @Test
    public void checkBooleanReturnWithArray(){
        King king = new King(Side.WHITE);
        int[] array = new int[] {0,1,1,0,0,0,1};
        boolean value;

        for(int i =0; i<array.length;i++){
            if (array[i]== 1) {
                value = true;
                assertFalse(king.isChecked());
            }
        }
    }
}