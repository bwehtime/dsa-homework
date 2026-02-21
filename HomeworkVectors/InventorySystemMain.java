import java.util.Scanner;

public class InventorySystemMain {
    public static void main(String[] args){
        ProductInventory inventory = new ProductInventory();
        OrderManager manager = new OrderManager();

        Scanner sc = new Scanner(System.in);

        inventory.addProduct(new Product("P001", "Laptop", "Electronics", 999.99, 10, "TechCorp"));
        inventory.addProduct(new Product("P002", "T-Shirt", "Clothing", 19.99, 50, "FashionInc"));
        inventory.addProduct(new Product("P003", "Mouse", "Electronics", 29.99, 5, "TechCorp"));

        inventory.updateStock("P003", 10);

        Order orderOne = new Order("RO45", "Max", "2025-04-13");
        orderOne.addItem(new OrderItem("P002", "T-Shirt", 4, 19.99));
        orderOne.addItem(new OrderItem("P001", "Laptop", 1, 999.99));

        manager.addOrder(orderOne);

        //Menu
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Find Product");
        System.out.println("4. List All Products");
        System.out.println("5. Create Order");
        System.out.println("6. View Orders");
        System.out.println("7. Process Order");
        System.out.println("8. Generate Reports");
        System.out.println("9. Exit");
        System.out.println();

        while (true){

            //asks for user input
            System.out.print("Enter a number: ");
            String input = sc.next();

            //checks if input is a valid number between 1 - 9, default case 0 for invalid inputs
            int command = 0;
            try {
                command = Integer.parseInt(input);
                if (command > 10 || command < 0) {
                    command = 0;
                }
            }
            catch (Exception e){
                System.out.print("Not a number. ");
            }

            //switch for multiple input cases
            switch (command) {

                case 0:
                    //invalid input, try again
                    System.out.println("Enter a valid number");
                    System.out.println();
                    break;
                case 1:
                    //add product, asks for product info
                    System.out.print("Product ID: ");
                    String id = sc.next();

                    System.out.print("Product Name: ");
                    String name = sc.next();

                    System.out.print("Category: ");
                    String category = sc.next();

                    System.out.print("Price: ");
                    String priceInput = sc.next();

                    //checks if price is a double, if not, statement doesn't continue and returns back to menu
                    double price;
                    try {
                        price = Double.parseDouble(priceInput);
                    } catch (Exception e) {
                        System.out.println("Not a valid price");
                        break;
                    }

                    System.out.print("Quantity: ");
                    String quantityInput = sc.next();

                    //checks if quantity is a valid int
                    int quantity;
                    try {
                        quantity = Integer.parseInt(quantityInput);
                    } catch (Exception e) {
                        System.out.println("Not a valid quantity");
                        break;
                    }

                    System.out.print("Supplier: ");
                    String supplier = sc.next();

                    //Constructor is created for the product and added to inventory
                    inventory.addProduct(new Product(id, name, category, price, quantity, supplier));
                    System.out.println("Product Added");
                    System.out.println();
                    break;
                case 2:
                    //remove product, asks for ID
                    System.out.print("Enter ID of product to remove: ");

                    /*checks if removeProduct is true or false
                    if true, confirms that the product as been removed
                    if false, product does not exist in the inventory
                     */
                    if (inventory.removeProduct(sc.next())) {
                        System.out.println("Product removed");
                    }
                    else {
                        System.out.println("Product not found");
                    }
                    System.out.println();
                    break;
                case 3:
                    //find product by ID
                    System.out.print("Enter ID of product to find: ");
                    Product wantedProduct = inventory.findProduct(sc.next());

                    /*checks if the product exists in inventory
                    if not, tells user product does not exist
                    if true, prints out the wanted product
                     */
                    if (wantedProduct == null) {
                        System.out.println("Product not found");
                    }
                    else {
                        System.out.println(wantedProduct);
                        }
                    System.out.println();
                    break;
                case 4:
                    //Prints out amount of products and list of products
                    System.out.println("Amount of products available: " + inventory.getTotalProducts());
                    inventory.printAllProducts();
                    System.out.println();
                    break;
                case 5:
                    //Create an order, asks the user for order information
                    System.out.println("Create an Order");
                    System.out.print("Order ID: ");
                    String orderID = sc.next();

                    System.out.print("Customer Name: ");
                    String customerName = sc.next();

                    System.out.print("Order Date (YYYY-MM-DD): ");
                    String orderDate = sc.next();

                    Order customerOrder = new Order(orderID, customerName, orderDate);

                    //Asks for which products wanted for order items
                    System.out.println("Which items do you want to add? (Use Product ID)");
                    System.out.println("Enter 'Done' when done");
                    String userInput = sc.next();

                    //A loop for the user to add as many items as they want to the order, loop ends when user enters Done.
                    while (!userInput.equals("Done")) {
                        //Check is the product is available in the inventory
                        Product orderProduct = inventory.findProduct(userInput);

                        //Product does not exist and will ask user for a different input
                        if (orderProduct == null) {
                            System.out.println("Product does not exist. Enter a different ID.");
                        }
                        //Asks for quantity wanted if ID does exist
                        else {
                            System.out.print("How much do you want? ");
                            String quantityWantedInput = sc.next();

                            //Checks if input is a valid int, if not, doesn't initialize new item
                            int quantityWanted;
                            try {
                                quantityWanted = Integer.parseInt(quantityWantedInput);
                                customerOrder.addItem(new OrderItem(orderProduct.getProductId(), orderProduct.getName(), quantityWanted, orderProduct.getPrice()));
                            }
                            catch (Exception e){
                                System.out.println("Not a valid quantity");
                                System.out.println();
                            }
                        }

                        //asks for user input again for the loop
                        System.out.println("What other item would you like to add?");
                        userInput = sc.next();
                    }

                    //Updates order status to pending
                    customerOrder.updateStatus("Pending");

                    //Adds order to the manager
                    manager.addOrder(customerOrder);
                    System.out.println("Order Registered. Now Pending.");
                    System.out.println();
                    break;
                case 6:
                    //Prints the orders in the manager
                    manager.printAllOrders();
                    System.out.println();
                    break;
                case 7:
                    //Asks for order ID
                    System.out.println("Which order do you want to process? (Enter Order ID)");
                    String processOrderID = sc.next();

                    //Checks if input is a valid ID, if yes, order status updates to processing
                    Order processOrder = manager.findOrder(processOrderID);
                    if (processOrder == null) {
                        System.out.println("Order not found");
                    } else {
                        processOrder.updateStatus("Processing");
                        System.out.println("Order processing");
                    }
                    System.out.println();
                    break;
                case 8:
                    //Prints capacity report of inventory
                    inventory.printCapacityReport();
                    System.out.println();
                    break;
                case 9:
                    //Finishes the program
                    return;
            }
        }

    }
}
