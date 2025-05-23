package solidPrincipal;

import java.util.ArrayList;
import java.util.List;

class Product2{
    String name;
    double price;
     Product2(String name,double price){
         this.name=name;
         this.price=price;
     }
}

class ShoppingCart2{
    List<Product2> product2List= new ArrayList<>();

    public void add(Product2 product2){
        product2List.add(product2);
    }

    List<Product2> getProducts(){
        return product2List;
    }

    double calculateTotal(){
        double total=0;
        for (Product2 p:product2List)
             {
                 total=total+p.price;
             }

        return  total;
    }


}
class ShoppingCartPrinter2{
    private  ShoppingCart2 shoppingCart2;

    ShoppingCartPrinter2(ShoppingCart2 cart2){
        this.shoppingCart2=cart2;
    }
    void printInvoice(){
        System.out.println("Shopping Cart Invoice");
        for (Product2 p:shoppingCart2.getProducts()){
            System.out.println(p.name+"-Rs"+p.price);
        }
        System.out.println("Total"+shoppingCart2.calculateTotal());
    }

}
class ShoppingCartStorage2 {
    private ShoppingCart2 cart;

    ShoppingCartStorage2(ShoppingCart2 cart) {
        this.cart = cart;
    }

    void saveToSQLDatabase() {
        System.out.println("Saving shopping cart to SQL DB...");
    }

    void saveToMongoDatabase() {
        System.out.println("Saving shopping cart to Mongo DB...");
    }

    void saveToFile() {
        System.out.println("Saving shopping cart to File...");
    }
}

public class OcpFollowed {
    public  static  void main(String[] args){
   ShoppingCart2 shoppingCart2=new ShoppingCart2();
   shoppingCart2.add(new Product2("Laptop",677));
   shoppingCart2.add(new Product2("mouse",56378));
   ShoppingCartPrinter2 shoppingCartPrinter2= new ShoppingCartPrinter2(shoppingCart2);
   shoppingCartPrinter2.printInvoice();

   ShoppingCartStorage2 db= new ShoppingCartStorage2(shoppingCart2);
   db.saveToFile();
    }
}
