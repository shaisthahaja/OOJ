// Abstract base class
abstract class Shape {
    int x, y;

    Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract void printArea();
}

// Rectangle class
class Rectangle extends Shape {

    Rectangle(int l, int b) {
        super(l, b);
    }

    void printArea() {
        System.out.println("Area of Rectangle = " + (x * y));
    }
}

// Triangle class
class Triangle extends Shape {

    Triangle(int b, int h) {
        super(b, h);
    }

    void printArea() {
        System.out.println("Area of Triangle = " + (0.5 * x * y));
    }
}

// Circle class
class Circle extends Shape {

    Circle(int r) {
        super(r, 0);
    }

    void printArea() {
        System.out.println("Area of Circle = " + (3.14 * x * x));
    }
}

// Main class
public class ShapeDemo {
    public static void main(String[] args) {
        Shape r = new Rectangle(10, 5);
        Shape t = new Triangle(8, 6);
        Shape c = new Circle(7);

        r.printArea();
        t.printArea();
        c.printArea();
    }
}

