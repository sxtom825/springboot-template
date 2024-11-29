package com.example.demo.jdk17.util;




import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Test3 {


    public static void main(String[] args) {


//        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(10);
//        blockingDeque.offer("");
//
//
//        try {
//            blockingDeque.take();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        IntStream.rangeClosed(0, 10).boxed().map(i -> new Thread(" th1 " + i) {
//            @Override
//            public void run() {
//
//            }
//        }).forEach(Thread::start);

        ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
        queue.add(new Object());

        Object object = queue.poll();
        int loops = 0;
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        while (true) {


            queue.add(object);
            queue.remove(object);
            loops++;
        }


    }
}
