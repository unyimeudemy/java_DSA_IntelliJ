package TreeDataStructur;

public class SegmentTrees {
    public static void main(String[] args) {
        int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
        Segment tree = new Segment(arr);
//        tree.display();
        System.out.println(tree.query(1, 6));
    }

}

class Segment{
    SegmentNode root;
    public Segment(int[] arr){
        //Here we receive the array and make a call to the recursive function
        // that does the actual building of tree,
        //NOTE: here that the first element in the array is set as the root element
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private SegmentNode constructTree(int[] arr, int start, int end){
        if(start == end){
            // At this point we are at the leaf node and so the range at this point
            // will be something like [2, 2] which will specify the index the given array
            // at which the data is located.
            SegmentNode leaf = new SegmentNode(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        //create another node with the values of start and end, find the middle,
        // go into the left and child section of the array by calling constructTree
        //method of both halves.
        SegmentNode node = new SegmentNode(start, end);
        int mid = (start + end) / 2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);

        //when both the left and right leaf children have been created and their
        //values set, you pick up the values and sum up it up while emptying the
        //stack.
        node.data = node.left.data + node.right.data;

        // Then you return the node so that it will serve as either the left or right
        // child of the node above ( parent ) where it was called.
        return node;
    }

    public int query(int qsi, int qei){
        // Here we call a recursive function that runs on from the root
        // of the tree to till it finds the nodes


        //qsi = query start index
        //qei = query end index
        return query( this.root, qsi, qei);
    }

    private int query(SegmentNode node, int qsi, int qei){
        if(node.startInterval >= qsi && node.endInterval <= qei){
            // this means that sum in the range we need is totally inside the node
            // we are currently examining. So just return the node.
            //NOTE: This is the point where the recursive call has reached the leaf node.
            return node.data;
        }else if(node.startInterval > qei || node.endInterval < qsi){
            // This means that range query is completely outside the range that is
            // in the current node we are examining.
            return 0;
        }else{
            // If none the conditions above is met, make call to the left and right children
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value){
        //NOTE that any update actually happens in the leaf node and the
        // values of all nodes above the updated leaf node are updated.
        // This way the last updated value is set to the value of root that is
        // why we set the return value of the recursive method to the root data.
        this.root.data = update(root, index, value);
    }

    private int update(SegmentNode node, int index, int value){
        if(index >= node.startInterval && index <= node.endInterval){
            //If the provided index is within the range that the current node holds
            // perform the following operations.
            if(index == node.startInterval && index == node.endInterval){
                //If we have reached the leaf node where both the values of start
                // and end are the same, update the value of the node and return it
                node.data = value;
                return node.data;
            }else{
                //Otherwise, go into the right and left child
                int leftAns = update(node.left, index, value);
                int rightAnc = update(node.right, index, value);

                //While coming out from the recursive call into the right and
                // left child, sum the children and return.
                //This will continue till we reach the root node where the value returned will
                // be set as data for root.
                node.data = leftAns + rightAnc;
                return  node.data;
            }
        }
        return  node.data;
    }

    public void display() {
        display(this.root);
    }
    private void display(SegmentNode node) {
        String str = "";

        if(node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        if(node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }

        System.out.println(str + '\n');

        // call recursion
        if(node.left != null) {
            display(node.left);
        }

        if(node.right != null) {
            display(node.right);
        }
    }
}

class SegmentNode{
    public int data;
    public int startInterval;
    public int endInterval;
    public SegmentNode left;
    public SegmentNode right;

    public SegmentNode(int startInterval, int endInterval){
        this.startInterval = startInterval;
        this.endInterval = endInterval;

        String j = "sdjof";
        j.toString();


        int[] arr = {2, 3, 3};
        arr.toString();
    }


}
