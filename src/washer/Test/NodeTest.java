package washer.Test;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import washer.engine.Node;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    public  void getNumberOfChildTest() {
        Node<Integer> node = new Node<>();

        for (int i = 0; i < 10; i++) {
            assertEquals(i, node.getNumberOfChildren());
            node.addChild(i);
            //Assert.assertEquals(i, node.getChild(i));
        }
    }
    @Test
    public  void getChildTest() {
        Node<Integer> node = new Node<>();
        for (int i = 0; i < 10; i++) {
            node.addChild(i);
            Assert.assertEquals("{" + i + ",[]}", node.getChild(i).toString());
        }
    }
    @Test
    public  void getChildrenTest() {
        Node<Integer> node = new Node<>();
        Node<Integer> nodeForList = new Node<>();
        List<Node<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            nodeForList =new Node(i);
            node.addChild(i);
            list.add(nodeForList);
        }
        Assert.assertEquals( list.toString(), node.getChildren().toString());
    }

    //Failed
    @Test
    public void addChildAt0Test(){
        Node<Integer> node = new Node<>();
        node = new Node<>(0);
        node.addChildAt(0, node);
        Assert.assertEquals("{" + 0 + ",[0]}", node.getChild(0).toString());
    }

    //fails, although isn't supposed to fail
    @Test
    public void addChildAt01Test(){
        Node<Integer> node1 = new Node<>();
        Node<Integer> node2 = new Node<>();
        node1 = new Node<>(0);
        node1.addChildAt(0, node1);
        node2 = new Node<>(1);
        node2.addChildAt(1, node2);
        Assert.assertEquals("{" + 0 + ",[]}", node1.getChild(0).toString());
        Assert.assertEquals("{" + 1 + ",[]}", node2.getChild(1).toString());
    }
    @Test (expected  = NullPointerException.class)
    public void addChildAt_OutOfSize_Test(){
        Node<Integer> node = new Node<>();
        node = new Node<>(0);
        node.addChildAt(2, node);
        Assert.assertEquals("{" + 0 + ",[]}", node.getChild(2).toString());
    }
    //Bug: Expected to insert at 2 but doesn't
    @Test (expected = IndexOutOfBoundsException.class)
    public void addChildAt_IndexOutOfBound_Test(){
        Node<Integer> node = new Node<>();
        node.addChild(0);
        node.addChild(2);
        node = new Node<>(1);
        node.addChildAt(1,node);
        Assert.assertEquals("{" + 1 + ",[]}", node.getChild(1).toString());
    }
    @Test
    public void removeChildAtTest(){
        Node<Integer> node = new Node<>();
        node.addChild(0);
        node.addChild(1);
        node.removeChildAt(1);
        Assert.assertEquals( "[{" + 0 + ",[]}]", node.getChildren().toString());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeChildAt_OutOfBound_Test(){
        Node<Integer> node = new Node<>();
        node.addChild(0);
        node.removeChildAt(1);
    }
    @Test(expected = NullPointerException.class)
    public void removeChildAt_FromNull_Test(){
        Node<Integer> node = new Node<>();
        node.removeChildAt(0);
    }
    @Test (expected = IllegalArgumentException.class)
    public void getChildNullTest() {
        Node<Integer> node = new Node<>();
        Assert.assertEquals(null,node.getChild(2));
    }
    @Test ( expected  = NullPointerException.class)
    public void toStringNoll(){
        Node<Integer> node = new Node<>();
        String s= new String("{,[]}") ;
        Assert.assertEquals(s, node.toString());
        Assert.assertFalse(node.hasChildren());
    }
    @Test
    public void toString1(){
        Node<Integer> node = new Node<>(1);
        String s= new String("{1,[]}") ;
        Assert.assertEquals(s, node.toString());
        Assert.assertFalse(node.hasChildren());
    }
    @Test
    public void toString12(){
        Node<Integer> node = new Node<>(1);
        node.addChild(2);
        String s= new String("{1,[2]}") ;
        Assert.assertEquals(s, node.toString());
        Assert.assertTrue(node.hasChildren());
    }
    @Test
    public void toString123(){
        Node<Integer> node = new Node<>(1);
        node.addChild(2);
        node.addChild(3);
        String s= new String("{1,[2,3]}") ;
        Assert.assertEquals(s, node.toString());
        Assert.assertTrue(node.hasChildren());
    }
    @Test
    public void toStringNodeType123(){
        Node<Integer> node = new Node<>(1);
        node.addChild(2);
        node.addChild(3);
        String s= new String("{1,[2,3]}") ;
        Assert.assertEquals(s, node.toString());
        Assert.assertTrue(node.hasChildren());
    }
}