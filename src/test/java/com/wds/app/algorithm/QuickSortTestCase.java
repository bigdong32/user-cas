package com.wds.app.algorithm;

import org.junit.Test;

/**
 * 快速排序
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-21 14:36
 */
public class QuickSortTestCase {

    @Test
    public void testQuick() {
        int[] array = {1, 9, 7, 5, 11, 23};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    private void quickSort(int[] array, int start, int end){
        int temStart = start, temEnd = end, key = array[start];
        while (temStart < temEnd){
            while (temStart < temEnd && key >= array[temEnd]){
                temEnd--;
            }
            if(key <= array[temEnd]){
                swapArryPos(array, temStart, temEnd);
            }
            while (temStart < temEnd && key <= array[temStart]){
                temStart++;
            }
            if(key >= array[temStart]){
                swapArryPos(array, temStart, temEnd);
            }
        }
        if(temStart > start){
            quickSort(array, start, temStart - 1);
        }
        if(temEnd < end){
            quickSort(array, temEnd + 1, end);
        }
    }

    private void swapArryPos(int[] array, int i, int j){
        int tempData = array[i];
        array[i] = array[j];
        array[j] = tempData;
    }
}
