/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.heap;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * 堆
 *
 * @Author: Jed Li
 * Created: 2022/7/14
 **/
public class Heap {

    private int count;   //当前数据中元素的个数
    private int[] a;  //数组来存储堆中的元素
    private int length;  //定义数组的长度

    public Heap(int compacity) {
        this.length = compacity;
        this.a = new int[compacity + 1];  //数值中第0位位置是预留不使用
        count = 0;
    }


    public boolean insert(int data) {
        //检查堆是否满了
        if (count >= length) {
            return false;
        }
        //更改count的值
        ++count;
        a[count] = data;

        //插入元素
        int child = count;
        int parent = count/2;
        while(a[child] < a[parent]) {
            swap(a, child, parent);
            child = parent;
            parent = child/2;
        }

        return false;
    }

    /**
     * remove max element
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] =a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     *  堆化
     */
    private void heapify(int[] a, int n, int i) {
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



}
