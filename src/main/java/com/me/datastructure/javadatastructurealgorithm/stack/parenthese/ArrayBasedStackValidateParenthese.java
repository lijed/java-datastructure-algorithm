/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.stack.parenthese;

import java.util.Stack;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2022/6/16
 **/
public class ArrayBasedStackValidateParenthese {

    public static void main(String[] args) {
        String content = "[{()()}]";
        boolean result = valid(content);
        System.out.printf("the input string %s is valid parenthese? %s", content, result);
    }
    public static boolean valid(String s) {
        //s is blank, return true
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        ArrayStackX stack = new ArrayStackX(10);
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return true;
    }

    private static class ArrayStackX {
        private int size;
        private int top = -1;
        private char[] charArray;

        public ArrayStackX(int size) {
            this.size = size;
            charArray = new char[size];
        }

        public char pop() {
            if (isEmpty()) {
                throw new StackEmptyException("Stack is empty");
            }
            return charArray[top--];
        }

        public void push(char element) {
            if (isFull()) {
                throw new StackFullException("Stack is full");
            }
            charArray[++top] = element;
        }

        public char peak() {
            if (top == -1) {
                throw new StackEmptyException("Stack is empty");
            }
            return charArray[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top + 1 == size;
        }
    }

    private static class StackEmptyException extends RuntimeException {
        public StackEmptyException() {
        }

        public StackEmptyException(String message) {
            super(message);
        }

        public StackEmptyException(String message, Throwable cause) {
            super(message, cause);
        }

        public StackEmptyException(Throwable cause) {
            super(cause);
        }

        public StackEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

    private static class StackFullException extends RuntimeException {
        public StackFullException() {
        }

        public StackFullException(String message) {
            super(message);
        }

        public StackFullException(String message, Throwable cause) {
            super(message, cause);
        }

        public StackFullException(Throwable cause) {
            super(cause);
        }

        public StackFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
