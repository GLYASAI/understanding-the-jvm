package org.abewang.chapter02;

/**
 * VM Args: -Xss128k
 *
 * @Author Abe
 * @Date 2018/4/20.
 */
public class JavaVMStackSOF {
    private static int stackLength;

    public static void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void javaVMStackSOF() throws Throwable {
        try {
            stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + stackLength);
            throw e;
        }
    }
}
