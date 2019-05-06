package com.nocturne.study.java.basic.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by liang.ding on 2019-05-03.
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        queue.offer("aaaaa");
        queue.offer("bbbbb", 3, TimeUnit.SECONDS);
        queue.offer("ccccc");
        queue.offer("ddddd", 3, TimeUnit.SECONDS);
        System.out.println(queue.size());

        System.out.println(queue.poll(3,TimeUnit.SECONDS));
        System.out.println(queue.poll(3,TimeUnit.SECONDS));
        System.out.println(queue.poll(3,TimeUnit.SECONDS));
        System.out.println(queue.poll(3,TimeUnit.SECONDS));


    }
}
