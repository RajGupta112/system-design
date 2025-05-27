import org.w3c.dom.css.Rect;

import java.awt.*;

interface  Shape{
    double area();
    double  volume();
}
class Square implements  Shape{
    double side;

    Square(double s){
        this.side=s;
    }

    @Override
    public double area() {
        return side*side;
    }

    @Override
    public double volume() {
        throw  new UnsupportedOperationException("Volume is not applicable in the square");
    }
}
class Rectangle implements Shape{
    double length;
     double breadth;

     Rectangle(double length, double breadth){
         this.length= length;
         this.breadth= breadth;

     }

    @Override
    public double area() {
        return length * breadth;
    }

    @Override
    public double volume() {
        throw new UnsupportedOperationException(" Volume is not applicable in the rectangle");
    }
}
 class Cube implements  Shape{
    private  double side;
    Cube(double side){
        this.side=side;
    }

     @Override
     public double area() {
         return 6* side* side;
     }

     @Override
     public double volume() {
         return side* side*side;
     }
 }
public class Isp {
    public  static  void main(String[] args){
        Shape square= new Square(5);
        Shape rectangle= new Rectangle(4,6);
        Shape cube = new Cube(3);


        System.out.println("Square Area: "    + square.area());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Cube Area: "      + cube.area());
        System.out.println("Cube Volume: "    + cube.volume());


        try {
            System.out.println("Square Volume: " + square.volume()); // Will throw an exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
