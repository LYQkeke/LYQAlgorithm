package com.keke.other;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by KEKE on 2019/3/21
 */
public class LRUCache <K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_ENTRIES = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>MAX_ENTRIES;
    }

    public LRUCache(){
        super(MAX_ENTRIES, 0.75f, true);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>();
        lruCache.put(1,"one");
        lruCache.put(2,"two");
        lruCache.put(3,"three");
        lruCache.get(1);
        lruCache.put(4,"four");
        System.out.println(lruCache.keySet());
    }
}
