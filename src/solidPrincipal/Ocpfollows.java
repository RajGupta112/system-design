package solidPrincipal;

import java.util.ArrayList;
import java.util.List;

class Product3 {
    String name;
    double price;

    Product3(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart3 {
    List<Product3> product3List = new ArrayList<>();

    public void add(Product3 product3) {
        product3List.add(product3);
    }

    List<Product3> getProducts() {
        return product3List;
    }

    double calculateTotal() {
        double total = 0;
        for (Product3 p : product3List) {
            total += p.price;
        }
        return total;
    }
}

class ShoppingCartPrinter3 {
    private ShoppingCart3 shoppingCart3;

    ShoppingCartPrinter3(ShoppingCart3 cart3) {
        this.shoppingCart3 = cart3;
    }

    void printInvoice() {
        System.out.println("Shopping Cart Invoice");
        for (Product3 p : shoppingCart3.getProducts()) {
            System.out.println(p.name + " - Rs" + p.price);
        }
        System.out.println("Total: Rs" + shoppingCart3.calculateTotal());
    }
}

// OCP-Compliant Persistence Interface (Generalized for any cart type)
interface Persistence {
    void saveCart(ShoppingCart3 cart);
}

class SQLPersistence implements Persistence {
    @Override
    public void saveCart(ShoppingCart3 cart) {
        System.out.println("Saved to SQL Database");
    }
}

class MongoPersistence implements Persistence {
    @Override
    public void saveCart(ShoppingCart3 cart) {
        System.out.println("Saved to MongoDB");
    }
}

class FilePersistence implements Persistence {
    @Override
    public void saveCart(ShoppingCart3 cart) {
        System.out.println("Saved to File");
    }
}

public class Ocpfollows {
    public static void main(String[] args) {
        ShoppingCart3 cart = new ShoppingCart3();
        cart.add(new Product3("Laptop", 50000));
        cart.add(new Product3("Mouse", 2000));

        ShoppingCartPrinter3 printer = new ShoppingCartPrinter3(cart);
        printer.printInvoice();

        Persistence sql = new SQLPersistence();
        Persistence mongo = new MongoPersistence();
        Persistence file = new FilePersistence();

        sql.saveCart(cart);  // Save to SQL
        mongo.saveCart(cart); // Save to MongoDB
        file.saveCart(cart);  // Save to File
    }
}