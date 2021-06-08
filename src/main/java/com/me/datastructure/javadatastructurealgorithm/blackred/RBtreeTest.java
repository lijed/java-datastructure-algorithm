/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.blackred;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/6/8
 **/
public class RBtreeTest {
    public static void main(String[] args) {
        RBTree<Integer> rbTree = new RBTree<Integer>();
        rbTree.insert(50);
        rbTree.insert(75);
        rbTree.insert(30);
        rbTree.insert(90);
        rbTree.insert(100);
        rbTree.insert(130);
        rbTree.insert(140);
        rbTree.insert(200);
        rbTree.print();
    }
}
