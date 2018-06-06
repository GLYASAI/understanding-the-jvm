package org.abewang.chapter03.reference;

import org.junit.jupiter.api.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 理解Java的GC与幽灵引用(http://www.iteye.com/topic/401478)
 *
 * @Author Abe
 * @Date 2018/5/26.
 */
public class TestReference {
    @Test
    void testStrongReference() throws InterruptedException {
        Object reference = new Object();
        Object strongRef = reference;

        assertSame(reference, strongRef);

        reference = null;
        System.gc();

        Thread.sleep(1000);

        assertNotNull(strongRef);
    }

    @Test
    void testSoftReference() throws InterruptedException {
        Object reference = new Object();
        SoftReference<Object> softRef = new SoftReference<Object>(reference);

        reference = null;
        System.gc();

        Thread.sleep(1000);

        /**
         * 软引用在OOM前才会被回收
         */
        assertNotNull(softRef.get());
    }

    @Test
    void testWeakReference() {
        Object reference = new Object();
        WeakReference<Object> weakRef = new WeakReference<>(reference);
        assertNotNull(weakRef.get());

        reference = null;
        System.gc();

        /**
         * 一旦没有指向reference的强引用, weakRef在GC中马上被回收
         */
        assertNull(weakRef.get());
    }

    /**
     * WeakHashMap使用WeakReference作为key
     * 一旦没有指向key的强引用, WeakHashMap在GC后将自动删除相关的entry
     */
    @Test
    void testWeakHashMap() throws InterruptedException {
        Map<Object, Object> weakHashMap = new WeakHashMap<>();
        Object key = new Object();
        Object value = new Object();
        weakHashMap.put(key, value);

        key = null;
        System.gc();

        Thread.sleep(1000);

        assertFalse(weakHashMap.containsValue(value));
    }

    @Test
    void testPhantomReference() throws InterruptedException {
        Object reference = new Object();
        ReferenceQueue refQ = new ReferenceQueue();
        PhantomReference<Object> phantomRef = new PhantomReference<Object>(reference, refQ);
        assertNull(phantomRef.get());  // 拿不到引用
        assertFalse(phantomRef.isEnqueued());
        assertNull(refQ.poll());  // 引用队列为空

        reference = null;
        System.gc();

        Thread.sleep(1000);

        assertTrue(phantomRef.isEnqueued());
        assertNotNull(refQ.poll());
    }
}
