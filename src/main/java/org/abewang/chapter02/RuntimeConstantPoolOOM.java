package org.abewang.chapter02;

import java.util.ArrayList;

/**
 * VM Args: -XX:MetaspaceSize=2m -XX:MaxMetaspaceSize=2m
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
