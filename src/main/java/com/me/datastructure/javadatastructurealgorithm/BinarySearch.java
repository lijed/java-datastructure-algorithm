/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm;

import com.me.datastructure.javadatastructurealgorithm.sort.QuickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2022/7/11
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[10];
        final Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }

        //先排序
        QuickSort.quickSort(arr);

        System.out.println(Arrays.toString(arr) + ", " +  arr[6]);

        int index = binarySearch(arr, arr[6]);
        System.out.println(index);
    }


    /**
     *  有序数组
     * @param a
     * @param n
     * @return
     */
    public static int binarySearch(int[] a, int n) {
        int low = 0;
        int high = a.length -1;

        int mid = 0;
        while(low <= high) {
            mid = low + ((high-low) >>1);
            System.out.println("mid: " + mid);
//            mid = (low + high)/2;
            if (a[mid] == n) {
                return mid;
            } else if (a[mid] > n) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return  -1;
    }


    // 二分查找的递归实现
    public int bsearch(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid =  low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid+1, high, value);
        } else {
            return bsearchInternally(a, low, mid-1, value);
        }
    }

}
