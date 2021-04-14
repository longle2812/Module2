import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        this.size = capacity;
        elements = new Object[this.size];
    }

    public void add(int index, E element) {
        if (elements[elements.length - 1] != null || index == elements.length) {
            this.size++;
        }
        Object[] newElements = new Object[this.size];
        for (int i = 0; i < index; i++) {
            newElements[i] = elements[i];
        }
        newElements[index] = element;
        for (int i = index + 1; i < this.size - 1; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    public E remove(int index) {
        E temp = (E) elements[index];
        Object[] newElements = new Object[this.size - 1];
        for (int i = 0; i < index; i++) {
            newElements[i] = elements[i];
        }
        for (int i = index + 1; i < elements.length; i++) {
            newElements[i - 1] = elements[i];
        }
        elements = newElements;
        return temp;
    }

    public int indexOf(E o) {
        int result = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(o)) {
                result = i;
            }
        }
        return result;
    }

    public int size() {
        return this.size;
    }

    public Object clone() {
        return elements;
    }

    public boolean contains(E o) {
        boolean check = false;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(o)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean add(E e) {
        return true;
    }

    public E get(int i) {
        return (E) elements[i];
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
    }


    @Override
    public String toString() {
        return "MyList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
