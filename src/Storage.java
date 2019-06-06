import java.util.Arrays;
import java.util.Objects;

class Storage<T> implements List<T> {
    private T[] value;

    Storage(){
        this.value = (T[]) new Objects[0];
    }

    private T removeArrayElement(int index) {
        try {
            T[] temp = (T[]) new Object[value.length - 1];
            System.arraycopy(value, 0, temp, 0, index);
            System.arraycopy(value, index + 1, temp, index, value.length - index - 1);
            value = temp;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Do not have new index for operation");
        }
        return (T) value;
    }

    @Override
    public void add(T valueOfElement) {
        T[] tempArrayForValues = (T[]) value;
        value = (T[]) new Object[tempArrayForValues.length + 1];
        System.arraycopy(tempArrayForValues, 0, value, 0, tempArrayForValues.length);
        value[value.length - 1] = valueOfElement;
    }

    @Override
    public void add(T valueOfElement, int index) {
        T[] tempArrayForValues = (T[]) value;
        try {
            value = (T[]) new Object[tempArrayForValues.length + 1];
            System.arraycopy(tempArrayForValues, 0, value, 0, index);
            value[index] = valueOfElement;
            System.arraycopy(tempArrayForValues, index, value, index + 1, tempArrayForValues.length - index);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error, wrong index of element");
            value = tempArrayForValues;
        }
    }

    @Override
    public void addAll(List<T> list) {
        try {
            for (int i = 0; i < list.size(); i++) {
                add(list.get(i));
            }
        } catch (NullPointerException e) {
            System.out.println("List is null!");
        }
    }

    @Override
    public T get(int index) {
        try {
            return value[index];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index is out of bound!");
            return null;
        }
    }

    @Override
    public void set(T valueOfElement, int index) {
        try {
            value[index] = valueOfElement;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error, wrong index of element");
        }
    }

    @Override
    public T remove(int index) {
        return removeArrayElement(index);
    }

    @Override
    public T remove(T t) {
        for (int i = 0; i < value.length; i++){
            if (value[i] == t){
                return removeArrayElement(i);
            }
        }
        System.out.println("Element does not exist in Array");
        return null;
    }

    @Override
    public int size() {
        return value.length;
    }

    @Override
    public boolean isEmpty() {
        return value.length == 0;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
