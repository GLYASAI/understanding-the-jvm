package org.abewang.chapter2;

import java.util.ArrayList;

/**
 * VM Args: -XX:PermSize=10M -XX MaxPermSize=10M
 *
 * @Author Abe
 * @Date 2018/5/14.
 */
public class RuntimeConstantPoolOOM {
    public static void runtimeConstantPoolOOM() {
        ArrayList<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    public static void main(String[] args) {
        runtimeConstantPoolOOM();
    }
}
