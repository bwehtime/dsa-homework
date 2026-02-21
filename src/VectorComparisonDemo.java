import java.util.ArrayList;
import java.util.Vector;


public class VectorComparisonDemo {

    public static void main(String[] args) {

        Vector<Product> productsV = new Vector<>();
        ArrayList<Product> productsA = new ArrayList<>();
        Runtime rt = Runtime.getRuntime();

        /// Records memory
        long startMemoryV = rt.freeMemory();

        /// Records time
        double startTimeVAdd = System.nanoTime();

        for (int i = 0; i < 10000; i++){
            productsV.add(new Product("1234", "Good product","Goods", 10, 10, "Amazon") );
        }

        double endTimeVAdd = System.nanoTime();
        /// Subtracts endtime by start time to figure out how long the process took
        double timeVAdd = endTimeVAdd - startTimeVAdd;

        System.out.println("Time to add 10000 elements to Vector: " + timeVAdd);

        double startTimeVGet = System.nanoTime();
        for (int i = 0; i < 1000; i++){
            productsV.get((int) (Math.random() * productsV.size()));
        }
        double endTimeVGet = System.nanoTime();
        double timeVGet = endTimeVGet - startTimeVGet;

        /// memory usage at the end
        long endMemoryV = rt.freeMemory();
        long memoryUsageV = endMemoryV - startMemoryV;

        System.out.println("Time to get 1000 elements in Vector: " + timeVGet);
        System.out.println("Vector memory usage: " + memoryUsageV);


        System.out.println();


        /// new variables to record the differences for ArrayList
        long startMemoryA = rt.freeMemory();
        double startTimeAAdd = System.nanoTime();

        for (int i = 0; i < 10000; i++){
            productsA.add(new Product("1234", "Good product","Goods", 10, 10, "Amazon") );
        }

        double endTimeAAdd = System.nanoTime();
        long endMemoryA = rt.freeMemory();

        double timeAAdd = endTimeAAdd - startTimeAAdd;
        System.out.println("Time to add 10000 elements to ArrayList: " + timeAAdd);

        double startTimeAGet = System.nanoTime();

        for (int i = 0; i < 1000; i++){
            productsA.get((int) (Math.random() * productsA.size()));
        }

        double endTimeAGet = System.nanoTime();
        double timeAGet = endTimeAGet - startTimeAGet;

        long memoryUsageA = endMemoryA - startMemoryA;

        System.out.println("Time to get 1000 elements in ArrayList: " + timeAGet);
        System.out.println("ArrayList memory usage: " + memoryUsageA);

        System.out.println();

        /// Comparision checks
        if (timeAAdd > timeVAdd){
            System.out.println("Vector is faster by: " + (timeAAdd - timeVAdd));
        } else if (timeAAdd < timeVAdd) {
            System.out.println("ArrayList is faster by: " + (timeVAdd - timeAAdd));
        }
        else{
            System.out.println("Same speed");
        }

        if (timeAGet > timeVGet){
            System.out.println("Vector is faster by: " + (timeAGet - timeVGet));
        }
        else if (timeAGet < timeVGet) {
            System.out.println("ArrayList is faster by: " + (timeVGet - timeAGet));
        }
        else{
            System.out.println("Same speed");
        }

        if (memoryUsageA < memoryUsageV){
            System.out.println("ArrayList uses " + (memoryUsageV - memoryUsageA) + " less memory");
        }
        else if (memoryUsageV < memoryUsageA){
            System.out.println("Vector uses " + (memoryUsageA - memoryUsageV) + " less memory");
        }
        else {
            System.out.println("Same amount of memory usage");
        }

        /// ArrayList performed better than Vector in every aspect.
        ///Vectors are better for thread safety and for legacy codes that use Vector.
        ///ArrayLists are better most of the time as it is cleaner, more modern and has dynamic sizing, allowing better usages.
        ///Additionally, ArrayList is faster and more memory efficient than Vector.


    }
}
