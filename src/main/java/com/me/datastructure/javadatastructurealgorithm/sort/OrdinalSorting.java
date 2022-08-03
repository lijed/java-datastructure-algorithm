/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.sort;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2022/7/11
 **/
public class OrdinalSorting {

    public static void main(String[] args) {
        String[] arr = new String[5];
        arr[0] = "bbc";
        arr[1] = "aaa";
        arr[2] = "cbc";
        arr[3] = "gbc";
        arr[4] = "gac";
        System.out.println(Arrays.toString(arr));
        System.out.println("compare");
        arr =  ordinalSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static String[] ordinalSort(String[] a) {
        if (a== null || a.length <=1) {
            return a;
        }

        //find max length
        int maxLength = a[0].length();
        for (int i = 1; i < a.length; i++) {
            if (maxLength < a[i].length()) {
                maxLength = a[i].length();
            }
        }

        //padding element with zero
        for (int i = 1; i < a.length; i++) {
            if (a[i].length() < maxLength) {
                a[i] = StringUtils.rightPad(a[i], maxLength, "0");
            }
        }

        //计数排序 from low to hign
        SortUnit[] us = new SortUnit[a.length];

        //排序的轮数,同时，也是i为每一轮比较的字符的下标
        for (int i = maxLength-1; i >= 0; i--) {

            for (int j = 0; j < a.length; j++) {
                if (i == maxLength-1) {
                    us[j] = new SortUnit(a[j].toCharArray()[i], a[j]);
                } else {
                    us[j].character = us[j].element.toCharArray()[i];
                }
            }
            countingSort(us, a.length);
        }

        return  Arrays.stream(us).map(e -> e.element).collect(Collectors.toList()).toArray(new String[0]);
    }

    static class SortUnit {
        char character;
        String element;

        public SortUnit(char character, String element) {
            this.character = character;
            this.element = element;
        }
    }


    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public static void countingSort(SortUnit[] a, int n) {

        System.out.println("countingSort: " + Arrays.toString(Arrays.stream(a).map(data-> data.element).collect(Collectors.toList()).toArray(new String[0])));
        if (n <=1 || a == null) {
            return ;
        }

        //查找数据中
        int max = a[0].character;
        for (int i = 1; i < n; i++) {
            if (max < a[i].character) {
                max = a[i].character;
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
            c[a[i].character]++;
        }

        System.out.println("c[]" + Arrays.toString(c));

        // 依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i-1] + c[i];
        }

        System.out.println("c[]" + Arrays.toString(c));

        //声明一个临时数组，用来存储排序之后的结果
         SortUnit[] temp = new SortUnit[n];
        int index = 0;
        for (int i=n-1; i>=0 ; --i) {
            index = c[a[i].character]-1;
            temp[index] = a[i];
            c[a[i].character]--;
        }

        for (int i = 0; i < n; ++i) {
            a[i] = temp[i];
        }

        System.out.println("countingSort: " + Arrays.toString(Arrays.stream(a).map(data-> data.element).collect(Collectors.toList()).toArray(new String[0])));
    }
}
