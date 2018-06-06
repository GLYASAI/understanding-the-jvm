package org.abewang.chapter02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @Author Abe
 * @Date 2018/5/14.
 */
public class Chapter2Test {
    private final static Logger LOGGER = LogManager.getLogger(Chapter2Test.class);

    @Test
    void heapOOMTest() {
        Throwable exception = assertThrows(OutOfMemoryError.class, HeapOOM::heapOOM);
        assertEquals("Java heap space", exception.getMessage());
    }

    @Test
    void stackOverflowTest() {
        assertThrows(StackOverflowError.class, JavaVMStackSOF::javaVMStackSOF);
    }

    @Test
    void directMemoryOOMTest() throws NoSuchFieldException, IllegalAccessException {
        try {
            DirectMemoryOOM.directMemoryOOM();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
