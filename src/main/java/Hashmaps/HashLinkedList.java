package Hashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class HashLinkedList <K, V>{
    ArrayList<LinkedList<EntityLinkedList>> list;
    private int size;
    private float lf = 0.5f;

    public static void main(String[] args) {
        HashLinkedList<String, String> map = new HashLinkedList<>();

        map.put("Mango", "King of fruits");
        map.put("Apple", "A sweet red fruit");
        map.put("Litchi", "Kunal's fav fruit");

        System.out.println(map);
    }

    public HashLinkedList(){
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(new LinkedList<>());
        }
    }

    public void put(K key, V value){
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<EntityLinkedList> entities = list.get(hash);

        for (EntityLinkedList entity: entities){
            //If there is already a node with the specified key
            if(entity.key.equals(key)){
                entity.value = value;
            }
            return;
        }

        if((float)(size) / list.size() > lf){
            //double the list.
            reHash();
        }

        //Else create new node
        entities.add(new EntityLinkedList(key, value));
        size++;
    }

    private void reHash(){
        System.out.println("Rehashing");

        ArrayList<LinkedList<EntityLinkedList>>  old = list;
        list = new ArrayList<>();
        size = 0;

        /*
         * Notice here that we always create and insert the linked list
         * we intend to use into the array before adding the actual elements
         */
        for(int i=0; i < old.size() * 2; i++){
            list.add(new LinkedList<>());
        }

        for(LinkedList<EntityLinkedList> entries: old){
            for(EntityLinkedList entry: entries){
                put((K)entry.key, (V) entry.value);
            }
        }
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<EntityLinkedList> entries = list.get(hash);

        for(EntityLinkedList entry: entries){
            if(entry.key.equals(key)){
                return (V) entry.value;
            }
        }

        return null;
    }

    public void remove(K key){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<EntityLinkedList> entities = list.get(hash);

        EntityLinkedList target = null;
        for(EntityLinkedList entity: entities){
            if(entity.key.equals(key)){
                target = entity;
                break;
            }
        }

        entities.remove(target);
        size--;
    }

    public boolean containKey(K key){
        return get(key) != null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(LinkedList<EntityLinkedList> entities : list) {
            for(EntityLinkedList entity : entities) {
                builder.append(entity.key);
                builder.append(" = ");
                builder.append(entity.value);
                builder.append(" , ");
            }
        }
        builder.append("}");

        return builder.toString();
    }


}

class EntityLinkedList<K, V>{
    K key;
    V value;

    public EntityLinkedList(K key, V value){
        this.key = key;
        this.value = value;
    }
}
