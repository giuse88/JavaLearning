package sorting.algorithms;

import java.util.List;
import java.util.Random;

import sorting.interfaces.Sort;
import sorting.utils.Util;

public class QuickSort implements Sort {
	
	static final Random RND = new Random(); 
	
    <T extends Comparable<T>> int partition(List<T> list, int begin, int end ){

        int index = begin + RND.nextInt(end - begin + 1);
        T pivot = list.get(index);
        Util.swap(list, index, end);
        for (int i = index = begin; i < end; ++ i) {
            if (list.get(i).compareTo(pivot) < 0) {
                Util.swap(list, index++, i);
            }
        }
        Util.swap(list, index, end);
        return (index);
    }

   private <T extends Comparable<T>> void _quickSort( List<T> array, int first, int last) {

        if (first >= last )
            return;

        int pivot =  partition(array, first, last);
        _quickSort(array, first, pivot - 1);
        _quickSort(array, pivot + 1, last);
    }
	
	@Override
	public <T extends Comparable<T>> List<T> sort(List<T> collection) {
		_quickSort(collection, 0, collection.size() -1);
		return collection;
	}

}