package solidPrincipal;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

class Product1{
    String name;
    double price;

    public Product1(String name, double price) {
        this.name = name;
        this.price = price;
    }

}
 class  ShoppingCart1{
   private List<Product> productList= new ArrayList<>();
   public void addProduct(Product p){
       productList.add(p);
   }

     public List<Product> getProducts() {
         return productList;
     }

     public double calculateTotal() {
         double total = 0;
         for (Product p : productList) {
             total += p.price;
         }
         return total;
     }

}
class ShoppingCartPrinter{
    private  ShoppingCart1 cart;

    public ShoppingCartPrinter(ShoppingCart1 cart) {
        this.cart = cart;
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

class ShoppingCartStorage {
    private ShoppingCart1 cart;

    public ShoppingCartStorage(ShoppingCart1 cart) {
        this.cart = cart;
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

public class srpf {
    public static void main(String[] args){

        ShoppingCart1 cart = new ShoppingCart1();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        ShoppingCartStorage db = new ShoppingCartStorage(cart);
        db.saveToDatabase();
    }
}
