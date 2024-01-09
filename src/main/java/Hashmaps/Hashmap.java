package Hashmaps;

import java.util.*;
public class Hashmap {
    public static void main(String[] args) {
        MapUsingHash myMap = new MapUsingHash();

        myMap.put("Unyime", "88");
        myMap.put("Wisdom", "70");
        myMap.put("Freedom", "80");

        System.out.println(myMap.get("Wisdom"));

    }
}

class MapUsingHash{
    private Entity[] entities;

    public MapUsingHash(){
        entities = new Entity[100];
    }

    public void put(String key, String value){
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key, value);
    }

    public String get(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return null;
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            entities[hash] = null;
        }
    }

//    @Override
//    public String toString(){
//        return Arrays.toString(entities);
//    }


}

class Entity{
    String key;
    String value;

    public Entity(String key, String value){
        this.key = key;
        this.value = value;
    }
}
