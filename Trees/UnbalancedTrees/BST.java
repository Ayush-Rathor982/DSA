package Trees.UnbalancedTrees;

public class BST<T extends Comparable<T>>{
    private Node root;

    public BST(){
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
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
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
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    private Node findMin(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
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

}