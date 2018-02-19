package bst;

import bst.Node;

public class SimpleCheck {
    public static boolean checkBST(Node root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        return fullCheck(root, root.left, root.right);
//        return realTraverse(root, root.left, root.right);
    }


    ///do not touch this!
    static boolean realTraverse(Node root, Node left, Node right) {
        if (left != null && left.left != null) {
            return realTraverse(left, left.left, left.right);
        }

        if (left != null && root.data <= left.data) {
            return false;
        }


        if (right != null && right.right != null) {
            return realTraverse(right, right.left, right.right);
        }

        if (right != null && root.data >= right.data) {
            return false;
        }
        return true;
    }

    private static boolean fullCheck(Node root, Node left, Node right) {

        if (left != null && left.left != null) {
            return fullCheck(left, left.left, left.right);
        }

        if (left != null && root.data < left.data) {
            return false;
        }

        if (right != null && right.right != null) {
            return fullCheck(right, right.left, right.right);
        }

        if (right != null && root.data > right.data) {
            return false;
        }

        return checkLeftSubTree(root) && checkRightChildTree(root);
    }

//make it simply with java 8???    

    private static boolean checkLeftSubTree(Node root) {
        Node left = root.left;

        if (left == null || left.right == null) {
            return true;
        }
        Node max = getRightest(left);
        return max.data < root.data;
    }

    private static Node getRightest(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private static boolean checkRightChildTree(Node root) {
        Node right = root.right;
        if (right == null || right.left == null) {
            return true;
        }
        Node min = getLeftest(right);
        return min.data > root.data;
    }

    private static Node getLeftest(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    //Some trash
    /*

    public static bst.Node traverseLeft(bst.Node bst) {
        bst.Node result = bst;
        if (bst.left != null) {
            result = traverseLeft(bst.left);
        }
        return result;
    }

    private static bst.Node traverseRight(bst.Node bst) {
        bst.Node result = bst;
        if (bst.right != null) {
            result = traverseRight(bst.left);
        }
        return result;
    }

    //TODO remove this
    public static bst.Node fullCheck(bst.Node bst) {
        bst.Node middle = bst;
        bst.Node left = traverseLeft(middle);
        bst.Node right = traverseRight(middle);
        return null;
    }
*/


}
