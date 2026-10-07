package Trees.BalancedTrees;

import java.util.ArrayList;
import java.util.List;


public class BTree<T extends Comparable<T>>{
    private final int m; // Order of the tree
    private final int maxKeys;
    private final int minKeys;
    private Node root;


    private class Node {
        boolean isLeaf;
        List<T> keys;
        List<Node> children;

        Node(boolean isLeaf) {
            this.isLeaf = isLeaf;
            this.keys = new ArrayList<>();
            this.children = new ArrayList<>();
        }
    }


    public BTree(int m) {
        if (m < 3) {
            throw new IllegalArgumentException("Order m must be at least 3.");
        }
        this.m = m;
        this.maxKeys = m - 1;
        this.minKeys = (int) Math.ceil(m / 2.0) - 1; 
        this.root = new Node(true);
    }


    public boolean search(T key) {
        return search(root, key);
    }

    private boolean search(Node node, T key) {
        int i = 0;
        while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) {
            i++;
        }
        if (i < node.keys.size() && key == node.keys.get(i)) {
            return true;
        }
        if (node.isLeaf) {
            return false;
        }
        return search(node.children.get(i), key);
    }

    /**
     * Inserts a key into the B-Tree.
     */
    public void insert(T key) {
        Node r = root;
        // If root is full, the tree grows in height
        if (r.keys.size() == maxKeys) {
            Node s = new Node(false);
            root = s;
            s.children.add(r);
            splitChild(s, 0, r);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    // Helper method to insert a key into a node that is guaranteed not to be full
    private void insertNonFull(Node node, T key) {
        int i = node.keys.size() - 1;

        if (node.isLeaf) {
            // Find location to insert the key and move all greater keys one position ahead
            while (i >= 0 && key.compareTo(node.keys.get(i)) < 0) {
                i--;
            }
            node.keys.add(i + 1, key);
        } else {
            // Find the child that is going to have the new key
            while (i >= 0 && key.compareTo(node.keys.get(i)) < 0) {
                i--;
            }
            i++;
            Node child = node.children.get(i);
            // If the child is full, split it first
            if (child.keys.size() == maxKeys) {
                splitChild(node, i, child);
                if (key.compareTo(node.keys.get(i)) > 0) {
                    i++;
                }
            }
            insertNonFull(node.children.get(i), key);
        }
    }

    // Splits the full child node of the parent node at the given index
    private void splitChild(Node parent, int index, Node fullChild) {
        // Find the median index
        int medianIdx = fullChild.keys.size() / 2;
        T medianKey = fullChild.keys.get(medianIdx);

        // Create a new node to hold the upper half elements of the full child
        Node rightNode = new Node(fullChild.isLeaf);

        // Copy keys from medianIdx + 1 to the end
        rightNode.keys.addAll(fullChild.keys.subList(medianIdx + 1, fullChild.keys.size()));
        
        // If fullChild is not a leaf, copy its relevant children pointers
        if (!fullChild.isLeaf) {
            rightNode.children.addAll(fullChild.children.subList(medianIdx + 1, fullChild.children.size()));
            // Remove copied children from original child
            fullChild.children.subList(medianIdx + 1, fullChild.children.size()).clear();
        }

        // Remove pushed-up key and right keys from the full child
        fullChild.keys.subList(medianIdx, fullChild.keys.size()).clear();

        // Insert the median key into the parent
        parent.keys.add(index, medianKey);
        // Link the new right node to the parent
        parent.children.add(index + 1, rightNode);
    }


    public void remove(T key) {
        if (root == null || root.keys.isEmpty()) {
            return;
        }

        delete(root, key);

        // If root becomes empty, reduce the height
        if (root.keys.isEmpty() && !root.isLeaf) {
            root = root.children.get(0);
        }
    }

    private void delete(Node node, T Key){

        int index = findKey(node, Key);

        if(index < node.keys.size() && node.keys.get(index)==Key){

            if(node.isLeaf){
                node.keys.remove(index);
                return;
            }

            Node leftChild = node.children.get(index);
            Node rightChild = node.children.get(index+1);

            if(leftChild.keys.size()>minKeys){
                T predecessor = getPredecessor(leftChild);
                node.keys.set(index,predecessor);

                delete(leftChild, predecessor);
            }
            else if(rightChild.keys.size()>minKeys){
                T successor = getSuccessor(rightChild);
                node.keys.set(index,successor);
                
                delete(rightChild, successor);
            }
            else{
                 merge(node,index);
                 delete(leftChild, Key);
            }

            return;

        }


        if(node.isLeaf){
            return;
        }


        Node child = node.children.get(index);


        if(child.keys.size()==minKeys){

            if(index>0 && node.children.get(index-1).keys.size()>minKeys){
                borrowFromPrevious(node, index);
            }

            else if(index<node.children.size()-1 && node.children.get(index+1).keys.size()>minKeys){
                borrowFromNext(node, index);
            }
            else{

                if(index<node.children.size()-1){
                    merge(node,index);
                }
                else{
                    merge(node,index-1);
                    index--;
                }
            }
        }

        delete(node.children.get(index),Key);
    }

    private int findKey(Node node, T key) {

        int index = 0;

        while (index < node.keys.size() && node.keys.get(index).compareTo(key) < 0) {
            index++;
        }

        return index;
    }


    private T getPredecessor(Node node) {

        while (!node.isLeaf) {
            node = node.children.get(node.children.size() - 1);
        }

        return node.keys.get(node.keys.size() - 1);
    }


    private T getSuccessor(Node node) {

        while (!node.isLeaf) {
            node = node.children.get(0);
        }

        return node.keys.get(0);
    }


    private void borrowFromPrevious(Node parent, int index) {

        Node child = parent.children.get(index);
        Node sibling = parent.children.get(index - 1);

        // Move parent key down into child
        child.keys.add(0, parent.keys.get(index - 1));

        // Move sibling's last key up to parent
        parent.keys.set(index - 1,
                        sibling.keys.remove(sibling.keys.size() - 1));

        // If internal nodes, move last child pointer
        if (!sibling.isLeaf) {

            Node lastChild =
                    sibling.children.remove(sibling.children.size() - 1);

            child.children.add(0, lastChild);
        }
    }

    private void borrowFromNext(Node parent, int index) {

        Node child = parent.children.get(index);
        Node sibling = parent.children.get(index + 1);

        // Move parent key down into child
        child.keys.add(parent.keys.get(index));

        // Move sibling's first key up to parent
        parent.keys.set(index,
                        sibling.keys.remove(0));

        // If internal nodes, move first child pointer
        if (!sibling.isLeaf) {

            Node firstChild = sibling.children.remove(0);

            child.children.add(firstChild);
        }
    }


    private void merge(Node parent, int index) {

        Node leftChild = parent.children.get(index);
        Node rightChild = parent.children.get(index + 1);

        // Move parent's key into left child
        leftChild.keys.add(parent.keys.get(index));

        // Add all keys from right child
        leftChild.keys.addAll(rightChild.keys);

        // If internal nodes, copy children
        if (!leftChild.isLeaf) {
            leftChild.children.addAll(rightChild.children);
        }

        // Remove key from parent
        parent.keys.remove(index);

        // Remove right child from parent
        parent.children.remove(index + 1);
    }



    /**
     * Prints the tree structure using in-order traversal.
     */
    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node node, int level) {
        System.out.print("Level " + level + ": " + node.keys + "\n");
        if (!node.isLeaf) {
            for (Node child : node.children) {
                printTree(child, level + 1);
            }
        }
    }


}
