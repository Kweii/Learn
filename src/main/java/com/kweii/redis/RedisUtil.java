package com.kweii.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by gui on 2017/7/15.
 */
public class RedisUtil {
    private static JedisPool pool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(500);

        config.setMaxIdle(5);

        config.setTestOnBorrow(true);

        config.setMaxWaitMillis(1000*60);

        pool = new JedisPool(config, "127.0.0.1", 6379);
    }

    public static JedisPool getJedisPool(){
        return pool;
    }

}
