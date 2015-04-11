package com.giuseppe;

public class Consumer implements Runnable {

    private ThreadSafeQueue tasks;
    private String name;

    public Consumer(String name, ThreadSafeQueue tasks) {
        this.tasks = tasks;
        this.name = name;
        System.out.println("Create consumer" + this.name);
    }

    private void processTask(Integer task) {
        System.out.println("Consumer " + this.name + " Processed task " + task);
    }

    private void execute() throws InterruptedException {

       while (true) {
          if(!this.tasks.isEmpty()) {
            Integer task = this.tasks.popTask();
            this.processTask(task);
          } else {
            System.out.println("Consumer " + this.name + " Going to sleep");
            synchronized (this.tasks) {
                this.tasks.wait();
            }
          }

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

