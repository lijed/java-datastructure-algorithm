/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.skiptable;

import java.util.Arrays;

/**
 * 跳表的一种实现方法。
 * 跳表中存储的是正整数，并且存储的是不重复的。
 *
 * @Author: Jed Li
 * Created: 2022/7/12
 **/
public class SkipTable {
    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    //带头链表
    private Node head = new Node();

    private int levelCount = 1;

    public Node find(int value) {
        Node p = head;
        for (int level = MAX_LEVEL - 1; level >= 0; level--) {
            while (p.forwards[level] != null && p.forwards[level].data > value) {
                p = p.forwards[level];
            }
        }
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }


    public void insert(int value) {
        int level = randomLevel();
        Node node = new Node();
        node.data = value;
        node.maxLevel = level;

        //所有的update nodes都指向
        Node[] updates = new Node[level];
        for (int i = 0; i < level; i++) {
            updates[i] = head;
        }


        // 从高层遍历
        Node p = head;
        for (int i = level - 1; i >=0; i--) {
            //从链表的头开始遍历，找到小于插入元素的前置结点
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }

            updates[i] = p;
        }

        //插入节点
        for (int i = 0; i < level - 1; i++) {
            //指向待插入节点的后置节点
            node.forwards[i] = updates[i].forwards[i];
            //把当前节点赋值给前置结点的后置节点
            updates[i].forwards[i] = node;
        }

        //update node hight
        if (levelCount < level) {
            levelCount = level;
        }

    }


    // 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
    // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
    //        50%的概率返回 1
    //        25%的概率返回 2
    //      12.5%的概率返回 3 ...
    private int randomLevel() {
        int level = 1;

        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
            level += 1;
        }

        return level;
    }


    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = (levelCount - 1); i >=0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }

            update[i] = p;
        }
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = (levelCount - 1); i >= 0; i--) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

        //移除没有next节点的索引，从上往下移除
        //head.forwards[levelCount-1] head的next节点
        while (levelCount > 1 && head.forwards[levelCount - 1] == null) {
            levelCount--;
        }
    }


    public void printAll() {
       Node p = head;
       while(p.forwards[0] != null) {
           System.out.println(p.forwards[0].data);
           p = p.forwards[0];
       }
        System.out.println();
    }


    public class Node {
        private int data = -1;

        //表示各个level里下一个节点
        private Node[] forwards = new Node[MAX_LEVEL];

        private int maxLevel = 0;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", forwards=" + Arrays.toString(forwards) +
                    ", maxLevel=" + maxLevel +
                    '}';
        }
    }
}
