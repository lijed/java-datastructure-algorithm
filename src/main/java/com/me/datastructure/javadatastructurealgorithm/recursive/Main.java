/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.recursive;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2022/7/9
 **/
public class Main {
    public static void main(String[] args) {
        int result = row(19999);
        System.out.println("result" + result);
    }


    public static int row(int i) {
        if (i == 1) {
            return 1;
        }
        return row(i-1)  +1;
    }
}
