Brief descriptions of each class:
  Product class creates a Product object with basic getters and setters along with an equals() method to compare Product objects.
  ProductInventory stores the Product objects and provides methods to manage multiple Product objects.
  The Order class creates an Order object that stores customer data and contains a vector for OrderItems; it manages OrderItems.
  The OrderItem class creates an OrderItem object that has getters and setters with the item's information.
  The OrderManager class stores Order objects and contains methods that help manage and sort multiple Order objects.

  The VectorUtils class contains extra methods that could help with searching through Vectors.
  The VectorComparisonDemo compares the efficiency of a Vector to an ArrayList.
  The GenericContainer class stores a vector of T types that can be anything and holds methods for that vector.

How to compile and run your program:
  Run the InventorySystemMain.java and it should give a menu of options you can do. You can add, remove, and view products and orders.

Any assumptions you made:
  Certain information wasn't given like order status so I assumed that a newly created order would be "Pending".
  I didn't really know what 'reports' for step 5 meant so I just printed out the capacity report for ProductInvetory.
  I didn't know where OrderItem fit in for this since step 5 didn't mention it so I created an option to add new OrderItems to the Order as long as it was in the ProductInventory.
  The toString() methods didn't give me an idea for how the information should look so I did my best to show all the information contained.

Challenges you encountered:
  I used == on a String and realized my mistake after it returned false or null everytime.
  Sometimes, I had to look up methods or classes I didn't know.
  For the menu system, I had to figure out what to do if the input wasn't valid. I figured out that I could use a String and check if it was valid with parse methods. Then, I had to figure out what happened if it didn't work. I decided to use try and catch exceptions.
  Proof checking for every case took a lot of time.

What you learned about Vectors and generics:
  Vectors are easy to use for simple things like lists of objects. Vectors are thread-safe. I also learned why Vectors are unused and ArrayLists are preferred. ArrayLists are simply better most of the time because of its more modern, faster, and memory efficient.
  Generics are handy for when you might want to reuse a method for any data type. It can help catch errors at compile time rather than runtime.
