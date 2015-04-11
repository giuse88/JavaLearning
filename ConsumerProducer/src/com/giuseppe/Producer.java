package com.giuseppe;

import java.util.Random;

public class Producer implements Runnable {

    private ThreadSafeQueue tasks;
    private String name;

    final private Random randomGenerator = new Random();
    private final static int HOW_MANY_TASKS= 10;

    public Producer(String name, ThreadSafeQueue tasks) {
        this.tasks = tasks;
        this.name = name;
        System.out.println("Create producer " + this.name);
    }

    private Integer[] createTasks() {
        Integer[] newTasks = new Integer[HOW_MANY_TASKS];

        for (int i = 0; i< HOW_MANY_TASKS; i++) {
            int task = this.randomGenerator.nextInt(100);
            newTasks[i] = task;
       }
       return newTasks;
    }

    private void addTasks(Integer[] newTasks) {
       this.tasks.addTasks(newTasks);
    }

    private void execute() throws InterruptedException {

        while (true) {
            this.addTasks(this.createTasks());
            synchronized (this.tasks) {
                this.tasks.notifyAll();
            }
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        System.out.println("Started thread " + this.name);
        try {
            this.execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

