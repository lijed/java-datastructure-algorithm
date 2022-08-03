/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.sort;

import java.util.Random;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2022/6/27
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arra = new int[100];
        for (int i = 0; i < 100; i++) {
            arra[i] = new Random().nextInt(1000);
        }

        quickSort(arra);

        for (int i : arra) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arra) {
        sort(arra, 0, arra.length - 1);
    }



    public static void sort(int[] arr, int start, int end) {
        // algorithm quicksort(a, first, last)
        //sorts the array entries a[first] through a[last] recursively
//        if (first < last) {
//            choose a pivot
//            Partition the array about pivot
//            pivotIndex = index of pivol
//            quickSort(a, first, pivotIndex -1);
//            quickSort(a, pivotIndex +1, lastindex);
//        }

        if (start >= end) {
            return;
        }

        //有几种方法
        //优化的点：pivotal的选择：三数去平均值
        //或者随机
        int pivotal = arr[start];


        int left = start;
        int right = end;

        while (left <= right) {
            while (left <= right && arr[left] < pivotal) {
                left++;
            }

            while (left <= right && arr[right] > pivotal) {
                right--;
            }

            //原数组交互，不需要占用额外的数组， 空间复杂度为O(1)
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }

        sort(arr, start, right);
        sort(arr, left, end);
    }

}
