package Trees.BalancedTrees;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>>{
    private Node root;

    public AVLTree(){
        root = null;
    }

    private class Node{
        T data;
        int height;
        Node left, right;

        Node(T data){
            this.data = data;
            this.height = 1;
            left = right = null;
        }
    }


    public void insert(T data){
        root = insertData(root, data);
    }

    private Node insertData(Node root, T data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data.compareTo(root.data) < 0){
            root.left = insertData(root.left, data);
        } else if(data.compareTo(root.data) > 0){
            root.right = insertData(root.right, data);
        }

        int balanceFactor = getBalanceFactor(root);
        if(balanceFactor > 1 && data.compareTo(root.left.data) < 0){
            return rightRotate(root);
        }
        if(balanceFactor > 1 && data.compareTo(root.left.data) > 0){
            return leftRightRotate(root);
        }
        if(balanceFactor < -1 && data.compareTo(root.right.data) > 0){
            return leftRotate(root);
        }
        if(balanceFactor < -1 && data.compareTo(root.right.data) < 0){
            return rightLeftRotate(root);
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    public void remove(T data){
        root = removeData(root, data);
    }

    private Node removeData(Node root, T data){
        if(root == null){
            return root;
        }
        if(data.compareTo(root.data) < 0){
            root.left = removeData(root.left, data);
        } else if(data.compareTo(root.data) > 0){
            root.right = removeData(root.right, data);
        } else {
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            Node temp = findMin(root.right);
            root.data = temp.data;
            root.right = removeData(root.right, temp.data);
        }

        int balanceFactor = getBalanceFactor(root);
        if(balanceFactor > 1 && data.compareTo(root.left.data) < 0){
            return rightRotate(root);
        }
        if(balanceFactor > 1 && data.compareTo(root.left.data) > 0){
            return leftRightRotate(root);
        }
        if(balanceFactor < -1 && data.compareTo(root.right.data) > 0){
            return leftRotate(root);
        }
        if(balanceFactor < -1 && data.compareTo(root.right.data) < 0){
            return rightLeftRotate(root);
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }


    private Node rightRotate(Node root){
        Node x = root.left;
        Node y = x.right;

        x.right = root;
        root.left = y;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }
    
    private Node leftRotate(Node root){
        Node x = root.right;
        Node y = x.left;

        x.left = root;
        root.right = y;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    private Node leftRightRotate(Node root){
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    private Node rightLeftRotate(Node root){
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    private int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node findMin(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    public boolean contains(T data){
        return containsData(root, data);
    }

    private boolean containsData(Node root, T data){
        if(root == null){
            return false;
        }
        if(data.compareTo(root.data) < 0){
            return containsData(root.left, data);
        } else if(data.compareTo(root.data) > 0){
            return containsData(root.right, data);
        } else {
            return true;
        }
    }

    public void inorderTraversal(){
        inorder(root);
    }

    private void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
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

                System.out.print(current.data + " ");

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