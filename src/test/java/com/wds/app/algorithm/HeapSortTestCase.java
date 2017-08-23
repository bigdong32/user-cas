package com.wds.app.algorithm;

import org.junit.Test;

/**
 * 堆排序
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-21 15:00
 */
public class HeapSortTestCase {

    @Test
    public void testCase(){
        int[] array = {0, 3, 7, 6, 5, 4, 20, 16};

        for (int i = (array.length - 1) / 2; i > 0 ; i--){
            heapSort(array, i, array.length - 1);
        }

        for (int i = array.length - 1; i > 1 ; i--){
            int temp = array[1];
            array[1] = array[i];
            array[i] = temp;
            heapSort(array, 1, i -1);
        }

        for(int i = 1; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    private void heapSort(int[] array, int rootPos, int length){
        int rootVal = array[rootPos];
        for(int i = rootPos * 2; i <= length; i = rootPos * 2){
            if(i < length && array[i] < array[i + 1]){
                i++;
            }
            if(rootVal >= array[i]){
                break;
            }
            array[rootPos] = array[i];
            rootPos = i;
        }
        array[rootPos] = rootVal;
    }
}
