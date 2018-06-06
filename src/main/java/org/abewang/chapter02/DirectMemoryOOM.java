package org.abewang.chapter02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args: -Xmx20M --XX:MaxDirectMemorySize=10M
 *
 * @Author Abe
 * @Date 2018/5/15.
 */
public class DirectMemoryOOM {
    public static final int _1MB = 1024 * 1024;

    public static void directMemoryOOM() throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeField.setAccessible(true);
        // 字段不是静态字段的话,要传入反射类的对象.如果传null是会报NPE
        // 如果字段是静态字段的话,传入任何对象都是可以的,包括null
        Unsafe unsafe = (Unsafe) theUnsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

    public static void main(String[] args) {
        try {
            directMemoryOOM();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
