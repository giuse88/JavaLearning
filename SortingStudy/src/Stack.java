import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: giuseppe
 * Date: 29/01/2014
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */

public class Stack<T> implements Iterable<T>{

    private int top=-1;
    private T[] array = null;
    private int maximumSize =0;

    public Stack(Class<T> tClass, int size) {
        maximumSize = size;
        this.array = (T[])java.lang.reflect.Array.newInstance(tClass,maximumSize);
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top >= maximumSize;
    }

    public void push(T value){
        array[++top] = value;
    }

    public T pop(){
        return array[top--];
    }

    public int size() {
        return top + 1;
    }
    @Override
    public Iterator<T> iterator() {
        return new StackIterator<T>(this);
    }

    public class StackIterator<T> implements Iterator<T> {

    Stack<T> stack= null;

    StackIterator(Stack all){
       this.stack = all;
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        return stack.pop();
    }

    @Override
    public void remove() {
        stack.pop();
    }

    }
}
