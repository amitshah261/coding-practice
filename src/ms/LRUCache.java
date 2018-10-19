package ms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
    Implement a LRU cache.
 */
public class LRUCache {
    private int size, maxSize;
    Map<Integer, Integer> nodes;
    List<Integer> cache;

    LRUCache(int size){
        this.maxSize = size;
        this.size = 0;
        this.nodes = new HashMap<>();
        this.cache = new LinkedList<>();
    }

    void add(int i){
        if(nodes.containsKey(i)){
            cache.remove(new Integer(i));

        } else {
            if(size < maxSize){
                size++;
            } else {
                int removedKey = cache.remove(0);
                nodes.remove(removedKey);
            }
        }
        cache.add(i);
        nodes.put(i, i);
    }

//    void remove(int node){
//        if(nodes.containsKey(node)){
//            cache.remove(new Integer(node));
//            nodes.remove(node);
//        }
//    }

    @Override
    public String toString(){
        return cache.toString();
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(1);
        lru.add(2);
        lru.add(5);
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(5);
        System.out.println(lru);
    }

}
