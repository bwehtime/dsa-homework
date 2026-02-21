import java.util.Objects;
import java.util.Vector;

public class Product {

    //task 1.1
    String productId;
    String name;
    String category;
    double price;
    int quantityInStock;
    String supplier;

    public Product(String productId, String name, String category, double price, int quantityInStock, String supplier){
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.supplier = supplier;
    }

    void setProductId(String productId){
        this.productId = productId;
    }

    void setName(String name){
        this.name = name;
    }

    void setCategory(String category){
        this.category = category;
    }

    void setPrice(double price){
        this.price = price;
    }

    void setQuantityInStock(int quantityInStock){
        this.quantityInStock = quantityInStock;
    }

    void setSupplier(String supplier){
        this.supplier = supplier;
    }

    String getProductId(){
        return this.productId;
    }

    String getName(){
        return this.name;
    }

    String getCategory(){
        return this.category;
    }

    double getPrice() {
        return price;
    }

    int getQuantityInStock() {
        return quantityInStock;
    }

    String getSupplier() {
        return supplier;
    }

    @Override
    public String toString(){
        return "Product ID: " + productId + " | Name: " + name + " | Category: " + category + " | Price: " + price + " | Quantity in Stock: " + quantityInStock + " | Supplier: " + supplier;
    }

    /// checks product by ID
    boolean equals(Product product){
        return this.productId.equals(product.getProductId());
    }

    /// Unique identifier
    public int hashCode(){
        return Objects.hash(this.productId);
    }

}
