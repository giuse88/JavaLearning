package sorting.old;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * User: giuseppe
 * Date: 01/02/2014
 * Time: 18:37
 * To change this template use File | Settings | File Templates.
 */

public class List<T extends Comparable<T>> implements Iterable<T> {

    public static final String EMPTY_LIST = "Empty List";
    Node<T> root = null;
    Integer nItems = 0;

    List(){}

    void add(T value ) {

        if(value == null)
            return;

      Node<T> newNode = new Node<T>(value);
      this.insertNode(newNode);
    }

    private void insertNode(Node<T>  newNode) {
        Node<T> current = this.root;
        Node<T> prev = null;

        if (isEmpty()){
           this.root = newNode;
            nItems++;
           return;
        }

        /*
        we must use current != null because this value
        is then assigned to the next pointer in node.
        if we don't use current we'll miss the last position
        */
        while ( current != null && current.item.compareTo(newNode.item) <= 0){
            prev = current;
            current = current.getNext();
        }

        // Insert in the root
        if(current == root) {
           newNode.next = root;
           root = newNode;
        } else {
            prev.next = newNode;
            newNode.next = current;
        }
        nItems++;
    }

    public T get (int index) {

        if ( index < 0)
            return null;

        Node<T> locale = this.root;

        for (int i=0; i< index && locale != null; i++, locale = locale.getNext());

        return locale == null ? null : locale.item;
    }

    public void remove(T item) {

       if (isEmpty())
            return;

       Node<T> current = this.root;
       Node<T> previous = null;

       while ( current != null && current.item.compareTo(item) != 0 ) {
           previous = current;
           current = current.getNext();
       }

       if (current == root) {
           removeRoot();
           nItems--;
           return;
       }

       if ( current != null) {
            previous.next = current.getNext();
            nItems--;
            return;
       }

        // Element not found
    }

    private void removeRoot() {
       root = root.next;
    }

    public int size(){
        return nItems;
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public String toString() {

        if (isEmpty())
            return EMPTY_LIST;

        Node<T> locale = this.root;
        int index=0;
        String strList="";

        while(locale != null ) {
            strList += index + ": " + locale.item + "    ";
            index++;
            locale = locale.getNext();
        }


        return strList;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(this);
    }

    private class Node<T> {

        Node<T>  next = null;
        T item = null;

        Node(T item){
          this.item = item;
        }

        Node(T item, Node<T> node) {
            this.item = item;
            this.next = node;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }

        public Node<T> getNext() {
            return this.next;
        }

        @Override
        public String toString() {
            // recursive :D
            return item + ":" + next + " ";
        }
    }

    private class ListIterator<T extends Comparable<T>> implements Iterator<T> {

        List<T> list = null;
        int index = 0;

        ListIterator(List<T> list) {
            this.list = list;
        }
        @Override
        public boolean hasNext() {
            return  index != list.size();
        }

        @Override
        public T next() {
            return this.list.get(index++);
        }

        @Override
        public void remove() {
        }
    }
}
