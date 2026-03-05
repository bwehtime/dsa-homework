import java.util.ArrayList;

/**
 * A stack for generics
 */

public class GenericStack<T>{

    ArrayList<T> items;

    /**
     * Constructor
     */
    public GenericStack(){
        this.items = new ArrayList<>();
    }

    /**
     * Pushes item to top of stack
     * @param item for item to push
     */
    public void push(T item){
        items.add(item);
    }

    /**
     * Removes and returns top item from stack
     * @return removed T type
     */
    public T pop(){
        T top = items.get(items.size() - 1);
        items.remove(top);
        return top;
    }

    /**
     * Shows item on top of stack
     * @return T in front of ArrayList
     */
    public T peek(){
        return items.get(items.size() - 1);
    }

    /**
     * Checks if ArrayList is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty(){
        return items.isEmpty();
    }

    /**
     * Removes all elements from ArrayList
     */
    public void clear(){
        items.clear();
    }

}
