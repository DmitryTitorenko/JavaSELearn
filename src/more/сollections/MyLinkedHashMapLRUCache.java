package more.сollections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyLinkedHashMapLRUCache {
    public static void main(String[] args) {

        Map<Integer, String> integerStringMap2 = new HashMap<Integer, String>(3, 1);
        integerStringMap2.put(3, "a");
        integerStringMap2.put(2, "b");
        integerStringMap2.put(1, "c");
        System.out.println("HashMap:\n" + integerStringMap2);

        Map<Integer, String> integerStringMap = new LinkedHashMap<>(3, 1, true);
        integerStringMap.put(3, "a");
        integerStringMap.put(2, "b");
        integerStringMap.put(1, "c");
        System.out.println("\nLinkedHashMap:\n" + integerStringMap);
        integerStringMap.get(3);
        System.out.println("\n // get 3  with accessOrder = true\n" + integerStringMap);


        Map<Integer, String> integerStringLRUCache = new LRUCache<>(2);
        integerStringLRUCache.put(1, "1");
        integerStringLRUCache.put(2, "2");
        System.out.println("\n LRUCache:\n" + integerStringLRUCache);
        integerStringLRUCache.put(3, "3");

        System.out.println(integerStringLRUCache);

        integerStringLRUCache.get(2);
        System.out.println(integerStringLRUCache);
        integerStringLRUCache.put(9, "9");
        System.out.println(integerStringLRUCache);
    }
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {//Least Recently Used (LRU)
    private final int capacity;

    public LRUCache(int initialCapacity) {
        super(initialCapacity + 1, 1.1f, true);
        this.capacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {//call after put element
        return this.size() > capacity;
    }
}
