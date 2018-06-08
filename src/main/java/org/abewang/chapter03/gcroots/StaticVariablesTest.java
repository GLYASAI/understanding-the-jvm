package org.abewang.chapter03.gcroots;

/**
 * 静态变量引用的对象可作为GCRoots
 * -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 *
 * @Author Abe
 * @Date 2018/6/8.
 */
public class StaticVariablesTest {
    private static final int _10MB = 10 * 1024 * 1024;
    private byte[] memory;

    private static StaticVariablesTest instance;

    public StaticVariablesTest(int size) {
        this.memory = new byte[size];
    }

    public static void main(String[] args) {
        StaticVariablesTest temp = new StaticVariablesTest(4 * _10MB);
        StaticVariablesTest.instance = new StaticVariablesTest(8 * _10MB);
        temp = null;
        System.gc();
    }
}
