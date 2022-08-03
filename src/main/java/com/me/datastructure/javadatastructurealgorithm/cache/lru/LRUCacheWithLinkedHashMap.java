/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.cache.lru;

import java.util.LinkedHashMap;

/**
 * 用LinkedHashMap实现的LRU Cache
 *
 * @Author: Jed Li
 * Created: 2022/7/5
 **/
public class LRUCacheWithLinkedHashMap {
    public static void main(String[] args) {

        LinkedHashMap<String, String> lruCache = new LinkedHashMap<String, String>(100, 0.75f, true);

        for (int i = 0; i < 100; i++) {
            lruCache.put("key"+ i, String.valueOf(i));
        }

        lruCache.entrySet().forEach(entry-> {
            System.out.printf("key: %s, value:%s\r\n", entry.getKey(), entry.getValue());
        });


        int times;
        String key;
        for (int i = 0; i < 10; i++) {
            times = (int)( Math.random() * 100);
            key = "key"+times;
            for (int j = 0; j < times; j++) {
                lruCache.get(key);
            }
            System.out.println("the key: " + key  + " is accessed times? " + times);
        }
        lruCache.entrySet().forEach(entry-> {
            System.out.printf("key: %s, value:%s\r\n", entry.getKey(), entry.getValue());
        });

        System.out.println("=================================================");
        // add a new element
        lruCache.put("key200", String.valueOf("200"));
        lruCache.entrySet().forEach(entry-> {
            System.out.printf("key: %s, value:%s\r\n", entry.getKey(), entry.getValue());
        });
    }
}
