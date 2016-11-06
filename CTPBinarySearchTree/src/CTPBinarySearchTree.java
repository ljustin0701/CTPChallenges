import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ljust on 11/6/2016.
 */
public class CTPBinarySearchTree {

    static void createBST(ArrayList<Integer> al) {
        int[] counter = {0};
        BinaryTree bt = new BinaryTree();

        for(int key : al) {
            if (bt.getRoot() != null) {
                insert(bt.getRoot(), key, counter);
            } else {
                Node n = new Node(key);
                bt.setRoot(n);
            }
            System.out.println(counter[0]);
        }
    }

    static void insert(Node root, int key, int[] counter){
        counter[0]++;

        if(root.val > key){
            if(root.left == null){
                Node n = new Node(key);
                root.left = n;
            } else {
                insert(root.left, key, counter);
            }
        } else if(root.val < key){
            if(root.right == null){
                Node n = new Node(key);
                root.right = n;
            } else {
                insert(root.right, key, counter);
            }
        }
    }

    static public class Node {
        Node left;
        Node right;
        int val;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static public class BinaryTree {
        Node root;

        public BinaryTree() {
            this.root = null;
        }

        public BinaryTree(Node root){
            this.root = root;
        }

        public Node getRoot() { return root; }
        public void setRoot(Node node) { root = node; }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input003.txt"));
        ArrayList<Integer> al = new ArrayList<>();
        s.nextInt();
        while(s.hasNextInt()) {
            al.add(s.nextInt());
        }

        createBST(al);
    }
}
