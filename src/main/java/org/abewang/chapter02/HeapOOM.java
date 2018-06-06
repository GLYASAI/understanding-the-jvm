package org.abewang.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @Author Abe
 * @Date 2018/4/20.
 */
public class HeapOOM {
    private static class OOMObject{}

    public static void heapOOM() {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) {
        heapOOM();
    }
}
