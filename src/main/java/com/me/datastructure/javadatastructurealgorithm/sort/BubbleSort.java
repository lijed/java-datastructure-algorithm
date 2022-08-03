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
public class BubbleSort {
    public static void main(String[] args) {
        int[] arra = new int[100];
        for (int i = 0; i < 100; i++) {
            arra[i] = new Random().nextInt(1000);
        }
        bubbleSort(arra);
        for (int i : arra) {
            System.out.println(i);
        }
    }


    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
