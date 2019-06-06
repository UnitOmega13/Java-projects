import java.util.ArrayList;

class Storage {
    private ArrayList<Integer> listOfKeys = new ArrayList<>();
    private ArrayList<Object> listOfValues = new ArrayList<>();

    Object get(int key) {
        if (key > listOfKeys.size() - 1) {
            System.out.println("Sorry item does not exist!`");
        }
        return listOfValues.get(key - 1);
    }


    void put(int key, Object value) {
        listOfKeys.add(key);
        listOfValues.add(value);
    }
}
