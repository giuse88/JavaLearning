package sorting.old;
/**
 * Created with IntelliJ IDEA.
 * User: giuseppe
 * Date: 25/01/2014
 * Time: 15:09
 * To change this template use File | Settings | File Templates.
 */
public class Heap {

    int [] heap =null;
    int elements=0;

    private static final int ROOT = 0;

    public Heap(int maximumSize ){
        heap = new int[maximumSize];
    }

    public boolean insert(int newValue){
        // put the node in the farthest left position available in order to keep the
        // property of complete tree
        if (heap.length == elements)
           return false;
        heap[elements] = newValue;
        // keep the heap property
        trickleUp(elements);
        elements++;
        return true;
    }


    public int remove() throws Exception{

        if(elements == 0)
            throw new Exception("The heap is empty");

        int root = heap[ROOT];
        elements--;
        // remove the element located at the most left of the tree in the root
        // in order to keep the complete tree property
        heap[ROOT] = heap[elements];
        trickleDown();
        return root;
    }

    // ensures the he
    private void trickleUp( int node) {
        int parent = parent(node);
        while ( heap[parent] < heap[node])   {
            swap(parent, node);
            node = parent;
            parent = parent(parent);
        }
    }

    // ensures the heap property starting from the root
    private void trickleDown() {
        // this always starts from the root
        int root = ROOT, bigger= root;
        int leftChild  =0;
        int rightChild =0;

        while (!isLeaf(root)) {

            leftChild  =  root*2 +1;
            rightChild =  leftChild + 1;
            bigger = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;

            if( heap[bigger] > heap[root])
                swap(root, bigger);
            else
                break;

            root = bigger;
        }

    }

    private boolean isLeaf(int root) {
        return root * 2 + 1 > elements && root * 2 + 2 > elements;
    }

    public void print() {
        for ( int i = 0; i < elements; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    private final int parent(int child) {
        if ( child <= 0 )
            return ROOT;
        return (child-1)/2;
    }

    private final void swap(int first, int second){
        System.out.println("Swapping : " + first + " " + second);
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

}
