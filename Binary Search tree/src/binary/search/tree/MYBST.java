/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaproject;

import java.util.logging.Logger;

class Node {

    String data;
    int key;
    Node leftChild = null;
    Node rightChild = null;
    Node parent = null;

    public Node(String data, int key) {
        this.data = data;
        this.key = key;

    }

    public String toString() {
        return "key is " + key + " data " + data + "";
    }
}

public class MYBST {

    Node root = null;
    Node current = null;
    Node temp = null;

    public void addNewNode(int key, String data) {
        Node newNode = new Node(data, key);
        temp = root;
        Logger LOGGER = Logger.getAnonymousLogger();
        LOGGER.info("helllo");
        if (root == null) {
            root = newNode;
        } else {
            LOGGER.info("helllo4");
            while (temp != null) {
                LOGGER.info("helllo3");
                current = temp;
                if (key < temp.key) {
                    temp = temp.leftChild;

                } else if (key > temp.key) {
                    temp = temp.rightChild;

                }
            }
            if (key < current.key) {
                current.leftChild = newNode;
            } else if (key > current.key) {
                current.rightChild = newNode;

            }
        }
        LOGGER.info("helllo4");

    }

    public void inOrderTravers(Node node) {
        if (node != null) {
            inOrderTravers(node.leftChild);
            System.out.println(node);
            inOrderTravers(node.rightChild);
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.leftChild);
            postOrderTraversal(node.rightChild);
            System.out.println(node);
        }
    }

    public void preOrderTraversal(Node node) {
         if (node != null) {
            System.out.println(node);
            preOrderTraversal(node.leftChild);
            preOrderTraversal(node.rightChild);
            
        }
    }

    public void delete(int key){
        Node deleteNode = search(key);
        if(deleteNode!=null){
            
        }
       
    }
    
    public Node search(int key) {
        Node searchNode = root;
        Node temp = null;
        System.out.println("root" + root);
        while (searchNode != null) {
            temp = searchNode;
            if (searchNode.key == key) {

                System.out.println("saerch" + searchNode);
                break;
            } else if (searchNode.key > key) {
                searchNode = searchNode.leftChild;
            } else if (searchNode.key < key) {
                searchNode = searchNode.rightChild;
            }
        }
        if (temp.key == key) {
            System.out.println(searchNode);
            return searchNode;
        } else {
            System.out.println("No element is found");
            return null;
        }
    }

    public static void main(String[] args) {
        MYBST tree = new MYBST();
        tree.addNewNode(50, "hey");
        tree.addNewNode(25, "hoo");
        tree.addNewNode(15, "hi");
        tree.addNewNode(30, "u");
        tree.addNewNode(75, "bo");
        tree.addNewNode(85, "bo");
//        tree.addNewNode(1, "bo");
//        tree.addNewNode(78, "bo");
        tree.inOrderTravers(tree.root);
        tree.search(79);

        System.out.println("Post order");
        tree.postOrderTraversal(tree.root);
        System.out.println("Pre order");
        tree.preOrderTraversal(tree.root);
    }
}

