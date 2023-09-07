/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19792
 */
public class Tree {

    Node root;

    public Tree(String s) {
        root = new Node(s);
    }

    public void add(Comparable c) {
        Node n = root;
        while (n != null) {
            int direction = c.compareTo(n.data);
            if (direction < 0) {
                if (n.left != null) {
                    n = n.left;
                } else {
                    n.left = new Node(c);
                    n = null;
                }
            } else if (direction > 0) {
                if (n.right != null) {
                    n = n.right;
                } else {
                    n.right = new Node(c);
                    n = null;
                }
            }
        }
    }

    public Node get() {
        Node n = root, p = n;
        while (n != null) {
            p = n;
            n = n.left;
        }
        return p;
    }

    public static class Node {

        Node left, right;
        Comparable data;

        public Node(Comparable data) {
            this.data = data;
        }

        public String toString() {
            return "" + data;
        }
    }

////////// client code ////////
    public static void main(String[] args) {
        Node a = new Node("Hulett");
        Node b = new Node("Cargill");
        Node c = new Node("Gosling");
        a.right = b;
        b.left = c;
        a.left = a.right.left;
        a.right.right = a;
        a.right.left.left = a;
        c.right = a.right.left;
        Node n1 = a, n2 = a;
        for (int i = 0; i < 10; i++) {
            n1 = i % 2 == 1 ? n1.left : n1.right;
            n2 = i % 2 == 0 ? n2.left : n2.right;
        }
        System.out.println(n1 + " " + n2);
    }
}
