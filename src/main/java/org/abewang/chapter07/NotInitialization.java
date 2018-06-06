package org.abewang.chapter07;

/**
 * @Author Abe
 * @Date 2018/6/4.
 */
public class NotInitialization {
    /**
     * 子类调用父类的静态变量, 子类不会被初始化
     */
    public static void printValue() {
        System.out.println(SubClass.value);
    }

    /**
     * 通过数组定义来引用类, 不会触发此类的初始化
     */
    public static void newArr() {
        SuperClass[] sca = new SuperClass[10];  // newarray
    }

    public static void constant() {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
