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
 merge sort
 *
 * @Author: Jed Li
 * Created: 2022/6/27
 **/
public class MergeSort {
    public static void main(String[] args) {

        // 准备数据
        int[] arra = new int[100];
        for (int i = 0; i < 100; i++) {
            arra[i] = new Random().nextInt(1000);
        }

        //排序
        mergeSort(arra);

        //输出结果
        for (int i : arra) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortImpl(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSortImpl(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSortImpl(arr, start, mid, temp);
        mergeSortImpl(arr, mid + 1, end, temp);

        merge(arr, start, mid, end, temp);
    }

    private static void merge(int[] arr, int start, int mid, int end, int[] temp) {

        int left = start;
        int right = mid + 1;


        ///哨兵，简化代码的编写
        int index = start;

        //both sides handle
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }

            index++;
        }

        //handle the left elements in the left side
        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        //handle the left elements in the right side
        while (right <= end) {
            temp[index++] = arr[right++];
        }

        //把临时数组里有序数据拷贝的元数据
        for (index = start; index <= end; index++) {
            arr[index] = temp[index];
        }
    }
}
