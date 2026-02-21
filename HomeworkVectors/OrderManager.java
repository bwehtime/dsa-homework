import java.util.Vector;

public class OrderManager {
    //task 2.3
    Vector<Order> orders = new Vector<>();

    public void addOrder(Order order){
        orders.add(order);
    }

    public Order findOrder(String orderId){

        /// if order list is empty, the order definitely does not exist
        if (orders.isEmpty()){
            return null;
        }

        /// checks if the first one is the order before trying to loop
        else if (orders.get(0).equals(orderId)){
            return orders.get(0);
        }
        else {
            for (Order order : orders){
                if (order.getOrderId().equals(orderId)) {
                    return order;
                }
            }
        }
        return null;
    }

    Vector<Order> getOrdersByStatus(String status){
        Vector<Order> ordersByStatus = new Vector<>();

        /// if orders is empty, returns an empty vector
        if (orders.isEmpty()){
            return ordersByStatus;
        }
        /// checks if status matches before adding to vector
        for (Order order : orders){
            if (order.getOrderStatus().equals(status)){
                ordersByStatus.add(order);
            }
        }
        return ordersByStatus;
    }

    /// similar method to getOrdersByStatus but for customerName
    Vector<Order> getOrdersByCustomer(String customerName){
        Vector<Order> ordersByCustomer = new Vector<>();
        if (orders.isEmpty()){
            return ordersByCustomer;
        }
        for (Order order : orders){
            if (order.getCustomerName().equals(customerName)){
                ordersByCustomer.add(order);
            }
        }
        return ordersByCustomer;
    }

    /// empty, returns 0
    /// size 1 does not bother with loop
    /// revenue set to 0 by default and calculateTotal() method is used to add to it
    double getTotalRevenue(){
        double revenue = 0;
        if (orders.isEmpty()){
            return revenue;
        }
        else if (orders.size() == 1){
            return orders.get(0).calculateTotal();
        }
        else{
            for (Order order : orders) {
                revenue += order.calculateTotal();
            }
        }
        return revenue;
    }

    /// checks if order exists before updating status
    void cancelOrder(String orderId){
        Order order = findOrder(orderId);
        if (order != null) {
            order.updateStatus("Cancelled");
        }
    }

    /// prints out orders and their items
    void printAllOrders(){
        for (Order order : orders){
            System.out.println(order);
            System.out.println("   " + order.getItems());
        }
    }

    /// uses getOrdersByStatus() method
    Vector<Order> getPendingOrders(){
        Vector<Order> pendingOrders = getOrdersByStatus("Pending");
        return pendingOrders;
    }

    int getOrderCount(){
        return orders.size();
    }
}
