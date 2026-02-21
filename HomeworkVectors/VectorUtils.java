import java.util.Vector;
import java.util.function.Predicate;

public class VectorUtils {

    /// created two temp variables for less confusion
    /// sets each index with the corresponding variables
    public static <T> void swap(Vector<T> vec, int index1, int index2){
        T temp1 = vec.get(index1);
        T temp2 = vec.get(index2);
        vec.set(index1, temp2);
        vec.set(index2, temp1);
    }

    /// if vector is empty, max does not exist, return null
    /// otherwise, the first element is set as the max by default
    /// if the vector has a size greater than 1, goes through a loop
    public static <T extends Comparable<T>> T findMax(Vector<T> vec){
        if (vec.isEmpty()){
            return null;
        }
        T maxItem = vec.get(0);
        if (vec.size() != 1){
            for (int i = 1; i < vec.size(); i++){
                if (vec.get(i).compareTo(maxItem) > 0){
                    maxItem = vec.get(i);
                }
            }
        }
        return maxItem;
    }

    /// checks if empty vector and returns count of 0 if empty
    /// then loops through the vector
    public static <T> int countMatches(Vector<T> vec, T target){
        int count = 0;
        if (vec.isEmpty()){
            return count;
        }
        for (T item : vec){
            if (item.equals(target)){
                count++;
            }
        }
        return count;
    }

    /// create a new vector for the filtered items
    /// checks if vector is empty and returns empty vector if yes
    /// then loops through vector to see if conditions match
    public static <T> Vector<T> filter(Vector<T> vec, Predicate<T> condition){
        Vector<T> filteredItems = new Vector<>();
        if (vec.isEmpty()){
            return filteredItems;
        }

        for (T item : vec){
            if(condition.test(item)){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    /// checks for empty vector before looping
    public static <T extends Number> double sumNumbers(Vector<T> numbers){
        double sum = 0;
        if (numbers.isEmpty()){
            return sum;
        }
        for (T number : numbers){
            sum += number.doubleValue();
        }
        return sum;
    }

    /// uses sumNumbers method and divide by size for average
    public static <T extends Number> double averageNumbers(Vector<T> numbers){
        double avg = sumNumbers(numbers) / numbers.size();
        return avg;
    }

    void main(String[] args) {
        Vector<Integer> ints = new Vector<>();
        ints.add(10);
        ints.add(20);
        ints.add(30);
        System.out.println("Sum: " + VectorUtils.sumNumbers(ints));  // 60.0
        System.out.println("Average: " + VectorUtils.averageNumbers(ints));  // 20.0
    }
}
