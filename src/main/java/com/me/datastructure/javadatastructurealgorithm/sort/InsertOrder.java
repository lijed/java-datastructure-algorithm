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
public class InsertOrder {

    public static void main(String[] args) {
        int[] arra = new int[100];
        for (int i = 0; i < 100; i++) {
            arra[i] = new Random().nextInt(1000);
        }

        insertSort(arra);

        for (int i : arra) {
            System.out.println(i);
        }
    }

    public static void insertSort(int[] arr) {
        if (arr != null) {
            int insertNode;
            int j = 0;
            for (int i = 1; i < arr.length; i++) {
                insertNode = arr[i];
                j = i - 1;
                while (j >= 0 && insertNode < arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = insertNode;
            }
        }
    }
}
