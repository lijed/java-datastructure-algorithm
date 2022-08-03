/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.hash.consistenthash;

/**
 * Description:
 *
 * @Author: Jed Li
 * Created: 2022/6/20
 **/

public abstract class ShardInfo<T>{
    private int weight;
    public ShardInfo() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return
     */
    public abstract T createResource();

    /**
     * @return
     */
    public abstract String getName();

}
