import java.util.Arrays;
import java.util.Objects;

class ArrayListForTaskStorage<T> implements ListForTask<T> {
    private static final int START_SIZE = 10;
    private T[] values;

    ArrayListForTaskStorage() {
        this.values = (T[]) new Objects[START_SIZE];
    }

    private T removeArrayElement(int index) {
        try {
            T[] tempArrayList = (T[]) new Object[values.length - 1];
            System.arraycopy(values, 0, tempArrayList, 0, index);
            System.arraycopy(values, index + 1, tempArrayList, index, values.length - index - 1);
            values = tempArrayList;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Do not have this index");
        }
        return values[index];
    }

    @Override
    public void add(T valueOfElement) {
        T[] tempArrayForValues = (T[]) values;
        values = (T[]) new Object[tempArrayForValues.length + tempArrayForValues.length >> 1];
        System.arraycopy(tempArrayForValues, 0, values, 0, tempArrayForValues.length);
        values[values.length - 1] = valueOfElement;
    }

    @Override
    public void add(T valueOfElement, int index) {
        T[] tempArrayForValues = (T[]) values;
        try {
            values = (T[]) new Object[tempArrayForValues.length + tempArrayForValues.length >> 1];
            System.arraycopy(tempArrayForValues, 0, values, 0, index);
            values[index] = valueOfElement;
            System.arraycopy(tempArrayForValues, index, values, index + 1, tempArrayForValues.length - index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error, wrong index of element");
            values = tempArrayForValues;
        }
    }

    @Override
    public void addAll(ListForTask<T> listForTask) {
        try {
            for (int i = 0; i < listForTask.size(); i++) {
                add(listForTask.get(i));
            }
        } catch (NullPointerException e) {
            System.out.println("ListForTask is null!");
        }
    }

    @Override
    public T get(int index) {
        try {
            return values[index];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index is out of bound!");
            return null;
        }
    }

    @Override
    public void set(T valueOfElement, int index) {
        try {
            values[index] = valueOfElement;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error, wrong index of element");
        }
    }

    @Override
    public T remove(int index) {
        return removeArrayElement(index);
    }

    @Override
    public T remove(T t) {
        try {
            if (t instanceof String) {
                T[] tempArrayForValues = (T[]) values;
                values = (T[]) new Object[tempArrayForValues.length + tempArrayForValues.length >> 1];
                for (int index = 0; index <= values.length; index++) {
                    if (t.equals(values[index])) {
                        return removeArrayElement(index);
                    }
                }
                values = tempArrayForValues;
            }
            for (int i = 0; i < values.length; i++) {
                if (values[i] == t) {
                    return removeArrayElement(i);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Element does not exist in Array");
        }
        return t;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean isEmpty() {
        return values.length == 0;
    }

    @Override
    public String toString() {
        return "ArrayListForTaskStorage{" +
                "value=" + Arrays.toString(values) +
                '}';
    }
}
