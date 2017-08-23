package com.wds.app.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 二分查找
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-17 13:46
 */
public class MiddleFindTestCase {

    @Test
    public void towPointFind() {
        int findNum = 3;
        int[] array = {2, 4, 9, 3, 5, 7, 6, 1};
        Arrays.sort(array);
        int midPos = binarySearch(0, array.length - 1, array, findNum);
        System.out.println(midPos);
    }

    private Integer binarySearch(int start, int end, int[] data, int findNum){
        if(start > end){
            return -1;
        }

        int mid = (start + end) / 2;
        if(data[mid] == findNum){
            return mid;
        }else if(findNum < data[mid]){
            return binarySearch(start, mid - 1, data, findNum);
        }else{
            return binarySearch(mid + 1, end, data, findNum);
        }
    }
}
