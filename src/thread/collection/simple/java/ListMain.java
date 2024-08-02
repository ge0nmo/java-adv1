package thread.collection.simple.java;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListMain
{
    public static void main(String[] args)
    {
        List<Integer> copyList = new CopyOnWriteArrayList<>();
        copyList.add(1);
        copyList.add(2);
        copyList.add(3);
        System.out.println("copyList = " + copyList);
    }
}
