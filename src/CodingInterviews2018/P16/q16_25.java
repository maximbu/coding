package CodingInterviews2018.P16;

import java.util.LinkedHashMap;
import java.util.Map;

public class q16_25 {

    private static class Cache{
        LinkedHashMap<Integer,String> cache;

        public Cache(int cacheSize) {
            cache = new LinkedHashMap<>(cacheSize,5,true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer,String> eldest) {
                    return size() > cacheSize;
                }
            };

        }

        public void setKeyValue(int key, String val) {
            cache.put(key,val);
        }

        public String getValue(int key) {
            return cache.get(key);
        }

        @Override
        public String toString() {
            return cache.toString();
        }
    }


    public static void main(String[] args) {
        int cacheSize = 5;
        Cache cache = new Cache(cacheSize);
        cache.setKeyValue(1, "1");
        System.out.println(cache);
        cache.setKeyValue(2, "2");
        System.out.println(cache);
        cache.setKeyValue(3, "3");
        System.out.println(cache);
        cache.getValue(1);
        System.out.println(cache);
        cache.setKeyValue(4, "4");
        System.out.println(cache);
        cache.getValue(2);
        System.out.println(cache);
        cache.setKeyValue(5, "5");
        System.out.println(cache);
        cache.getValue(5);
        System.out.println(cache);
        cache.setKeyValue(6,  "6");
        System.out.println(cache);
        cache.getValue(1);
        System.out.println(cache);
        cache.setKeyValue(5, "5a");
        System.out.println(cache);
        cache.getValue(3);
        System.out.println(cache);
    }
}
