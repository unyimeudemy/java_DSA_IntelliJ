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
        //create tree using the array
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

        SegmentNode node = new SegmentNode(start, end);
        int mid = (start + end) / 2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public int query(int qsi, int qei){
        //qsi = query start index
        //qei = query end index
        return query( this.root, qsi, qei);
    }

    private int query(SegmentNode node, int qsi, int qei){
        if(node.startInterval >= qsi && node.endInterval <= qei){
            // this means that query is completely in the node
            return node.data;
        }else if(node.startInterval > qei || node.endInterval < qsi){
            // This means that query is completely outside the range.
            return 0;
        }else{
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value){
        this.root.data = update(root, index, value);
    }

    private int update(SegmentNode node, int index, int value){
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }else{
                int leftAns = update(node.left, index, value);
                int rightAnc = update(node.right, index, value);

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
    }
}
