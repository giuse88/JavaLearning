package sorting.old;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: giuseppe
 * Date: 04/02/2014
 * Time: 20:38
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTree <T extends Comparable<T>>  {

    private Node root = null;

    public void insert(T item){
        Node<T> newNode = new Node<T>(item);
        insertTree(newNode);
    }


    private void insertTree(Node<T> newNode){

        Node current = root;
        Node previous = null;

        if ( root == null){
            root = newNode;
            return;
        }

        while( current != null) {
            previous = current;
            if ( current.getItem().compareTo(newNode.getItem()) <= 0 )
                current = current.getRight();
            else
                current = current.getLeft();
        }

        if ( previous.getItem().compareTo(newNode.getItem()) <= 0)
            previous.setRight(newNode);
        else
            previous.setLeft(newNode);

        newNode.setParent(previous);
    }

    public T max(){
        Node<T> locale = maxNode(this.root);
        if (locale == null) return null;
        return locale.getItem();
    }

    private Node<T> maxNode(Node<T> root) {
        if ( root == null)
            return null;
        Node<T> locale = root;
        while ( locale.getRight() != null)
            locale=locale.getRight();
        return locale;
    }


    private Node<T> find(T value, Node<T> root) {

        if ( root == null || value == null)
            return  null;
        if( value.compareTo(root.getItem())  < 0 )
            return find(value, root.getLeft());
        else if (value.compareTo(root.getItem()) > 0)
            return find(value, root.getRight());
        else
            return root;
    }

    private final boolean isLeaf(Node<T> node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    private final boolean hasBothChildren(Node<T> node) {
        return node.getLeft() != null && node.getRight() != null;
    }

    private final boolean onlyChild(Node<T> node) {
       return (node.getRight() != null && node.getLeft() == null) ||
              (node.getRight() == null && node.getLeft() != null);
    }
    public void remove(T value) {

        Node<T> nodeToBeRemoved = find(value, root);


        if(nodeToBeRemoved == null)
            return ;

        if (hasBothChildren(nodeToBeRemoved)) {
            // find the successor
            Node<T> successor = successor(nodeToBeRemoved);
            // copy the value into the successor
            nodeToBeRemoved.setItem(successor.getItem());
            // the successor will be in one of the previous conditions
            nodeToBeRemoved = successor;
            System.out.println("Both : " + nodeToBeRemoved.getItem());
        }

        if (isLeaf(nodeToBeRemoved)){
            System.out.println("Leaf :" + nodeToBeRemoved.getItem());
            Node<T> parent = nodeToBeRemoved.getParent();
            System.out.println("p : " + parent.getLeft() + parent.getRight() + parent.getItem());
            if(parent.getLeft() == nodeToBeRemoved)
                parent.setLeft(null);
            else
                parent.setRight(null);
            return;
        }

       if(onlyChild(nodeToBeRemoved)){
           System.out.println("Some :" + nodeToBeRemoved.getItem());
            Node<T> parent = nodeToBeRemoved.getParent();
            Node<T> child  = nodeToBeRemoved.getLeft() == null ?  nodeToBeRemoved.getRight(): nodeToBeRemoved.getLeft();
            if(parent.getLeft() == nodeToBeRemoved)
                parent.setLeft(child);
            else
                parent.setRight(child);
            return;
       }

        return;
    }

    private Node minNode(Node<T> root ){
        if (null == root)
            return null;
        Node<T> locale = root;
        while ( locale.getLeft() != null)
            locale=locale.getLeft();
        return locale;
    }

    public T min(){
        Node<T> min  = this.minNode(root);
        return min == null ? null : min.getItem();
    }

    private Node<T> successor(Node<T> root) {
       if (root == null)
           return null;

       if (root.getRight() != null)
          return minNode(root.getRight());

       Node<T> parent = root.getParent();
       Node<T> child = root;

       while(parent != null && child != parent.getLeft()){
           child = parent;
           parent= parent.getParent();
       }

       return parent;
    }


    public int height(){
        Node<T> locale = minNode(root);

        if(locale == null)
            return 0;

        int height = 0;
        while(locale != null){
            locale = locale.getParent();
            height++;
        }

        return height;
    }

    private Node<T> predecessor(Node<T> root) {

        if(root == null)
            return null;

        if ( root.getLeft() != null)
            return maxNode(root.getLeft());

        Node<T> parent = root.getParent();
        Node<T> child = root;

        // first right child going up :D
        while(parent != null && child != parent.getRight()) {
            child = parent;
            parent = parent.getParent();
        }

        return parent;
    }

    private void traverseTree ( Node<T> root,   List<T> values) {
        if (root == null)
           return;

        traverseTree(root.getLeft(), values);
        values.add(root.getItem());
        traverseTree(root.getRight(), values);
    }

    public void traverseTreeUsingSuccessors() {
        Node<T> successor = minNode(this.root);
        while ( successor != null) {
            System.out.print(successor.getItem() + " ");
            successor = successor(successor);
        }
        System.out.println();
    }

    public void traverseTreeUsingPredecessors() {
        Node<T> predecessor = maxNode(root);
        while ( predecessor != null) {
            System.out.print(predecessor.getItem() + " ");
            predecessor = predecessor(predecessor);
        }
        System.out.println();
    }

    @Override
    public String toString(){
        List<T> values = new ArrayList<T>();
        traverseTree(root, values);
        return values.toString();
    }

    private class Node<T extends  Comparable<T>> {

        private  T item;
        private Node left=null;
        private Node right=null;
        private Node parent=null;

        public Node(T item){
            this.item = item;
        }

        public void setItem(T value) {
            this.item = value;
        }
        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node<T> getParent(){
            return this.parent;
        }

        public void setLeft(Node l) {
            this.left = l;
        }

        public void setRight(Node r) {
            this.right = r;
        }

        public Node<T> getLeft() {
           return this.left;
        }

        public Node<T> getRight() {
            return this.right;
        }

        public T getItem() {
           return item;
        }
    }
}
