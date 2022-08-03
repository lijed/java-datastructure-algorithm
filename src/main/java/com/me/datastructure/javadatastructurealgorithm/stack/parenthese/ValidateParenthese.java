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
public class ValidateParenthese {


    public static void main(String[] args) {
        String content = "[{())(}]";
        boolean result = valid(content);
        System.out.printf("the input string %s is valid parenthese? %s", content, result);
    }


    public static boolean valid(String s) {
        //s is blank, return true
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop().charValue() != '[') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop().charValue() != '(') {
                    return false;
                }
            }
        }
        return true;
    }
}
