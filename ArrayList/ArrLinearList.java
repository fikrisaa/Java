package array;

public class ArrLinearList {

	protected Object[] element;
	protected int size;

	public ArrLinearList(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException("inntialCapacity must be >= 1");
		element = new Object[initialCapacity];
	}

	public ArrLinearList() {
		this(10);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index = " + index + " size = "
					+ size);
	}

	public Object get(int index) {
		checkIndex(index);
		return element[index];
	}

	public int indexOf(Object theElement) {
		// search element[] for theElement
		for (int i = 0; i < size; i++)
			if (element[i].equals(theElement))
				return i;
		// theElement not found
		return -1;
	}

	public Object remove(int index) {
		checkIndex(index);
		// valid index, shift elements with higher index
		Object removedElement = element[index];
		for (int i = index + 1; i < size; i++)
			element[i - 1] = element[i];
		element[--size] = null; // enable garbage collection
		return removedElement;
	}

	public void add(int index, Object obj) {
		if (index < 0 || index > size)
			// invalid list position
			throw new IndexOutOfBoundsException("index = " + index + " size = "
					+ size);
		// valid index, make sure we have space
		if (size == element.length) { // no space, double capacity
			Object[] newArr = new Object[2 * size];
			System.arraycopy(element, 0, newArr, 0, size);
			element = newArr;
		}
		// shift elements right one position
		for (int i = size - 1; i >= index; i--)
			element[i + 1] = element[i];
		element[index] = obj;
		size++;
	}
}