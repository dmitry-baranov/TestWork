
public class MyList<T>{
    private Object[] array = new Object[255];
    private int indexArr = 0;

    public void add(T line) {
        array[indexArr] = line;
        indexArr++;
        if (indexArr == (array.length - 1)) {
            extendArr();
        }
    }

    public int length() {
        return this.array.length;
    }
    public T get(int index) {
        return (T) array[index];
    }

    public void set(int index, T line) {
        this.array[index] = line;
    }

    private void extendArr() {
        Object[] array= new Object[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++) {
            array[i] = this.array[i];
        }
        this.array = array;
    }

    public boolean contains(T element) {
        for (Object e : this.array) {
            if (e != null && e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public T[] toArray() {
        return (T[]) array;
    }
}
