package washer.Test;

import org.junit.Test;
import washer.engine.Node;
import washer.engine.Tree;
import washer.game.Ply;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void TestGetNodeEmpty(){
        Tree tree = new Tree();
        Node<Ply> node = new Node<>();
        tree.setNode(node);
        assertEquals(node, tree.getNode());
    }
    @Test
    public void TestGetNodeHasAChild(){
        Tree tree = new Tree();
        Node<Integer> node = new Node<>();
        node.setData(1);
        node.addChild(2);
        tree.setNode(node);
        assertEquals(node, tree.getNode());
    }
    //doesn't convert an empty list to string,
    //gives a null pointer error
    @Test
    public void TestToListNull(){
        Tree tree = new Tree();
        Node<Integer> node = new Node<>();
        tree.setNode(node);
        List<Integer> list=new ArrayList<>();
        assertEquals(list, tree.toList());
    }
    @Test
    public void TestToListNotNull(){
        Tree tree = new Tree();
        Node<Integer> node = new Node<>();
        node.setData(1);
        node.addChild(2);
        tree.setNode(node);
        String s= new String("[{1,[2]}, {2,[]}]");
        assertEquals(s, tree.toList().toString());
    }
    
}
