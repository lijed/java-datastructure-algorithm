/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.heap;

import java.util.Arrays;
import java.util.Random;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2022/7/14
 **/
public class HeapSort {

    /**
     * @param a  the array of elements that needs to be sorted
     * @param n  the length of element array
     */
    private static void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) {
                maxPos = i*2;
            }
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) {
                maxPos = i*2+1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }


    public static void sort(int[] a, int n) {
        if (a == null || a.length <= 1) {
            return;
        }

        //堆化
        buildHeap(a, n);

        //交换最后一个元素和a[1]，然后对n-1课元素进行堆化
        int k = n;
        while (k > 1) {
            ///交换最后一个元素和a[1]
            swap(a, 1, k);
            --k;
            //堆化
            heapify(a, k, 1);
        }
    }


    public static void main(String[] args) {
        int[] a = new int[21];
        Random random = new Random();
        for (int i = 1; i < 21; i++) {
            a[i]= random.nextInt(100);
        }

        System.out.println(Arrays.toString(a));
        sort(a, 20);

        System.out.println(Arrays.toString(a));
    }
}
