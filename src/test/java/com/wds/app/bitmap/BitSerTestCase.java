package com.wds.app.bitmap;

import org.junit.Test;

import java.util.BitSet;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-09-14 16:19
 */
public class BitSerTestCase {

    @Test
    public void testBitmap(){
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        BitSet bitSet1 = new BitSet();
        bitSet1.set(2);
        bitSet.stream().forEach(val -> System.out.println(val));
    }
}
