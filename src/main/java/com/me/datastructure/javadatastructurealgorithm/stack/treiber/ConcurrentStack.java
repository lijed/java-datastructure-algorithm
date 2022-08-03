/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.stack.treiber;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 无锁栈 https://segmentfault.com/a/1190000012463330
 *
 * @Author: Jed Li
 * Created: 2021/6/11
 **/
public class ConcurrentStack<E> {

    private AtomicReference<Node<E>> top = new AtomicReference<Node<E>>();

    public void push(E item) {
        Node newNode = new Node(item);
        Node oldNode = null;
        do {
            oldNode = top.get();
            newNode.next = oldNode;
        } while (top.compareAndSet(newNode.next, newNode));
    }

    public E pop() {
        Node<E> oldHead;
        Node<E> newHead;
        do {
            oldHead = top.get();
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.next;
        } while (!top.compareAndSet(oldHead, newHead));

        return oldHead.item;
    }

    private static class Node<E> {
        private final E item;
        private Node<E> next;

        Node(E item) {
            this.item = item;
        }
    }
}

