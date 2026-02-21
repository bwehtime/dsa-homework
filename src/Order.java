import java.util.Vector;

public class Order {
    String orderId;
    String customerName;
    String orderDate;

    Vector<OrderItem> items = new Vector<>();
    String orderStatus;

    public Order(String orderId, String customerName, String orderDate){
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;

        ///Sets status to pending when an order has been created
        this.orderStatus = "Pending";
    }

    String getOrderId(){
        return this.orderId;
    }

    String getCustomerName(){
        return this.customerName;
    }

    String getOrderDate(){
        return this.orderDate;
    }

    String getOrderStatus(){
        return this.orderStatus;
    }

    void setOrderId(String orderId){
        this.orderId = orderId;
    }

    void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }

    void addItem(OrderItem item){
        items.add(item);
    }

    ///uses findItem method to check if item exists
    boolean removeItem(String productId){
        OrderItem itemToRemove = findItem(productId);
        if (itemToRemove != null){
            items.remove(itemToRemove);
            return true;
        }
        return false;
    }

    ///checks if the vector is empty before searching through the entire vector for the item
    OrderItem findItem(String productId){
        if (items.isEmpty()){
            return null;
        }
        for (OrderItem item: items){
            if (item.getProductId().equals(productId)){
                return item;
            }
        }
        return null;
    }

    /// itemValue is automatically 0 as a base.
    /// checks if vector is empty or only has one item to return faster
    /// before going through the entire vector
    double calculateTotal(){
        double itemValue = 0;
        if (items.isEmpty()){
            return itemValue;
        }
        if (items.size() == 1){
            return items.get(0).getSubtotal();
        }
        for (OrderItem item : items){
            itemValue += item.getSubtotal();
        }
        return itemValue;
    }

    /// checks for empty or one size vectors before going through the entire vector
    int getTotalItems(){
        int totalItems = 0;
        if (items.isEmpty()){
            return totalItems;
        }
        if (items.size() == 1){
            return items.get(0).getQuantity();
        }
        for (OrderItem item : items){
            totalItems += item.getQuantity();
        }
        return totalItems;
    }

    void updateStatus(String newStatus){
        this.orderStatus = newStatus;
    }

    /// if vector is empty, prints out no items
    /// if only 1 item, doesn't try to use a loop
    void printOrder(){
        if (items.isEmpty()){
            System.out.println("No items");
        }
        else if (items.size() == 1){
            System.out.println(items.get(0));
        }
        else {
            for (OrderItem item : items) {
                System.out.println(item);
            }
        }
    }

    Vector<OrderItem> getItems(){
        return items;
    }

    @Override
    public String toString(){
        return "Order ID: " + this.orderId + " | Customer Name: " + this.customerName + " | Order Date: " + orderDate + " | Status: " + this.orderStatus;
    }
}
