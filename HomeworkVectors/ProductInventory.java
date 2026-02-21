import java.awt.desktop.SystemEventListener;
import java.util.Enumeration;
import java.util.Vector;

public class ProductInventory {

    //task 1.2
    Vector<Product> products = new Vector<>();

    void addProduct(Product product){
        /// checks if products is empty before searching
        if (products.isEmpty()){
            products.add(product);
        }
        else{
            /// if items are equivalent, increases the quantity of the equivalent product and breaks the loop because theres no need to search anymore
            boolean same = false;
            for (int i = 0; i < products.size(); i++){
                if (product.equals(products.get(i))){
                    same = true;
                    products.get(i).setQuantityInStock(products.get(i).getQuantityInStock() + product.getQuantityInStock());
                    break;
                }
            }
            if (!same){
                products.add(product);
            }
        }
    }

    /// checks if vector is empty before searching if the product exists in the vector
    boolean removeProduct(String productId){
        if (products.isEmpty()){
            return false;
        }
        Product productToRemove = findProduct(productId);
        if (productToRemove != null){
            products.remove(productToRemove);
            return true;
        }
        return false;
    }

    /// checks if vector is empty before searching for product
    Product findProduct(String productId){
        if (products.isEmpty()){
            return null;
        }
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    /// creates a new vector
    /// checks if products vector is empty and if yes, returns an empty vector
    /// then searches vector items and checks if category matches
    Vector<Product> getProductsByCategory(String category){
        Vector<Product> inCategory = new Vector<>();
        if (products.isEmpty()){
            return inCategory;
        }
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                inCategory.add(product);
            }
        }
        return inCategory;
    }

    /// creates a new vector
    /// checks if vector is empty and if yes, returns empty vector
    /// adds items to vector if condition is true
    Vector<Product> getLowStockProducts(int threshold){
        Vector<Product> lowStock = new Vector<>();
        if (products.isEmpty()){
            return lowStock;
        }
        for (Product product : products){
            if (product.getQuantityInStock() < threshold){
                lowStock.add(product);
            }
        }
        return lowStock;
    }

    /// sum is default 0
    /// if vector is empty, returns sum
    /// checks if only one product and returns that one product's price if true before trying to loop
    double getTotalInventoryValue(){
        double sum = 0;
        if (products.isEmpty()){
            return sum;
        }
        else if (products.size() == 1){
            return products.get(0).getPrice();
        }
        for (Product product: products){
            double productValue = product.getPrice() * product.getQuantityInStock();
            sum += productValue;
        }
        return sum;
    }

    ///checks if product exists before updating the quantity
    void updateStock(String productId, int quantityChange){
        Product product = findProduct(productId);
        if (product != null) {
            product.setQuantityInStock(quantityChange);
        }
    }

    /// if vector is empty, prints out "No products"
    /// otherwise, checks if theres only one item before looping
    void printAllProducts(){
        if (products.isEmpty()){
            System.out.println("No products");
        }
        else if (products.size() == 1){
            System.out.println(products.get(0));
        }
        else{
            for (Product product: products) {
                System.out.println(product);
            }
        }
    }

    int getTotalProducts(){
        return products.size();
    }

    void printCapacityInfo(){
        System.out.println("Current Size: " +products.size());
        System.out.println("Current Capacity: " + products.capacity());
    }

    void optimizeCapacity(){
        products.trimToSize();
    }

    void ensureCapacity(int minCapacity){
        products.ensureCapacity(minCapacity);
    }

    void printCapacityReport(){
        printCapacityInfo();
        System.out.println("Capacity Utilization percentage: " + (double)products.size() / products.capacity());
    }

    void printProductsUsingEnumeration(){
        Enumeration<Product> productEnumeration = products.elements();
        while (productEnumeration.hasMoreElements()){
            System.out.println(productEnumeration.nextElement());
        }
    }
    ///Enumeration is legacy because it only works on legacy classes. Enumeration is a little faster than iterator while lacking iterator's fail fast.



}
