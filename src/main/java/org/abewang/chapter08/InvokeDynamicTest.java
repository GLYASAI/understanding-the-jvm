package org.abewang.chapter08;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * 访问祖类的方法
 *
 * @Author Abe
 * @Date 2018/5/17.
 */
public class InvokeDynamicTest {
    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        @Override
        void thinking() {
            MethodType mt = MethodType.methodType(void.class);
            try {
                MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, Son.class);
                mh.invoke(this);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        InvokeDynamicTest test = new InvokeDynamicTest();
        Son son = test.new Son();
        son.thinking();
    }
}
