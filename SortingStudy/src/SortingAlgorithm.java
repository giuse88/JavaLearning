import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: giuseppe
 * Date: 22/01/2014
 * Time: 20:04
 * To change this template use File | Settings | File Templates.
 */
class SortingAlgorithm {

    static	int iterations;
    static  final Random RND = new Random();

    static final void swap(int[] array, int pos_a, int pos_b) {
        int temp= array[pos_a];
        array[pos_a]=array[pos_b];
        array[pos_b]=temp;
    }

    // BEST CASE n
    // WORST CASE n(n-1)/2

    // this algorithm is the sorting process used by
    // a man to sort a deck of card
    static	void insertionSort( int [] array) {
        // external array specifies the key
        int key;
        iterations=0;
        for (int i=1; i < array.length; i++) {
            key= array[i];
            for(int j=i-1; j>=0 && array[j] >  key; j--){
                swap(array, j, j+1);
                iterations++;
            }
        }
    }

    // it selects the smallest element and inserts it in the correct
    // position
    static void selectionSort(int [] array) {
        int smallest;
        iterations=0;
        // WORST CASE (n)(n-1)/2
        // BEST CASE (n)(N-1)/2 ( you don't know that it is already ordered

        // the latest is already in the correct position
        for ( int i=0; i<array.length -1; i++) {
            smallest=array[i];
            for ( int j=i+1; j<array.length; j++) {
                iterations++;
                if ( array[i] < array[j])
                    swap(array, i, j);
            }
        }
    }

    static int [] merge(int [] first, int [] second) {

        if ( first == null || first.length == 0)
            return second;

        if ( second == null || second.length == 0)
            return first;

        int [] result = new int [first.length + second.length];

        // Worst case : first.length + second.length
        // best case :   first.length

        int i = 0, j=0;
        iterations = 0;

        while (i< first.length && j < second.length)
            if(first[i] < second[j]) {
                result[i+j] = first[i];
                iterations++;
                i++;
            } else {
                iterations++;
                result[i+j] = second[j];
                j++;
            }

        if( i == first.length )
            System.arraycopy(second,j, result, i+j, second.length - j);
        else
            System.arraycopy(first,i, result, i+j, first.length - i);

        return result;
    }

    static int [] mergeSort(int [] array) {
        if ( array == null || array.length <=1 )
            return array;
        iterations++;
        int middle= array.length/2;
        int [] low_part = mergeSort(Arrays.copyOfRange(array, 0, middle));
        int [] high_part = mergeSort(Arrays.copyOfRange(array,middle, array.length));

        return merge(low_part, high_part);
    }

    static	void  print( int [] array) {
        for ( int i=0; i<array.length; i++)
            System.out.print( array[i] + " " );
        System.out.println();
        System.out.println("Number of iterations : " + iterations);
    }


    static public int partition(int[] array, int begin, int end ){
        int index = begin + RND.nextInt(end - begin + 1);
        int pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++ i) {
            if (array[i] <=  pivot) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }

    static public void _quickSort( int [] array, int first, int last) {

        if (first >= last )
            return;

        int pivot =  partition(array, first, last);
        _quickSort(array, first, pivot - 1);
        _quickSort(array, pivot + 1, last);
    }

    static public void quickSort (int [] array){
        _quickSort(array, 0, array.length-1);
    }

    static public void main (String args[] ) {

        int [] unsortedArray = { 4, 8, 1, 0 , 6 };

        System.out.println("Sorting Algorithm");

        insertionSort(unsortedArray);
        print(unsortedArray);
        selectionSort(unsortedArray);
        print(unsortedArray);
        insertionSort(unsortedArray);
        print(unsortedArray);

        // worst case size  2(Smallest array ) - 1
        // the algorithm takes a number from the first array and a number from the second array
        int [] mergedArray = merge( new int[]{1,3,5}, new int[]{2,4,6,8,9,10,56,78,78,78,89});
        print(mergedArray);

        // Best case size of the first array
        // all number in the first array are smaller than the second array
        // COMPUTATION COST : size first array
        int [] mergedArray2 = merge( new int[]{1,3,5}, new int[]{6,8,9,10,56,78,78,78,89});
        print(mergedArray2);

        unsortedArray = new int[]{3,8,1,5,7,4};

        iterations=0;
        print(mergeSort(unsortedArray));

        Heap heap = new Heap(10);

        heap.print();

        try {
        heap.insert(45);
        heap.insert(23);
        heap.insert(78);
        heap.insert(79);
        heap.insert(67);
        heap.insert(32);
        heap.insert(100);
        heap.print();

        heap.remove();
        heap.print();

        heap.remove();
        heap.print();
        heap.print();

        } catch (Exception e) {
            System.out.println("Got exception : " + e);
        }

        int[] test = new int[]{3,8,4,1,5,7};
        partition(test, 0, test.length - 1);
        print(test);

        test = new int[]{3,8,4,1,5,7, 3,5, 6,7,2,1,8,1};
        quickSort(test);
        print(test);


        Stack<String> stack = new Stack(String.class, 10);

        stack.push("Hello how are you");
        stack.push("Second Sentence ");

        for (String string : stack)
            System.out.println(string);

        System.out.println("The stack is empty : " + stack.isEmpty());
        System.out.println("The stack's size is : " + stack.size());

        // int.class gets converted to int.class
        //Stack<Integer> y = new Stack(int.class, 10);


        Stack stack1 = new Stack(Integer.class, 2);

        stack1.push(2);
        stack1.push(3);

        for (Object s : stack1)
            System.out.println(s);


        Queue<String> queue = new Queue<String>(3);

        queue.push("A");
        System.out.println("Size : " + queue.size());
        queue.push("B");
        System.out.println("Size : " + queue.size());
        queue.push("C");
        System.out.println("Size : " + queue.size());
        System.out.println(queue);
        System.out.println("Size : " + queue.size());
        System.out.println(" First element : " + queue.pop());
        System.out.println(" Second element : " +  queue.pop());

        queue.push("D");
        System.out.println("Size : " + queue.size());
        System.out.println(queue);
        queue.push("E");
        System.out.println("Size : " + queue.size());
        System.out.println(queue);
        System.out.println("Is it Full?  " + queue.isFull());
        System.out.println("Size : " + queue.size());

        for ( String sentence : queue)
            System.out.println(sentence);

        System.out.println("Size : " + queue.size());
        System.out.println("Is it Empty?  " + queue.isEmpty());

        List<String> list = new List<String>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("A");
        list.add("B");

        System.out.println( "List : " + list);

        for ( String str : list)
            System.out.println(str);

        list.remove("A");
        list.remove("C");
        list.remove("D");
        list.remove("A");

        System.out.println( "List : " + list);

        list.remove("B");
        list.remove("B");

        System.out.println( "List : " + list);

        list.add("C");

        System.out.println("List : " + list);

        list.add("A");

        System.out.println( "List : " + list);


        BinaryTree<Integer> myTree = new BinaryTree<Integer>();


        for (int i=0; i<1000; i++)
            myTree.insert(RND.nextInt(10000));

        System.out.println(myTree);
        System.out.println("The smallest value : " + myTree.min());
        System.out.println("The biggest value : " + myTree.max());

       // myTree.traverseTreeUsingSuccessors();
        // myTree.traverseTreeUsingPredecessors();

        //System.out.println(myTree);

        myTree.remove(myTree.max());
        myTree.remove(myTree.min());

        System.out.println("The smallest value : " + myTree.min());
        System.out.println("Height : " + myTree.height());
        System.out.println("The biggest value : " + myTree.max());

      //  for (int i=0; i<500; i++) {
      //      myTree.remove(myTree.max());
      //      myTree.remove(myTree.min());
      //  }

        System.out.println(myTree);

        Graph graph = new Graph();


        // insert all vertex
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("z");


        graph.addEdge("a", "b", 4);
        graph.addEdge("a", "c", 2);
        graph.addEdge("c", "b", 1);
        graph.addEdge("c", "d", 8);
        graph.addEdge("b", "d", 5);
        graph.addEdge("d", "z", 6);
        graph.addEdge("d", "e", 2);
        graph.addEdge("z", "e", 3);
        graph.addEdge("c", "e", 10);

        System.out.println(graph);

        graph.traverse("a", "z");
        graph.traverse("b", "z");
        graph.traverse("e", "z");

    }

}