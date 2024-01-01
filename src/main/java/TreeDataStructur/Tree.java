package TreeDataStructur;

import java.util.Scanner;

public class Tree {
    private Node root;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree BT = new Tree();
        BT.buildTree(scanner);
        BT.display();
    }


    public void buildTree(Scanner scanner){
        System.out.println("Enter the root node value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node node){
        System.out.println("Do want to enter the left of: " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("Do want to enter the right of: " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }

    }

    public void display(){
        doDisplay(root, "");
    }

    public void doDisplay(Node node, String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        doDisplay(node.left, indent + "\t");
        doDisplay(node.right, indent + "\t");
    }
}



class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;

    }
}
