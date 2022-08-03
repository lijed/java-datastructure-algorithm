/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.sort.demos;

import java.util.Arrays;
import java.util.Random;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2022/6/27
 **/
public class FindElementFromArray {

    public static void main(String[] args) {
        final int compacity = 1000;
        final int highLimit = 1000;
        //prepare  an array with the specified compacity
        int[] arr = new int[compacity];
        Random random = new Random();
        for (int i = 0; i < compacity; i++) {
            arr[i] = random.nextInt(highLimit);
        }


        //split the array and find
        int subStart = 0, subEnd = 0;
        int[] subArray ;
        int subArrayLength = 10;
        while (true) {
            subEnd = subStart + subArrayLength;
            if (subEnd > compacity) {
                subEnd = compacity-1;
                subArray = new int[compacity- subStart - 1];
            } else {
                subArray = new int[subArrayLength];
            }
            System.arraycopy(arr, subStart, subArray, 0, subArray.length);

            String elementsInStr = Arrays.toString(subArray);


            // dual pivotal - 双枢快速排序
            Arrays.sort(subArray);

            System.out.printf("max element %d , in array [%s] \r\n", subArray[subArray.length-1],  elementsInStr);

            subStart = subStart + subArrayLength;
            if (subStart >=compacity) {
                break;
            }


            //add  a new element

        }
    }
}
