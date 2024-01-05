package TreeDataStructur;


public class BST {
    public static void main(String[] args) {
        BSTinner tree = new BSTinner();
        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        tree.populate(nums);
        tree.display();
    }
}
 class BSTinner {
    private BSTNode root;

    public int height(BSTNode node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
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

    public void insert(int value){
        root = insertHelper(value, root);
    }

    public BSTNode insertHelper(int value, BSTNode node) {
        if (node == null) {
            node = new BSTNode(value);
            return node;
        }
        if (value < node.value) {
            node.left = insertHelper(value, node.left);
        }
        if (value > node.value) {
            node.right = insertHelper(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node; // the original is returned when  something is already on the child
    }

    public boolean isBalanced(){
        return isBalancedHelper(root);
    }

    public boolean isBalancedHelper(BSTNode node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalancedHelper(node.left) && isBalancedHelper(node.right);
    }

    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums){
        populateSortedHelper(nums, 0, nums.length);
    }

    public void populateSortedHelper(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populateSortedHelper(nums, start, mid);
        populateSortedHelper(nums, mid + 1, end);
    }

    public void preorder(){
        preorderHelper(root);
    }

    public void preorderHelper(BSTNode node){
        if(node == null){
            return;
        }
        System.out.println(node.value + " ");
        preorderHelper(node.left);
        preorderHelper(node.right);
    }

     public void inorder(){
         preorderHelper(root);
     }

     public void inorderHelper(BSTNode node){
         if(node == null){
             return;
         }
         inorderHelper(node.left);
         System.out.println(node.value + " ");
         inorderHelper(node.right);
     }

     public void postorder(){
         postorderHelper(root);
     }

     public void postorderHelper(BSTNode node){
         if(node == null){
             return;
         }
         postorderHelper(node.left);
         postorderHelper(node.right);
         System.out.println(node.value + " ");
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
