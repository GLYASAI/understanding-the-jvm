package org.abewang.chapter02;

import java.util.ArrayList;

/**
 * @Author Abe
 * @Date 2018/5/14.
 */
public class StringIntern {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuilder("AbeWang").toString();
        System.out.println(str3.intern() == str3);
    }
}
