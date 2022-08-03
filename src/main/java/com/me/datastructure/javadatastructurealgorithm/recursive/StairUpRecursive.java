/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2022/7/9
 **/
public class StairUpRecursive {
    private static Map<Integer, Long> cache = new HashMap<>();

    public static void main(String[] args) {
        long n = tunedStep(1000);
        System.out.println(n);

        System.out.println(stepWithIteration(1000));
    }

    public static long tunedStep(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        Integer key = Integer.valueOf(n);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }


        long ret = tunedStep(n - 1) + tunedStep(n - 2);
        cache.put(key, ret);
        return ret;
    }


    /**
     * @param n
     * @return
     */
    public static int step(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return step(n - 1) + step(n - 2);
    }



    public static long stepWithIteration(int n ) {
        if (n == 1 || n == 2) {
            return n;
        }

        long ret = 0;
        long prePre= 1;
        long pre =2;
        for (int i = 3; i <=n; i++) {
            ret = pre + prePre;
            prePre = pre;
            pre = ret;
        }
        return ret;
    }
}
