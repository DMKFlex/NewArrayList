public class NewArrayList<E> {
    private final int FIRSTCAPRACITY = 10;
    private Object[] array = new Object[FIRSTCAPRACITY];
    private int count = 0;

    private void newCapacity(int length) {
        Object[] newArray = new Object[length];
        System.arraycopy(array, 0, newArray, 0, count);
        array = newArray;
    }

    public void add(E item) {
        if (count == array.length - 1) {
            newCapacity(array.length * 2);
        }
        array[count++] = item;
    }

    public void remove(int index) {
        for (int i = index; i < count; i++) {
            array[i] = array[i + 1];
        }
        array[count] = null;
        count--;
        if (array.length > FIRSTCAPRACITY && count < array.length / 4) {
            newCapacity(array.length / 2);
        }
    }

    public E get(int index) {
        return (E) array[index];
    }

    public int size() {
        return count;
    }

    public void set(int index, E item) {
        array[index] = item;
    }

    public void clear(){
        count=0;
        newCapacity(FIRSTCAPRACITY);
    }

}
