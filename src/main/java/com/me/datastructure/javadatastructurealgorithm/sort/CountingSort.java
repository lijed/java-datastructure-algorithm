/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2022/7/11
 **/
public class CountingSort {

    public static void main(String[] args) {
        int[] array = new int[200];
        final Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }

        System.out.println("before: "+ Arrays.toString(array));

        countingSort(array, array.length);

        System.out.println("after: " + Arrays.toString(array));

//        QuickSort.quickSort(array);
//        System.out.println("after: " + Arrays.toString(array));
    }


    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public static void countingSort(int a[], int n) {
        if (n <=1 || a == null) {
            return ;
        }

        //查找数据中
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        System.out.println("max: " + max);

        //申请一个计数数组，下标大小[0, max]
        int[] c = new int[max + 1];
        for (int i = 0; i < c.length; i++) {
            c[i] = 0;
        }

        //记录带排序数组中元素的个数
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        System.out.println("c[]" + Arrays.toString(c));

        // 依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i-1] + c[i];
        }

        System.out.println("c[]" + Arrays.toString(c));

        //声明一个临时数组，用来存储排序之后的结果
        int temp[] = new int[n];
        int index = 0;
        for (int i=n-1; i>=0 ; --i) {
            index = c[a[i]]-1;
            temp[index] = a[i];
            c[a[i]]--;
        }

        for (int i = 0; i < n; ++i) {
            a[i] = temp[i];
        }
    }
}
