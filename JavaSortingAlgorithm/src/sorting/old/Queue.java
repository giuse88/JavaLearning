package sorting.old;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: giuseppe
 * Date: 30/01/2014
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 */
public class Queue<T> implements  Iterable<T> {

    int tail = 0;
    int head = 0;
    int maximumSize =0;
    int n=0;
    Object [] array = null;

    public Queue (int size) {
      // we use a sentinel value in oder to be able to
      // distinguish when the queue is empty and when is full since they are represented by the same condition
         // head == tail
      // Possible other solution is to save the number of the items inserted in a counter :D

      this.maximumSize = size+1;
      array = new Object[this.maximumSize];
    }

    private int increaseHead(){
        head = ( head + 1 ) % maximumSize;
        return head;
    }

    private int increaseTail(){
        tail = ( tail + 1) % (maximumSize);
        return tail;
    }

    public int size(){
        // head == tail
        if(isEmpty())
            return 0;
        // head > tail
        if (head > tail)
            return head - tail;
        // head < tail
        return maximumSize - ( tail - head);
    }

    public boolean isEmpty(){

        return tail == head;
    }


    public boolean isFull() {
        return ((head+1) % maximumSize)== tail;
    }

    public void push(T element) {
        if (isFull())
           return;
        increaseHead();
        array[head] = (T)element;
    }

    @Override
    public String toString() {
       int index = 0;
       String strQueue = "";

       for (Object item : array)
          strQueue += index++ + ":" +  item + "   ";

       return strQueue;
    }

    public T pop() {
        if (isEmpty())
            return null;
        increaseTail();
        T value = (T)array[tail];
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator<T>(this);
    }

    private class QueueIterator<T> implements Iterator<T> {

        Queue<T> queue = null;

        public QueueIterator( Queue<T> queue ) {
            this.queue = queue;
        }
        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            return this.queue.pop();
        }

        @Override
        public void remove() {
            this.queue.pop();
        }
    }
}
