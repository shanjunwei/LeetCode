package list;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer,Integer>  map;
    private int   capacity = 0;

    public LRUCache(int capacity) {
        capacity = capacity;
        int finalCapacity = capacity;
        map = new LinkedHashMap(){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                System.out.println(eldest);
                return size() > finalCapacity;
            }
        };
    }
    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)){
            // 从缓存中拿出再重放
            result = map.get(key);
            map.remove(key);
            put(key,result);
        }
        return result;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }
        map.put(key,value);
    }

    public static void main(String[] args) {
        //  ["LRUCache","put","put","put","put","get","get"]
        //  [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        System.out.println(lruCache.map);
        lruCache.put(1,1);
        System.out.println(lruCache.map);
        lruCache.put(2,3);
        System.out.println(lruCache.map);
        lruCache.put(4,1);
        System.out.println(lruCache.map);
    }
}
