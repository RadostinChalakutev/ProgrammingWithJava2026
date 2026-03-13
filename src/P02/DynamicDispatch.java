package P02;

class Figure {
    protected double dim1;
    protected double dim2;

    public Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }
    public double area() {
        System.out.println("Area for Figure is undefined.");
        return 0;
    }
}
class Rectangle extends Figure {

    public Rectangle(double a, double b) {
        super(a, b);
    }
    // override area for rectangle
    @Override
    public double area() {
        System.out.println("Inside Area for Rectangle.");
        return dim1 * dim2;
    }
}
class Triangle extends Figure {

    public Triangle(double a, double b) {
        super(a, b);
    }

    // override area for right triangle
    @Override
    public double area() {
        System.out.println("Inside Area for Triangle.");
        return dim1 * dim2 / 2;
    }
}
class FindAreas {
    public static void main(String args[]) {
        Figure f = new Figure(10, 10);
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);
        Figure figref;
        figref = r;
        System.out.println("Area is " + figref.area());
        figref = t;
        System.out.println("Area is " + figref.area());
        figref = f;
        System.out.println("Area is " + figref.area());
        int numbeOfFigures = 10;
        Figure[] arrayOfFigures;
        arrayOfFigures = new Figure[numbeOfFigures];
        int i = 10;
        for (int counter = 0; counter < numbeOfFigures/2; counter++) {
            arrayOfFigures[counter] = new Triangle(++i, i + 2);
        }
        for (int counter = numbeOfFigures/2; counter < numbeOfFigures; counter++) {
            arrayOfFigures[counter] = new Rectangle(++i, i + 2);
        }
        for (int counter = 0; counter < numbeOfFigures; counter++) {               	System.out.println(arrayOfFigures[counter].area());
        }
    }
}
