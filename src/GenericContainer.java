import java.util.Vector;

public class GenericContainer<T> {
    Vector<T> items = new Vector<>();

    void add(T item) {
        items.add(item);
    }

    T get(int index){
        return items.get(index);
    }

    /// checks if item exist
    boolean remove(T item){
        if (items.contains(item)){
            items.remove(item);
            return true;
        }
        return false;
    }

    int size(){
        return items.size();
    }

    void clear(){
        items.removeAllElements();
    }

    boolean contains(T item){
        return items.contains(item);
    }

    /// checks if other vector is empty before adding all elements of other vector to current vector
    void addAll(Vector<T> other){
        if (!other.isEmpty()){
            for (int i = 0; i < other.size(); i++){
                items.add(other.get(i));
            }
        }
    }

    public static void main(String[] args){
        GenericContainer<String> stringContainer = new GenericContainer<>();
        stringContainer.add("Hello");
        stringContainer.add("World");

        GenericContainer<Integer> intContainer = new GenericContainer<>();
        intContainer.add(10);
        intContainer.add(20);

        GenericContainer<Product> productContainer = new GenericContainer<>();
        productContainer.add(new Product("1234", "Good product","Goods", 10, 10, "Amazon"));

    }
}
