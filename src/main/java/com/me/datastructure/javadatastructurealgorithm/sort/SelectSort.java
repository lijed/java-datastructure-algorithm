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
public class SelectSort {

    public static void main(String[] args) {

        int[] arra = new int[100];
        for (int i = 0; i < 100; i++) {
            arra[i] = new Random().nextInt(1000);
        }
        selectSort(arra);
        for (int i : arra) {
            System.out.println(i);
        }
    }

    private static void selectSort(int[] arra) {
        int smallIndex;
        int tmp;
        for (int i = 0; i < arra.length - 1; i++) {
            smallIndex = findSmallestIndex(arra, i);
            if (smallIndex != i) {
                tmp = arra[i];
                arra[i] = arra[smallIndex];
                arra[smallIndex] = tmp;
            }
        }
    }

    private static int findSmallestIndex(int[] arra, int startIndex) {
        int smallIndex = startIndex;
        for (int i = startIndex + 1; i < arra.length; i++) {
            if (arra[i] < arra[smallIndex]) {
                smallIndex = i;
            }
        }
        return smallIndex;
    }
}
