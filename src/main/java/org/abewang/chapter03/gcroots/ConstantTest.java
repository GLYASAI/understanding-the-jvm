package org.abewang.chapter03.gcroots;

/**
 * 常量作为GCRoots
 * -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 *
 * @Author Abe
 * @Date 2018/6/8.
 */
public class ConstantTest {
    private static int _10MB = 10 * 1024 * 1024;
    private byte[] memory;

    private static final ConstantTest CONSTANT = new ConstantTest(8 * _10MB);

    public ConstantTest(int size) {
        this.memory = new byte[size];
    }

    public static void main(String[] args) {
        ConstantTest temp = new ConstantTest(4 * _10MB);
        temp = null;
        System.gc();
    }
}
