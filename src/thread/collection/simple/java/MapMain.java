package thread.collection.simple.java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapMain
{
    public static void main(String[] args)
    {
        Map<Integer, String> map1 = new ConcurrentHashMap<>(); // hash map 대안
        map1.put(3, "data3");
        map1.put(2, "data2");
        map1.put(1, "data1");
        System.out.println("map1 = " + map1);

        Map<Integer, String> map2 = new ConcurrentSkipListMap<>(); // tree map 대안
        map1.put(2, "data2");
        map1.put(3, "data3");
        map1.put(1, "data1");
        System.out.println("map2 = " + map2);
    }
}
