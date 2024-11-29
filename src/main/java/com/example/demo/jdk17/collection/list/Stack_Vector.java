package com.example.demo.jdk17.collection.list;


import java.util.Deque;
import java.util.Stack;
import java.util.Vector;

public class Stack_Vector {


    /**
     * 为什么不推荐使用
     * 性能低：是因为 Stack 继承自 Vector， 而 Vector 在每个方法中都加了锁。由于需要兼容老的项目，
     * 很难在原有的基础上进行优化，因此 Vector 就被淘汰掉了，使用 ArrayList 和 CopyOnWriteArrayList 来代替，
     * 如果在非线程安全的情况下可以使用 ArrayList，线程安全的情况下可以使用 CopyOnWriteArrayList 。
     * 破坏了原有的数据结构：栈的定义是在一端进行 push 和 pop 操作，除此之外不应该包含其他 入栈和出栈 的方法，
     * 但是 Stack 继承自 Vector，使得 Stack 可以使用父类 Vector 公有的方法。
     *
     *
     * <p>A more complete and consistent set of LIFO stack operations is
     * provided by the {@link Deque} interface and its implementations, which
     * should be used in preference to this class.  For example:
     * <pre>   {@code Deque<Integer> stack = new ArrayDeque<Integer>();}</pre>
     *
     * @see https://segmentfault.com/a/1190000045396406
     */
    private Stack stack;


    /**
     * vector几乎针对每一个方法都使用了synchronized关键字加锁
     * 线程安全，性能过低，通常都是使用ArrayList，若想使用线程安全的，可有多种方法实现。
     * 迭代时候，会导致线程中出现ConcurrentModificationException。
     */
    private Vector vector;

}
