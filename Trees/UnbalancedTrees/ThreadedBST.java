package Trees.UnbalancedTrees;

public class ThreadedBST<T extends Comparable<T>>{
    private Node root;
    private Node flag; // Sentinel node to indicate the end of the tree

    public ThreadedBST(){
        root = null;
        flag = new Node(null); // Initialize the sentinel node
        flag.left = null;
        flag.right = null;
        flag.leftThreaded = true;
        flag.rightThreaded = true;
    }

    private class Node{
        T data;
        Node left, right;
        boolean leftThreaded, rightThreaded;

        Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.leftThreaded = false;
            this.rightThreaded = false;
        }
    }

    public void insert(T data){
        root = insertData(root, data);
    }

    private Node insertData(Node root, T data){
        if(root == null){
            Node newNode = new Node(data);
            newNode.left = flag;
            newNode.right = flag;
            newNode.leftThreaded = true;
            newNode.rightThreaded = true;
            return newNode;
        }
        if(data.compareTo(root.data) < 0){
            if(root.leftThreaded){
                Node newNode = new Node(data);
                newNode.left = root.left;
                newNode.right = root;
                newNode.leftThreaded = true;
                newNode.rightThreaded = true;
                root.left = newNode;
                root.leftThreaded = false;
            } else {
                root.left = insertData(root.left, data);
            }
        } else if(data.compareTo(root.data) > 0){
            if(root.rightThreaded){
                Node newNode = new Node(data);
                newNode.right = root.right;
                newNode.left = root;
                newNode.leftThreaded = true;
                newNode.rightThreaded = true;
                root.right = newNode;
                root.rightThreaded = false;
            } else {
                root.right = insertData(root.right, data);
            }
        }
        return root;
    }


    public void remove(T data){
        removeData(root, null, data);
    }

    private void removeData(Node root, Node parent, T data){
        if(root == null){
            return;
        }
        if(data.compareTo(root.data) < 0){
            if(!root.leftThreaded){
                removeData(root.left, root, data);
            }
        } else if(data.compareTo(root.data) > 0){
            if(!root.rightThreaded){
                removeData(root.right, root, data);
            }
        } else {
            // Node to be deleted found
            if(root.leftThreaded && root.rightThreaded){
                if(parent == null){
                    root = null;
                    return; // Tree becomes empty
                }
                if(parent.left == root){
                    parent.left = root.left;
                    parent.leftThreaded = true;
                } else {
                    parent.right = root.right;
                    parent.rightThreaded = true;
                }

            } else if(root.leftThreaded){
                // Node with only right child
                Node temp = root.right;
                while(!temp.leftThreaded){
                    temp = temp.left;
                }
                temp.left = root.left;
                root = root.right;
            } else if(root.rightThreaded){
                // Node with only left child
                Node temp = root.left;
                while(!temp.rightThreaded){
                    temp = temp.right;
                }
                temp.right = root.right;
                root = root.left;
            } else {
                // Node with two children
                Node successor = findMin(root.right);
                root.data = successor.data;
                removeData(root.right, root, successor.data);
            }
        }
  
    }

    private Node findMin(Node root){
        while(!root.leftThreaded){
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
            if(root.leftThreaded){
                return false;
            }
            return containsData(root.left, data);
        } else if(data.compareTo(root.data) > 0){
            if(root.rightThreaded){
                return false;
            }
            return containsData(root.right, data);
        } else {
            return true;
        }
    }

    public void inorderTraversal(){
        Node current = root;
        if(current == null){
            return;
        }
        // Go to the leftmost node
        while(!current.leftThreaded){
            current = current.left;
        }
        while(current != flag){
            System.out.print(current.data + " ");
            if(current.rightThreaded){
                current = current.right;
            } else {
                current = current.right;
                while(!current.leftThreaded){
                    current = current.left;
                }
            }
        }
    }

}