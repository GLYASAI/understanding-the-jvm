package org.abewang.chapter03.gcroots;

/**
 * 局部变量作为GC Roots
 * -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 *
 * @Author Abe
 * @Date 2018/6/8.
 */
public class LocalVariablesTest {
    private static final int _10MB = 10 * 1024 * 1024;
    private byte[] memory = new byte[8 * _10MB];

    public static void method() {
        LocalVariablesTest instance = new LocalVariablesTest();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        method();
        System.gc();
        System.out.println("第二次GC完成");
    }
}
