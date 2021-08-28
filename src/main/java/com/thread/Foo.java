package com.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 一个将会调用 first() 方法
 * 一个将会调用 second() 方法
 * 还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: "firstsecondthird"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 * 示例 2:
 *
 * 输入: [1,3,2]
 * 输出: "firstsecondthird"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
 * 正确的输出是 "firstsecondthird"。
 *  
 *
 * 提示：
 *
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Foo {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
        System.out.println(Thread.currentThread().getName());

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        System.out.println(Thread.currentThread().getName());
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
        System.out.println(Thread.currentThread().getName());

    }


    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        //int[] arr = {1,2,3};
        int[] arr = {3,2,1};
        AtomicInteger tag = new AtomicInteger(1);
        ThreadFactory threadFactory = (Runnable r) -> {
            Thread thread = new Thread(r);
            thread.setName("线程-demo-" + tag.getAndIncrement());
            return thread;
        };

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3,
                10, TimeUnit.SECONDS,new LinkedBlockingDeque(1),threadFactory);

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 1 : poolExecutor.execute(() -> {
                    try {
                        foo.first(new PrintFirst());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });break;
                case 2 : poolExecutor.execute(() -> {
                    try {
                        foo.second(new PrintSecond());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });break;
                case 3 : poolExecutor.execute(() -> {
                    try {
                        foo.third(new PrintThird());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });break;
                default : break;
            }
        }
    }
}

class PrintFirst implements Runnable {

    @Override
    public void run() {
        System.out.println("first");
    }
}

class PrintSecond implements Runnable {

    @Override
    public void run() {
        System.out.println("second");
    }
}

class PrintThird implements Runnable {

    @Override
    public void run() {
        System.out.println("third");
    }
}