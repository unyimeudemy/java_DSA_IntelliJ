package RWayTries;

import java.util.LinkedList;
import java.util.Queue;

public class Tries {
//    public static void main(String[] args) {
//        TriesST<Integer> trie = new TriesST<Integer>();
//
//        // Insert data
//        trie.put("apple", 1);
//        trie.put("app", 2);
//        trie.put("banana", 3);
//        trie.put("bat", 4);
//
//        // Test contains
//        System.out.println("Contains 'apple': " + trie.contains("apple")); // Should be true
//        System.out.println("Contains 'apricot': " + trie.contains("apricot")); // Should be false
//
//        // Test get
//        System.out.println("Get 'apple': " + trie.get("apple")); // Should be 1
//        System.out.println("Get 'app': " + trie.get("app")); // Should be 2
//        System.out.println("Get 'banana': " + trie.get("banana")); // Should be 3
//        System.out.println("Get 'batman': " + trie.get("batman")); // Should be null
//
//        // Test delete
//        trie.delete("app");
//        System.out.println("After deleting 'app', contains 'app': " + trie.contains("app")); // Should be false
//        System.out.println("After deleting 'app', get 'apple': " + trie.get("apple")); // Should be 1
//
//        // Additional tests
//        trie.put("batman", 5);
//        System.out.println("Contains 'batman': " + trie.contains("batman")); // Should be true
//        System.out.println("Get 'batman': " + trie.get("batman")); // Should be 5
//    }

    public static void main(String[] args) {
        TriesST.cc();
    }
}

class Node {
    public Object value;
    public Node[] next;
    public Node (int R){
        this.next = new Node[R];
        this.value = null;
    }
}

class TriesST<Value>{
    private static final int R = 256;
    private Node root = new Node(R);

    public void put (String key, Value val){
        root = put(root, key, val, 0);
    }

    private Node put (Node x, String key, Value val, int d){
        if(x == null){
            x = new Node(R);
        }

        if(d == key.length()){
            x.value = val;
            return x;
        }

        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
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
        if(d == key.length()){return x;}
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void delete(String key){
        if(contains(key)){
            delete(root, key, 0);
        }
    }

    private void delete(Node x, String key, int d){
        if(x == null){
            return;
        }
        if(d == key.length()){
            x.value = null;
            return;
        }
        char c = key.charAt(d);
        delete(x.next[c], key, d + 1);
        if(x.value == null && x.next[c] == null){
            x.next[c] = null;
        }
    }

    public Iterable<String> keys (){
        Queue<String> queue = new LinkedList<>();
        collect(root, "", queue);
        return queue;
    }

    private void collect(Node x, String prefix, Queue<String> q){
        if(x == null){return;}
        if(x.value != null){q.add(prefix);}
        for (int c = 0; c < R; c++) {
            collect(x.next[c], prefix + c, q);
        }
    }

    public Iterable<String> KeysWithPrefix(String prefix){
        Queue<String> queue = new LinkedList<>();
        Node x = get(root, prefix, 0);
        collect(x, prefix, queue);
        return queue;
    }


    static void cc(){
        String ss = "a";
        cc(ss);
        System.out.println(ss);
    }
    static void cc(String prefix) {
        if (prefix.length() == 10) return;
        String c = "k";
        cc(prefix + c);  // Recursive call
        System.out.println(prefix);
    }
}
