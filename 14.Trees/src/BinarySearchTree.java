//� A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(Comparable val) {
        root = add(val, root);
    }

    private TreeNode add(Comparable val, TreeNode tree) {
        if (tree == null) {
            tree = new TreeNode(val);
        }

        Comparable treeValue = tree.getValue();
        int dirTest = val.compareTo(treeValue);

        if (dirTest < 0) {
            tree.setLeft(add(val, tree.getLeft()));
        } else if (dirTest > 0) {
            tree.setRight(add(val, tree.getRight()));
        }

        return tree;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println("\n");
    }

    private void inOrder(TreeNode tree) {
        if (tree != null) {
            inOrder(tree.getLeft());
            System.out.print(tree.getValue() + " ");
            inOrder(tree.getRight());
        }
    }

    // preOrder 
    public void preOrder() {
        preOrder(root);
        out.println("\n");
    }

    private void preOrder(TreeNode t) {
        if (t != null) {
            out.print(t.getValue() + " ");
            preOrder(t.getLeft());
            preOrder(t.getRight());
        }
    }

    // postOrder   
    public void postOrder() {
        postOrder(root);
        out.println("\n");
    }

    private void postOrder(TreeNode t) {
        if (t != null) {
            postOrder(t.getLeft());
            postOrder(t.getRight());
            out.print(t.getValue() + " ");
        }
    }

    // revOrder
    public void revOrder() {
        revOrder(root);
        out.println("\n");
    }

    private void revOrder(TreeNode t) {
        if (t != null) {
            revOrder(t.getRight());
            out.print(t.getValue() + " ");
            revOrder(t.getLeft());
        }
    }

    // levelOrder - use a queue
    public void levelOrder() {
        Queue<TreeNode> level = new LinkedList<>();
        if (root == null) {
            return;
        }
        TreeNode tree = root;
        level.add(tree);
        while (!level.isEmpty()) {
            tree = level.poll();
            out.print(tree.getValue() + " ");
            if (tree.getLeft() != null) {
                level.add(tree.getLeft());
            }
            if (tree.getRight() != null) {
                level.add(tree.getRight());
            }
        }
        out.println("\n");
    }

    // zigzagOrder - hint below but could be solved in a different manner
    // loop thru a stack and load all nodes to a new stack(loading is based on direction)
    // set new stack to old and repeat
    public void zigzagOrder() {
        if (root == null) {
            return;
        }
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        currLevel.push(root);
        while (!currLevel.isEmpty() || !nextLevel.isEmpty()) {
            while (!currLevel.isEmpty()) {
                TreeNode temp = currLevel.pop();
                System.out.print(temp.getValue() + " ");
                if (temp.getLeft() != null) {
                    nextLevel.push(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    nextLevel.push(temp.getRight());
                }
            }
            while (!nextLevel.isEmpty()) {
                TreeNode tree = nextLevel.pop();
                System.out.print(tree.getValue() + " ");
                if (tree.getRight() != null) {
                    currLevel.push(tree.getRight());
                }
                if (tree.getLeft() != null) {
                    currLevel.push(tree.getLeft());
                }
            }
        }
        out.println("\n");
    }

    // getNumLevels
    public int getNumLevels() {
        return getNumLevels(root);
    }

    private int getNumLevels(TreeNode tree) {
        if (tree == null) {
            return 0;
        } else {
            int numLeft = getNumLevels(tree.getLeft());
            int numRight = getNumLevels(tree.getRight());
            if (numLeft > numRight) {
                return 1 + numLeft;
            } else {
                return 1 + numRight;
            }
        }
    }

    // getNumLeaves 
    public int getNumLeaves() {
        return getNumLeaves(root);
    }

    private int getNumLeaves(TreeNode tree) {
        if (tree == null) {
            return 0;
        } else if (tree.getLeft() == null && tree.getRight() == null) {
            return 1;
        }
        return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());
    }

    // getWidth - insure this works right for the 2nd test case
    public int getWidth() {
        return getWidth(root);
    }

    private int getWidth(TreeNode tree) {
        if (tree != null) {
            int lLevels = getNumLevels(tree.getLeft());
            int rLevels = getNumLevels(tree.getRight());
            int lWidth = getWidth(tree.getLeft());
            int rWidth = getWidth(tree.getRight());
            return Math.max(lLevels + rLevels + 1, Math.max(lWidth, rWidth));
        }
        return 0;
    }

    // getHeight 
    public int getHeight() {
        if (root != null) {
            int numLeft = getNumLevels(root.getLeft());
            int numRight = getNumLevels(root.getRight());
            return numLeft > numRight ? numLeft : numRight;
        }
        return 0;
    }

    // getNumNodes 
    public int getNumNodes() {
        return getNumNodes(root);
    }

    private int getNumNodes(TreeNode t) {
        if (t != null) {
            return 1 + getNumNodes(t.getLeft()) + getNumNodes(t.getRight());
        }
        return 0;
    }

    // isFull
    public boolean isFull() {
        return (int) Math.pow(2, getNumLevels()) - 1 == getNumNodes();
    }

    // contains
    public boolean contains(int val) {
        return contains(val, root);
    }

    private boolean contains(Comparable val, TreeNode tree) {
        if (tree != null) {
            Comparable treeValue = tree.getValue();
            int dirTest = val.compareTo(treeValue);
            if (dirTest == 0) {
                return true;
            } else if (dirTest < 0) {
                return contains(val, tree.getLeft());
            } else if (dirTest > 0) {
                return contains(val, tree.getRight());
            }
        }
        return false;
    }

    // maxNode
    // minNode
    // getSmallest
    public Comparable getSmallest() {
        return getSmallest(root);
    }

    private Comparable getSmallest(TreeNode tree) {
        if (tree.getLeft() == null) {
            return tree.getValue();
        }
        return getSmallest(tree.getLeft());
    }

    // getLargest
    public Comparable getLargest() {
        return getLargest(root);
    }

    private Comparable getLargest(TreeNode tree) {
        if (tree.getRight() == null) {
            return tree.getValue();
        }
        return getLargest(tree.getRight());
    }

    // remove - follow adds set up very closely and check powerpoint if needed
    // 1st case = no children
    // 2nd case = one child
    // 3rd case two children
    public void remove(int val) {
        if (getNumNodes() == 1) {
            root = null;
        } else if (contains(val)) {
            root = remove(val, root);
        }
    }

    private TreeNode remove(Comparable val, TreeNode tree) {
        Comparable treeValue = tree.getValue();
        int dirTest = val.compareTo(treeValue);
        if (dirTest < 0) {
            tree.setLeft(remove(val, tree.getLeft()));
        } else if (dirTest > 0) {
            tree.setRight(remove(val, tree.getRight()));
        } else {
            if (tree.getLeft() != null && tree.getRight() != null) {
                Comparable minRight = getSmallest(tree.getRight());
                tree.setValue(minRight);
                tree.setRight(remove(minRight, tree.getRight()));
            } else {
                if (tree.getLeft() == null && tree.getRight() == null) {
                    tree = null;
                } else {
                    TreeNode delete = tree;
                    tree = (tree.getLeft() != null) ? (tree.getLeft()) : (tree.getRight());
                    delete = null;
                }
            }
        }
        return tree;
    }

    public void clear() {
        root = null;
    }

    public String print() {
        return "";
    }

    // ****BONUS**** 
    // display like a tree
    public String toString() {
        return toString(root);
    }

    private String toString(TreeNode tree) {
        if (tree != null) {
            return toString(tree.getLeft()) + tree.getValue() + " " + toString(tree.getRight());
        }
        return "";
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(40);
        bst.add(20);
        bst.add(5);
        bst.add(60);
        bst.add(27);
        bst.add(212);
        bst.add(90);
        bst.add(250);
//        bst.add(50);
        System.out.println(bst.isFull());
        
    }
}
