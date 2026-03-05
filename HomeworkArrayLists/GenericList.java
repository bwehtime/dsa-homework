import java.util.ArrayList;

/**
 * List for generics
 */

public class GenericList<T> {

    ArrayList<T> items;

    /**
     * Constructor
     */
    public GenericList(){
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item
     * @param item to add to list
     */
    public void add(T item){
        items.add(item);
    }

    /**
     * Gets element at index
     * @param index to find where element is
     * @return element
     */
    public T get(int index){
        return items.get(index);
    }

    /**
     * Removes an element
     * @param item element want removed
     * @return true if removed, false otherwise
     */
    public boolean remove(T item){
        return items.remove(item);
    }

    /**
     * Amount of elements in list
     * @return size of list
     */
    public int size(){
        return items.size();
    }

    /**
     * Checks if list is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty(){
        return items.isEmpty();
    }

    /**
     * removes all elements in list
     */
    public void clear(){
        items.clear();
    }

    /**
     * Checks if list has items
     * @param item to check for
     * @return true if in list, otherwise false
     */
    public boolean contains(T item){
        return items.contains(item);
    }

    /**
     * Returns the ArrayList
     */
    public ArrayList<T> getAll(){
        return items;
    }

    /**
     * Adds all elements from another ArrayList to this one
     * @param other the ArrayList wanted
     */

    public void addAll(ArrayList<T> other){
        items.addAll(other);
    }

    public <U extends T> void addAllFrom(GenericList<U> other){
        items.addAll(other.getAll());
    }

    static void main(String[] args){
        GenericList<String> strings = new GenericList<>();
        strings.add("Hello");

        GenericList<Integer> numbers = new GenericList<>();
        numbers.add(42);

        GenericList<Student> students = new GenericList<>();
        students.add(new Student());

    }

}
