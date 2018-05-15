package org.abewang.chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @Author Abe
 * @Date 2018/5/14.
 */
public class Chapter2Test {
    @Test
    void heapOOMTest() {
        Throwable exception = assertThrows(OutOfMemoryError.class, HeapOOM::heapOOM);
        assertEquals("Java heap space", exception.getMessage());
    }

    @Test
    void stackOverflow() {
        assertThrows(StackOverflowError.class, JavaVMStackSOF::javaVMStackSOF);
    }

}
