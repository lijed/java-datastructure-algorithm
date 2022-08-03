/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.trietree;

/**
 * Description:
 *
 * @Author: Jed
 * Created: 2022/7/15
 **/
public class Trie {

    private TrieNode root = new TrieNode('/');

    /**
     * 往Trie树中插入一个字符串
     *
     * @param text
     */
    public void insert(char[] text) {

        TrieNode p = root;
        int index = 0;
        char lowerChar;
        for (int i = 0; i < text.length; i++) {
            lowerChar = Character.toLowerCase(text[i] );
            index = (lowerChar - 'a');
            TrieNode child = p.children[index];
            if (child == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }

        p.isEndingChar = true;
    }


    public boolean find(char[] parttern) {
        TrieNode p = root;
        int index;
        for (int i = 0; i < parttern.length; i++) {
            index = Character.toLowerCase(parttern[i]) - 'a';
            TrieNode child = p.children[index];
            if (child != null) {
                p = child;
            } else {
                return false;
            }
        }

        //完全匹配
        if (p.isEndingChar) {
            return true;
        } else {
            //// 不能完全匹配，只是前缀
            return false;
        }
    }

    public static class TrieNode {
        private char data;

        //假定childNode只有26个字符，且不区分大小写
        private TrieNode[] children = new TrieNode[26];
        private boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("How".toCharArray());
        trie.insert("however".toCharArray());
        trie.insert("car".toCharArray());
        trie.insert("carlo".toCharArray());

        System.out.printf("how is in trie dictionary? %s", trie.find("how".toCharArray()));
    }
}
