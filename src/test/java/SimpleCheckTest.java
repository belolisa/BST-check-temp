import bst.Node;
import bst.SimpleCheck;
import org.junit.Assert;
import org.junit.Test;

public class SimpleCheckTest {

    @Test
    public void checkBSTSingleNode() throws Exception {
        Node node = new Node(1, null, null);
        Assert.assertTrue(SimpleCheck.checkBST(node));
    }

    @Test
    public void checkBSTSimpleCorrect() throws Exception {
        Node left = new Node(1, null, null);
        Node right = new Node(3, null, null);
        Node root = new Node(2, left, right);

        Assert.assertTrue(SimpleCheck.checkBST(root));
    }

    @Test
    public void checkBSTSimpleIncorrect() throws Exception {
        Node left = new Node(3, null, null);
        Node right = new Node(1, null, null);
        Node root = new Node(2, left, right);

        Assert.assertFalse(SimpleCheck.checkBST(root));
    }


    @Test
    public void checkBSTLeftDegenerated() throws Exception {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, node1, null);
        Node node3 = new Node(3, node2, null);
        Assert.assertTrue(SimpleCheck.checkBST(node3));
    }

    @Test
    public void checkBSTRightDegenerated() throws Exception {
        Node node1 = new Node(3, null, null);
        Node node2 = new Node(2, null, node1);
        Node node3 = new Node(1, null, node2);
        Assert.assertTrue(SimpleCheck.checkBST(node3));
    }


    @Test
    public void checkBSTLeftDegeneratedIncorrect() throws Exception {
        Node node1 = new Node(3, null, null);
        Node node2 = new Node(2, node1, null);
        Node node3 = new Node(1, node2, null);
        Assert.assertFalse(SimpleCheck.checkBST(node3));
    }

    @Test
    public void checkBSTRightDegeneratedIncorrect() throws Exception {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, node1);
        Node node3 = new Node(3, null, node2);
        Assert.assertFalse(SimpleCheck.checkBST(node3));
    }

    /*
    * ---------2----
    * -----1-----------
    * -------3-------
    * */
    @Test
    public void checkBSTSubChildBiggerThenRoot() throws Exception {
        Node node1 = new Node(3, null, null);
        Node node2 = new Node(1, null, node1);
        Node node3 = new Node(2, node2, null);
        Assert.assertFalse(SimpleCheck.checkBST(node3));
    }


    @Test(expected = IllegalArgumentException.class)
    public void checkBSTNullNode() throws Exception {
        SimpleCheck.checkBST(null);
    }


}