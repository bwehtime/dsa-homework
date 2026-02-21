public class OrderItem {
    //task 2.1
    String productId;
    String productName;
    int quantity;
    double unitPrice;
    double subtotal;

    public OrderItem(String productId, String productName, int quantity, double unitPrice){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;

        //subtotal changes based on quantity and price
        this.subtotal = quantity * unitPrice;
    }

    String getProductId(){
        return this.productId;
    }

    String getProductName(){
        return this.productName;
    }

    int getQuantity(){
        return this.quantity;
    }

    double getUnitPrice(){
        return this.unitPrice;
    }

    double getSubtotal(){
        return this.subtotal;
    }

    void setProductId(String productId){
        this.productId = productId;
    }

    void setProductName(String productName){
        this.productName = productName;
    }

    //automatically updates subtotal when quantity changes
    void setQuantity(int quantity){
        this.quantity = quantity;
        calculateSubtotal();
    }

    //automatically updates subtotal when price changes
    void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
        calculateSubtotal();
    }

    public String toString(){
        return "Product ID: " + this.productId + " | Product Name: " + this.productName + " | Quantity: " + this.quantity + " | Unit Price: " + this.unitPrice + " | Subtotal: " + this.subtotal;
    }

    //updates subtotal
    double calculateSubtotal(){
        this.subtotal = this.quantity * this.unitPrice;
        return this.subtotal;
    }

}
