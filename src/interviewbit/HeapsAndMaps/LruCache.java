package interviewbit.HeapsAndMaps;

import java.util.HashMap;

/**
 * Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRU Cache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
 *
 * Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.
 *
 *  NOTE: If you are using any global variables, make sure to clear them in the constructor.
 * Example :
 *
 * Input :
 *          capacity = 2
 *          set(1, 10)
 *          set(5, 12)
 *          get(5)        returns 12
 *          get(1)        returns 10
 *          get(10)       returns -1
 *          set(6, 14)    this pushes out key = 5 as LRU is full.
 *          get(5)        returns -1
 */
public class LruCache {
    static class Entity {
        int key;
        int value;
        Entity next;
        Entity prev;

        Entity() {

        }

        Entity(int k, int v) {
            key = k;
            value = v;
        }

        void removeSelf() {
            Entity tmp = next;
            prev.next = next;
            tmp.prev = prev;
        }

        void addAfter(Entity p) {
            next = p.next;
            prev = p;
            p.next = this;
            if (next != null) {
                next.prev = this;
            }

        }
    }

    int max;
    Entity first;
    Entity last;
    HashMap<Integer, Entity> map = new HashMap<>();

    public LruCache(int capacity) {
        max = capacity;
        first = new Entity();
        last = new Entity();
        last.addAfter(first);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Entity e = map.get(key);
        e.removeSelf();
        e.addAfter(first);
        return e.value;
    }

    public void set(int key, int value) {
        Entity e = new Entity(key, value);
        if (map.containsKey(key)) {
            Entity old = map.get(key);
            old.removeSelf();
        }
        e.addAfter(first);
        map.put(key, e);
        if (map.keySet().size() > max) {
            Entity t = last.prev;
            t.removeSelf();
            map.remove(t.key);
        }
    }

    public static void main(String[] st) {
        LruCache q = new LruCache(1);
        q.set(2, 1);
        q.set(2, 2);
        System.out.println(q.get(2));
        q.set(1, 3);
        System.out.println(q.get(2));
    }
}
