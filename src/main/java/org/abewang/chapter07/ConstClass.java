package org.abewang.chapter07;

/**
 * 常量在编译期会存入常量池中, 没有引用到定义常量的类, 因此会不触发定义常量类的初始化
 *
 * @Author Abe
 * @Date 2018/6/4.
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world!";
}
