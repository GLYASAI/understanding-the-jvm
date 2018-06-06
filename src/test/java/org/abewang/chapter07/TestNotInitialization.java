package org.abewang.chapter07;

import org.junit.jupiter.api.Test;

/**
 * @Author Abe
 * @Date 2018/6/4.
 */
public class TestNotInitialization {
    @Test
    void testPrintValue() {
        NotInitialization.printValue();
    }

    @Test
    void testNewArr() {
        NotInitialization.newArr();
    }

    @Test
    void testConstant() {
        NotInitialization.constant();
    }
}
