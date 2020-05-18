package washer.Test;

import org.junit.Test;
import washer.engine.Node;
import washer.engine.WasherEngine;
import washer.game.Board;
import washer.game.Ply;
import washer.game.Side;

import static org.junit.Assert.*;

public class WasherEngineTest {

    @Test
    public void TestEvaluate() {
        Board b = new Board();
        WasherEngine e = new WasherEngine(b);
        assertEquals(0, e.evaluate(b));
    }
    @Test
    public void evaluate() {
        Board b = new Board();
        WasherEngine e = new WasherEngine(b);
        assertEquals(0, e.evaluate(b));
    }

    @Test
    public void TestIndent(){
        Board b = new Board();
        WasherEngine e = new WasherEngine(b);
        for(int i=0; i<100; i++) {
            assertEquals(i, e.indentPublic(i).length());
        }
    }
}