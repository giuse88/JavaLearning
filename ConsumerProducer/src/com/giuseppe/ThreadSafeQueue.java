package com.giuseppe;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ThreadSafeQueue {

    private Queue<Integer> queue;

    ThreadSafeQueue() {
       this.queue = new PriorityQueue<Integer>();
    }

    public synchronized void addTask(Integer task) {
       this.queue.add(task);
    }

    public synchronized int popTask() {
       return this.queue.poll();
    }

    public synchronized void addTasks(Integer[] tasks) {
       this.queue.addAll(Arrays.asList(tasks));
    }

    public synchronized int size() {
        return this.queue.size();
    }

    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
