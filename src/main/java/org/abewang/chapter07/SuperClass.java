package org.abewang.chapter07;

/**
 * 子类调用父类的静态变量, 子类不会被初始化
 *
 * @Author Abe
 * @Date 2018/6/4.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 111;
}
