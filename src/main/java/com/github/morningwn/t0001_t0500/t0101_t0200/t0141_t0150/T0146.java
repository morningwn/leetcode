package com.github.morningwn.t0001_t0500.t0101_t0200.t0141_t0150;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author morningwn
 * @description: LRU缓存机制
 * @date Created in 2020/5/25 9:38
 * @version: 1.0
 */
public class T0146 {

    @Test
    public void test() {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Out.println(cache.get(1));
        // 返回  1
        cache.put(3, 3);                            // 该操作会使得密钥 2 作废
        Out.println(cache.get(2));
        // 返回 -1 (未找到)
        cache.put(4, 4);                            // 该操作会使得密钥 1 作废
        Out.println(cache.get(1));
        // 返回 -1 (未找到)
        Out.println(cache.get(3));
        // 返回  3
        Out.println(cache.get(4));
        // 返回  4

    }

    class LRUCache {
        HashMap<Integer, Integer> map;
        List<Integer> id;
        int size = 0;
        int maxSize;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            id = new LinkedList<Integer>();
            maxSize = capacity;
        }

        public int get(int key) {

            if (id.contains(key)) {
                id.remove((Integer) key);
                id.add(key);
                Out.print(size + "\t " + map + "\t " + id + "\t ");
                return map.get(key);
            } else {
                return -1;
            }

        }

        public void put(int key, int value) {
            if (id.contains(key)) {
                id.remove((Integer) key);
                id.add(key);
                map.put(key, value);
            } else {
                if (size < maxSize) {
                    id.add(key);
                    map.put(key, value);
                    size++;
                } else {
                    id.remove(0);
                    map.put(key, value);
                    id.add(key);
                }
            }

            Out.println(size + "\t " + map + "\t " + id + "\t ");
        }
    }
}

