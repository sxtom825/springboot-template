package com.example.demo.jdk17.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Node<E> {

    private E value;

    volatile Node<E> next;

    public Node(E value) {
        this.value = value;
    }

    void ssss(){
        Executor executor = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }
}
