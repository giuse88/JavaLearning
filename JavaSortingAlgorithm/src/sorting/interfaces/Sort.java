package sorting.interfaces;
import java.util.List;

public interface Sort  {
	public <T extends Comparable<T>>  List<T> sort(List<T> object);
}
