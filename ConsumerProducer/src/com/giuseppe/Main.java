package com.giuseppe;

public class Main {

    public static void main(String[] args) {

        ThreadSafeQueue tasks = new ThreadSafeQueue();

        Consumer consumer_1 = new Consumer("Consumer 1", tasks);
        Consumer consumer_2 = new Consumer("Consumer 2", tasks);
        Consumer consumer_3 = new Consumer("Consumer 3", tasks);

        Producer producer = new Producer("Producer", tasks);

        new Thread(producer).start();
        new Thread(consumer_1).start();
        new Thread(consumer_2).start();
        new Thread(consumer_3).start();

        System.out.println("Main terminated");
    }
}
