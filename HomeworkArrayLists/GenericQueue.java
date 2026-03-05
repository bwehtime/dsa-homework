import java.util.ArrayList;

/**
 * Queue using ArrayList for generics
 */

public class GenericQueue<T> {

    ArrayList<T> items;

    /**
     * Constructor
     */
    public GenericQueue(){
        this.items = new ArrayList<>();
    }

    /**
     * Adds item to back of queue
     * @param item to add
     */
    public void enqueue(T item){
        items.add(item);
    }

    /**
     * Removes first item from queue
     * @return item removed
     */
    public T dequeue(){
        T front = items.get(0);
        items.remove(front);
        return front;
    }

    /**
     * Shows first element in queue
     * @return first element
     */
    public T peek(){
        return items.get(0);
    }

    /**
     * Checks if there are any elements in queue
     * @return true if empty, false otherwise
     */
    public boolean isEmpty(){
        return items.isEmpty();
    }

    /**
     * Amount of elements in queue
     * @return size of queue
     */
    public int size(){
        return items.size();
    }
}
