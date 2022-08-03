/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.tree;

/**
 * Description:
 *
 * @Author: Jed Li
 **/
public class PailieZuhe {
    public static void main(String[] args) {
        int[]a ={1, 2, 3, 4};
        printPermutation(a, 4, 4);
    }


    private static void printPermutation(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; i++) {
            //
            int tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
            printPermutation(data, n, k-1);

            //复原数据
            tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
        }
    }
}
