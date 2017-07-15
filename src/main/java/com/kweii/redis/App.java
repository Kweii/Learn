package com.kweii.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by gui on 2017/7/15.
 */
public class App {
    private static final JedisPool jedisPool = RedisUtil.getJedisPool();
    private static Runnable task = new Runnable() {
        public void run() {
            Jedis jedis = jedisPool.getResource();
            String threadName = Thread.currentThread().getName();

            String key = null;
            String value = null;

            for (int i=0; i<500000; i++){
                key = threadName + ":" + i;
                value = threadName + "--" + i;

                jedis.set(key, value);

                System.out.println(key);
            }
        }
    };

    public static void main(String[] args){
        for (int i=0; i<10; i++){
            new Thread(task).start();
        }



    }
}
