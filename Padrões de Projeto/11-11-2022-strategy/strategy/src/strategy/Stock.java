package strategy;

import java.util.List;
import java.util.stream.Stream;

public interface Stock<T> {
	void add(T item);

	void remove(T item);

	boolean contains(T item);
	
	List<T> getAll();
	
	Stream<T> stream();
}
