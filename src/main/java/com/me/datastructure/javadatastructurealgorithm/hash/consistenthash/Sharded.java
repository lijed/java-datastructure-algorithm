/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.hash.consistenthash;

import com.me.datastructure.javadatastructurealgorithm.hash.consistenthash.ShardInfo;

import java.util.*;

/**
 * Description:
 *
 * @Author: Jed Li
 * Created: 2022/6/20
 **/
public class Sharded<R, S extends ShardInfo<R>> {

    private TreeMap<Long, S> nodes;
    private Hashing algo;
    private final Map<ShardInfo<R>, R> resources = new LinkedHashMap<ShardInfo<R>, R>();

    public Sharded(List<S> shards) {
        // MD5 is really not good as we work with 64-bits not 128
        this(shards, Hashing.MURMUR_HASH);
    }

    public Sharded(List<S> shards, Hashing algo) {
        this.algo = algo;
        initialize(shards);
    }

    private void initialize(List<S> shards) {
        nodes = new TreeMap<>();
        for (int i = 0; i < shards.size(); i++) {
            final S shardInfo = shards.get(i);

            //一定要注意Key的信息的组成
            if(shardInfo.getName() == null) {
                for (int n = 0; n < 160 * shardInfo.getWeight(); n++) {

                    nodes.put(this.algo.hash("SHARD-" + i + "-NODE-" + n), shardInfo);
                }
            } else {
                for (int n = 0; n < 160 * shardInfo.getWeight(); n++) {
                    nodes.put(this.algo.hash(shardInfo.getName() + "*" + shardInfo.getWeight() + n), shardInfo);
                }
            }
            resources.put(shardInfo, shardInfo.createResource());
        }
    }

    public R getShard(String key) {
        return resources.get(getShardInfo(key));
    }

    private ShardInfo<R> getShardInfo(String key) {
        return getShardInfo(SafeEncoder.encode(key));
    }

    private ShardInfo<R> getShardInfo(byte[] encode) {
        final SortedMap<Long, S> tail = nodes.tailMap(algo.hash(encode));

        //如果tailMap为空，说明已经访问Map的最后一个节点，此时应该返回Node的第一个key对应的值
        if (tail.isEmpty()) {
            return nodes.get(nodes.firstKey());
        }
        //返回尾Map的第一个结点
        return tail.get(tail.firstKey());
    }

}
