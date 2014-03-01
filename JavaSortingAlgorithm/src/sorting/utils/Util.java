package sorting.utils;

import java.util.List;

public class Util {

	public static final <T extends Comparable<T>> void swap(List<T> list, int pos_a, int pos_b) {
        T temp= list.get(pos_a);
        list.set(pos_a, list.get(pos_b));
        list.set(pos_b,temp);
    }
}
