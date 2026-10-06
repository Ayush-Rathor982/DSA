package Trees.BalancedTrees;

import java.util.LinkedList;
import java.util.Queue;

public class RBTree<T extends Comparable<T>>{
    private Node root;
    public RBTree(){
        root = null;
    }

    private class Node{
        T data;
        String color; // "RED" for red, "BLACK" for black
        Node left, right, parent;

        Node(T data){
            this.data = data;
            this.color = "RED"; // new nodes are red by default
            left = right = parent = null;
        }
    }   

    public void insert(T data){
        Node newNode = new Node(data);
        root = insertData(root, newNode);
        fixViolation(newNode);
    }

    private Node insertData(Node root, Node newNode){
        if(root == null){
            return newNode;
        }
        if(newNode.data.compareTo(root.data) < 0){
            root.left = insertData(root.left, newNode);
            root.left.parent = root;
        } else if(newNode.data.compareTo(root.data) > 0){
            root.right = insertData(root.right, newNode);
            root.right.parent = root;
        }
        return root;
    }

    private void fixViolation(Node node){
        Node parent = null;
        Node grandparent = null;

        if( node.parent == null){
            node.color = "BLACK";
            return;
        }

        if(node.parent.color.equals("BLACK")){
            return;
        }

        while(node != root && node.color.equals("RED") && node.parent.color.equals("RED")){
            parent = node.parent;
            grandparent = parent.parent;

            if(parent == grandparent.left){
                Node uncle = grandparent.right;

                if(uncle != null && uncle.color.equals("RED")){
                    grandparent.color = "RED";
                    parent.color = "BLACK";
                    uncle.color = "BLACK";
                    node = grandparent;
                } 
                else {
                    if(node == parent.right){
                        leftRotate(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rightRotate(grandparent);
                    String tempColor = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = tempColor;
                    node = parent;
                }
            } 
            else {
                Node uncle = grandparent.left;

                if(uncle != null && uncle.color.equals("RED")){
                    grandparent.color = "RED";
                    parent.color = "BLACK";
                    uncle.color = "BLACK";
                    node = grandparent;
                } 
                else {
                    if(node == parent.left){
                        rightRotate(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    leftRotate(grandparent);
                    String tempColor = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = tempColor;
                    node = parent;
                }
            }
        }
        root.color = "BLACK";
    }


    private void leftRotate(Node node){ 

        Node x = node.right;
        node.right = x.left;

        if(node.right != null){
            node.right.parent = node;
        }

        x.parent = node.parent;

        if(node.parent == null){
            root = x;
        } 
        else if(node == node.parent.left){
            node.parent.left = x;
        } 
        else {
            node.parent.right = x;
        }

        x.left = node;
        node.parent = x;

    }

    private void rightRotate(Node node){
        Node x = node.left;
        node.left = x.right;

        if(node.left != null){
            node.left.parent = node;
        }

        x.parent = node.parent;

        if(node.parent == null){
            root = x;
        } 
        else if(node == node.parent.left){
            node.parent.left = x;
        } 
        else {
            node.parent.right = x;
        }

        x.right = node;
        node.parent = x;
    }



    public void BFS() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                Node current = queue.poll();

                System.out.print(current.data + "->"+current.color+" ");

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            System.out.println(); 
        }
    }

}