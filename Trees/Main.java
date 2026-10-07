package Trees;


import Trees.UnbalancedTrees.*;
import Trees.BalancedTrees.*;

public class Main {
    public static void main(String[] args) {

       //------------------------------------testing Binary Search Tree------------------------------------//

        System.out.println("Binary Search Tree:");
        BST<String> bst = new BST<> ();
        bst.insert("Apple");
        bst.insert("Banana");
        bst.insert("Cherry");
        bst.insert("Mango");
        bst.insert("Orange");
        bst.insert("Peach");
        bst.insert("Plum");
        bst.insert("Grapes");

        System.out.println("Removing 'Apple'");
        bst.remove("Apple");
        System.out.println("Removing 'Banana'");
        bst.remove("Banana");
        System.out.println("Removing 'Cherry'");
        bst.remove("Cherry");

        bst.insert("pineapple");
        bst.insert("Kiwi");
        bst.insert("Strawberry");
        bst.insert("Blueberry");
        bst.insert("Raspberry");
        bst.insert("Blackberry");
        bst.insert("Watermelon");
        bst.insert("Cantaloupe");
        bst.insert("Honeydew");
        bst.insert("Papaya");

        bst.remove("Mango");
        bst.remove("Orange");
        bst.remove("Strawberry");
        bst.remove("Blueberry");

        bst.inorderTraversal();


        //------------------------------------testing Threaded Binary Search Tree------------------------------------//


        System.out.println("\nThreaded Binary Search Tree:");
        ThreadedBST<String> threadedBST = new ThreadedBST<>();
        threadedBST.insert("Apple");
        threadedBST.insert("Banana");
        threadedBST.insert("Cherry");
        threadedBST.insert("Mango");
        threadedBST.insert("Orange");
        threadedBST.insert("Peach");
        threadedBST.insert("Plum");
        bst.insert("Grapes");

        System.out.println("Removing 'Apple'");
        bst.remove("Apple");
        System.out.println("Removing 'Banana'");
        bst.remove("Banana");
        System.out.println("Removing 'Cherry'");
        bst.remove("Cherry");

        bst.insert("pineapple");
        bst.insert("Kiwi");
        bst.insert("Strawberry");
        bst.insert("Blueberry");
        bst.insert("Raspberry");
        bst.insert("Blackberry");
        bst.insert("Watermelon");
        bst.insert("Cantaloupe");
        bst.insert("Honeydew");
        bst.insert("Papaya");

        bst.remove("Mango");
        bst.remove("Orange");
        bst.remove("Strawberry");
        bst.remove("Blueberry");

        bst.inorderTraversal();


    //------------------------------------testing AVL Tree------------------------------------//


        System.out.println("\nAVL Tree:");
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(50);
        avlTree.insert(30);
        avlTree.insert(70);
        avlTree.insert(20);
        avlTree.insert(40);
        avlTree.insert(60);
        avlTree.insert(80);
        avlTree.insert(10);
        avlTree.insert(25);
        avlTree.insert(35);
        avlTree.insert(45);
        avlTree.insert(55);
        avlTree.insert(65);
        avlTree.insert(75);
        avlTree.insert(90);
        avlTree.insert(5);
        avlTree.insert(15);
        avlTree.insert(22);
        avlTree.insert(28);
        avlTree.insert(33);
        avlTree.insert(38);
        avlTree.insert(42);
        avlTree.insert(48);

        avlTree.BFS();

        System.out.println("Removing 10");
        avlTree.remove(10);
        System.out.println("Removing 20");
        avlTree.remove(20);
        System.out.println("Removing 30");
        avlTree.remove(30);

        avlTree.BFS();



        //------------------------------------testing AVL Tree------------------------------------//


        System.out.println("\nRed-Black Tree:");
        RBTree<Integer> rbTree = new RBTree<>();
        rbTree.insert(50);
        rbTree.insert(30);
        rbTree.insert(70);
        rbTree.insert(20);
        rbTree.insert(40);
        rbTree.insert(60);
        rbTree.insert(80);
        rbTree.insert(10);
        rbTree.insert(25);
        rbTree.insert(35);
        rbTree.insert(45);
        rbTree.insert(55);
        rbTree.insert(65);
        rbTree.insert(75);
        rbTree.insert(90);
        rbTree.insert(5);
        rbTree.insert(15);
        rbTree.insert(22);
        rbTree.insert(28);
        rbTree.insert(33);
        rbTree.insert(38);
        rbTree.insert(42);
        rbTree.insert(48);

        rbTree.BFS();

        rbTree.BFS();        



        //------------------------------------testing B-Tree------------------------------------//


        System.out.println("\nB - Tree:");
        BTree<Integer> bTree = new BTree<>(5);
        bTree.insert(50);
        bTree.insert(30);
        bTree.insert(70);
        bTree.insert(20);
        bTree.insert(40);
        bTree.insert(60);
        bTree.insert(80);
        bTree.insert(10);
        bTree.insert(25);
        bTree.insert(35);
        bTree.insert(45);
        bTree.insert(55);
        bTree.insert(65);
        bTree.insert(75);
        bTree.insert(90);
        bTree.insert(5);
        bTree.insert(15);
        bTree.insert(22);
        bTree.insert(28);
        bTree.insert(33);
        bTree.insert(38);
        bTree.insert(42);
        bTree.insert(48);

        bTree.printTree();

        bTree.remove(70);
        System.out.println();
        bTree.printTree();     

        bTree.remove(50);
        System.out.println();
        bTree.printTree(); 

        bTree.remove(48);
        System.out.println();
        bTree.printTree(); 

    }


    



}


//                                                                    50->B
//                                 30->B                                                                      70->B
//             20->R                                 40->R                               60->B                                   80->B
//     10->B              25->B             35->B             45->B            55->R                65->R              75->R                90->R
// 5->R      15->R    22->R    28->R     33->R    38->R    42->R   48->R     