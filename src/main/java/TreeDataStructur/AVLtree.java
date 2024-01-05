package TreeDataStructur;



public class AVLtree {
    public static void main(String[] args) {
        AVLtreeInner tree = new AVLtreeInner();
        for(int i = 0; i < 1000; i++){
            tree.insert(i);
        }

        System.out.println(tree.height());
    }
}
class AVLtreeInner {
    private AVLNode root;

    public int height(AVLNode node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    public int height(){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        displayHelper(root, "Root node: ");
    }

    public void displayHelper(AVLNode node, String details){
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

    public AVLNode insertHelper(int value, AVLNode node) {
        if (node == null) {
            node = new AVLNode(value);
            return node;
        }
        if (value < node.value) {
            node.left = insertHelper(value, node.left);
        }
        if (value > node.value) {
            node.right = insertHelper(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        // The original is returned when  something is already on the child.
        return rotate(node);
        // Recall that each node visited was stored in the call stack during each
        // recursive call and was return while the stack was being emptied.
        // This means that the rotate method will be called on each node while we
        // are climbing up ( emptying the stack ).
        // The code in the rotate method will only run when one of the condition has been
        // met. Otherwise, the node that is passed will be automatically returned.

    }

    public AVLNode rotate(AVLNode node){
        if(height(node.left) - height(node.right) > 1){
            //then it is left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
                // this means it is perfectly skewed to the left, and thus
                // we will rotate to the right.
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                // this means it is not perfectly skewed to the left, and
                // thus we need to make it skewed first before performing a
                // balancing operation
                node.left = leftRotate(node.left); // This returns the balanced subtree from node.left and fix it in node.left
                return rightRotate(node);
            }
        }

        if(height(node.right) - height(node.left) > 1){
            //then it is right heavy
            if(height(node.right.right) - height(node.right.left) > 0){
                // this means it is perfectly skewed to the right, and thus
                // we will rotate to the left.
                return leftRotate(node);
            }
            if(height(node.right.right) - height(node.right.left) < 0){
                // this means it is not perfectly skewed to the right, and
                // thus we need to make it skewed first before performing a
                // balancing operation
                node.right = rightRotate(node.right); // This returns the balanced subtree from node.left and fix it in node.left
                return leftRotate(node);
            }
        }
        return node;
    }

    public AVLNode rightRotate(AVLNode node){
        AVLNode p = node;
        AVLNode c = node.left;
        p.left = c.right;
        c.right = p;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    public AVLNode leftRotate(AVLNode node){
        AVLNode p = node;
        AVLNode c = node.right;
        p.right = c.left;
        c.left = p;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    public boolean isBalanced(){
        return isBalancedHelper(root);
    }

    public boolean isBalancedHelper(AVLNode node){
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

    public void preorderHelper(AVLNode node){
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

    public void postorderHelper(AVLNode node){
        if(node == null){
            return;
        }
        postorderHelper(node.left);
        postorderHelper(node.right);
        System.out.println(node.value + " ");
    }
}

class AVLNode{
    public final int value;
    public AVLNode left;
    public AVLNode right;
    public int height;

    AVLNode (int value){
        this.value = value;
    }

    public int getValue (){
        return value;
    }

}

