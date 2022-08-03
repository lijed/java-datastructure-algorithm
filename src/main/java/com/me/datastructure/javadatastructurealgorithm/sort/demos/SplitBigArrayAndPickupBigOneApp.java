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
 * @Author: jed li
 * Created: 2022/6/28
 **/
public class SplitBigArrayAndPickupBigOneApp {

    public static void main(String[] args) {

        final int[] array = createArray(1000);

        int subArrayLength = 10;

        int start = 0;
        int end = 0;
        while (true) {
            end = start + subArrayLength;
            if (end > array.length) {
                end = array.length;
            }
            int[] subArray = new int[end - start];
            System.arraycopy(array, start, subArray, 0, subArray.length);

            System.out.println("before sort:" + Arrays.toString(subArray));

            sortSubArray(subArray);

            System.out.println("after sort: " + Arrays.toString(subArray));
            System.out.println("the maximum element: " + subArray[subArray.length - 1]);

            start = start + subArrayLength;
            if (start >= array.length) {
                break;
            }
        }
    }

    private static void sortSubArray(int[] subArray) {
        if (subArray.length >= 5) {
//            quickSort(subArray, 0, subArray.length - 1);
            mergeSort(subArray);

        } else {
            inserSort(subArray);
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            // stop recursive
            return;
        }
        int left = start;
        int right = end;
        int pivot = arr[start];
        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }


    private static void swap(int[] array, int left, int right) {
        int tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
    }


    public static int[] createArray(int length) {
        int[] array = new int[length];

        //random number to fill array
        fillArrayWithRandomElemment(array);

//        createSequenceElementArray(length);

        return array;
    }

    private static void fillArrayWithRandomElemment(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
    }

    private static void createSequenceElementArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }


    private static void inserSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int insertNode;
        int j;
        for (int i = 1; i < arr.length; i++) {
            j = i - 1;
            insertNode = arr[i];
            while (j >= 0 && insertNode < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = insertNode;
        }
    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortImpl(arr, 0, arr.length-1, temp);
    }

    private static void mergeSortImpl(int[] arr, int start, int end, int[] temp) {

        //when to stop
        if (start >= end) {
            return;
        }

        //
        int mid = (start + end) / 2;
        mergeSortImpl(arr, start, mid, temp);
        mergeSortImpl(arr, mid + 1, end, temp);

        //merge sorted result
        merge(arr, start, end, mid, temp);
    }


    private static void merge(int[] arr, int start, int end, int mid, int[] temp) {

        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        //handle the left left elements
        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        //handler the left right elements
        while (right <= end) {
            temp[index++] = arr[right++];
        }

        for (index = start; index <= end; index++) {
            arr[index] = temp[index];
        }
    }

}
