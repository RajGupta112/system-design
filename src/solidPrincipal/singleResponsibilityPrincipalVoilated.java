package solidPrincipal;

import java.util.ArrayList;
import java.util.List;

class Product{
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class   ShoppingCart{
    private List<Product> productList= new ArrayList<>();

    public void addProduct(Product p){
        productList.add(p);
    }

    public List<Product> getProducts() {
        return productList;
    }

    public double calculatedPrice(){
        double total=0;
        for(Product i:productList){
            total=total+i.price;
        }
        return total;
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : productList) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + calculatedPrice());
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}
public class singleResponsibilityPrincipalVoilated {

    public static  void main(String[] args){
     ShoppingCart shoppingCart= new ShoppingCart();
     shoppingCart.addProduct(new Product("laptop",777777));
        shoppingCart .addProduct(new Product("Mouse", 2000));
        shoppingCart.printInvoice();
        shoppingCart.saveToDatabase();
    }
}
