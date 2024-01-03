package TreeDataStructur;

public class BST {
    private BSTNode root;

    BST(){

    }

    public int height(BSTNode node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(BSTNode root){
        displayHelper(root, "Root node: ");
    }

    public void displayHelper(BSTNode node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.getValue());
        displayHelper(node.left, "Left child of " + node.getValue() + " : ");
        displayHelper(node.right, "Right child of " + node.getValue() + " : ");

    }

}



class BSTNode{
    public final int value;
    public BSTNode left;
    public BSTNode right;
    public int height;

    BSTNode (int value){
        this.value = value;
    }

    public int getValue (){
        return value;
    }

}
