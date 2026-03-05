import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Extra methods for ArrayList
 */

public class ArrayListUtils {

    /**
     * Swaps two elements in an ArrayList
     * @param list the ArrayList
     * @param index1 the place of first element
     * @param index2 the place of second element
     * @param <T> the type of elements in ArrayList
     */
    public static <T> void swap(ArrayList<T> list, int index1, int index2){
        if (list == null || list.isEmpty()){
            throw new IllegalArgumentException("ArrayList can't be null or empty");
        }

        T temp1 = list.get(index1);
        T temp2 = list.get(index2);
        list.set(index1, temp2);
        list.set(index2, temp1);
    }

    /**
     * Find maximum element in ArrayList
     * @param list ArrayList to search through
     * @return the element with the max value
     * @param <T> type that extends Comparable
     */
    public static <T extends Comparable<T>> T findMax(ArrayList<T> list){
        if (list == null || list.isEmpty()){
            throw new IllegalArgumentException("ArrayList can't be null or empty");
        }

        T currentMax = list.get(0);
        for (int i = 1; i < list.size(); i++){
            T num = list.get(i);
            if (num.compareTo(currentMax) > 0){
                currentMax = list.get(i);
            }
        }
        return currentMax;
    }

    /**
     * Filters ArrayList with a condition
     * @param list the ArrayList being filtered
     * @param condition the requirement element must meet
     * @return an ArrayList with the filtered elements
     * @param <T> type of elements
     */
    public static <T> ArrayList<T> filter(ArrayList<T> list, Predicate<T> condition){
        ArrayList<T> filteredList = new ArrayList<>();
        if (list == null){
            return filteredList;
        }

        for (T item : list){
            if (condition.test(item)){
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    /**
     * Puts the ArrayList in reverse order
     * @param list the ArrayList to reverse
     * @param <T> types of elements in ArrayList
     */
    public static <T> void reverse(ArrayList<T> list){
        if (list == null || list.isEmpty()){
            throw new IllegalArgumentException("ArrayList can't be null or empty");
        }

        int startIndex = 0;
        int endIndex = list.size() - 1;
        while (startIndex < endIndex){
            swap(list, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }

    /**
     * Merges two ArrayLists
     * @param list1 first ArrayList
     * @param list2 second ArrayList
     * @return the merged ArrayList
     * @param <T> type of elements in ArrayList
     */
    public static <T> ArrayList<T> merge(ArrayList<T> list1, ArrayList<T> list2){
        ArrayList<T> mergedList = list1;
        mergedList.addAll(list2);
        return mergedList;
    }

    /**
     * Adds the elements if they are a number
     * @param numbers the ArrayList with the numbers
     * @return the sum
     * @param <T> type that extends Number
     */
    public static <T extends Number> double sum(ArrayList<T> numbers){
        if (numbers.isEmpty() || numbers == null){
            return 0;
        }
        double sum = 0;
        for (T num : numbers){
            sum += num.doubleValue();
        }
        return sum;
    }

    /**
     * Finds the average of numbers
     * @param numbers the ArrayList with numbers
     * @return the average of the numbers
     * @param <T> type that extends Number
     */
    public static <T extends Number> double average(ArrayList<T> numbers){
        if (numbers.isEmpty() || numbers == null){
            return 0;
        }
        double avg = sum(numbers);
        return avg / numbers.size();
    }

    /**
     * Filters numbers above a requirement
     * @param numbers the ArrayList to filter
     * @param threshold the minimum
     * @param <T> type of elements
     * @return numbers that meet the requirement
     */
    public static <T extends Number & Comparable<T>> ArrayList<T> filterAbove(ArrayList<T> numbers, T threshold){
        ArrayList<T> filteredNums = new ArrayList<>();
        if (numbers.isEmpty() || numbers == null){
            return filteredNums;
        }

        for (T num : numbers){
            if (num.compareTo(threshold) > 0){
                filteredNums.add(num);
            }
        }
        return filteredNums;
    }

    //Wildcards

    /**
     * Adds all numbers together
     * @param numbers ArrayList of numbers
     * @return sum of numbers
     */
    public static double sumNumbers(ArrayList<? extends Number> numbers){
        double sum = 0;
        if (numbers.isEmpty() || numbers == null){
            return sum;
        }
        for (Number num : numbers){
            sum += num.doubleValue();
        }
        return sum;
    }

    /**
     * Adds some numbers to ArrayList
     * @param list the ArrayList getting added to
     */
    public static void addNumbers(ArrayList<? super Integer> list){
        list.add(1);
        list.add(2);
        list.add(3);
    }

    /**
     * Prints all objects in list
     * @param list list being read
     */
    public static void printList(ArrayList<?> list){
        for (Object obj : list){
            System.out.println(obj);
        }
    }
}
