/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.hash;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.core.codec.Encoder;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2022/7/12
 **/
public class MD5 {
    public static void main(String[] args) {

        String md5Hex = DigestUtils.md5Hex("我今天讲哈希算法!");
        System.out.println(md5Hex);


        md5Hex = DigestUtils.md5Hex("我今天讲哈希算法");
        System.out.println(md5Hex);


    }
}
