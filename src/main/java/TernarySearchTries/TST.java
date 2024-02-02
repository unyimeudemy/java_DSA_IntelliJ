package TernarySearchTries;


public class TST {
    public static void main(String[] args) {
        TSTries<Integer> trie = new TSTries<Integer>();

        // Insert data
        trie.put("apple", 1);
        trie.put("app", 2);
        trie.put("banana", 3);
        trie.put("bat", 4);

        // Test contains
        System.out.println("Contains 'apple': " + trie.contains("apple")); // Should be true
        System.out.println("Contains 'apricot': " + trie.contains("apricot")); // Should be false

        // Test get
        System.out.println("Get 'apple': " + trie.get("apple")); // Should be 1
        System.out.println("Get 'app': " + trie.get("app")); // Should be 2
        System.out.println("Get 'banana': " + trie.get("banana")); // Should be 3
        System.out.println("Get 'batman': " + trie.get("batman")); // Should be null

        // Test delete
//        trie.delete("app");
        System.out.println("After deleting 'app', contains 'app': " + trie.contains("app")); // Should be false
        System.out.println("After deleting 'app', get 'apple': " + trie.get("apple")); // Should be 1

        // Additional tests
        trie.put("batman", 5);
        System.out.println("Contains 'batman': " + trie.contains("batman")); // Should be true
        System.out.println("Get 'batman': " + trie.get("batman")); // Should be 5
    }



}
class Node{
    public Object value;
    public char c;
    public Node left, mid, right;

}

class TSTries<Value>{
    private Node root;

    public void put(String key, Value val){
        root = put(root, key, val, 0);
    }

    private Node put (Node x, String key, Value val, int d){
        char c = key.charAt(d);
        if(x == null){
            x = new Node();
            x.c = c;
        }
        if(c < x.c){
            x.left = put(x.left, key, val, d);
        }else if (c > x.c){
            x.right = put(x.right, key, val, d);
        } else if (d < key.length() - 1) {
            x.mid = put(x.mid, key, val, d + 1);
        }else{
            x.value = val;
        }
        return x;
    }

    public boolean contains(String key){
        return get(key) != null;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {return null;}
        return (Value) x.value;
    }

    public Node get(Node x, String key, int d){
        if(x == null){return null;}
        char c = key.charAt(d);

        if(c < x.c){
            return get(x.left, key, d);
        }else if (c > x.c){
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        }else{
            return x;
        }
    }
}
