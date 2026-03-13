package P02;

// A simple example of inheritance.
// Create a superclass.
class Vehicle {
    double engine_volume, price;
    void show_engine_volume() {
        System.out.println("The engine volume is: " + engine_volume);
    }
}
// Create a subclass by extending class Vehicle.
class Bus extends Vehicle {
    int number_of_seats;
    void show_number_of_seats() {
        System.out.println("The number is: " + number_of_seats);
    }
    void set_number_of_seats(int s) {
        number_of_seats = s;
    }
}
class SimpleInheritance {
    public static void main(String args[]) {
        Vehicle vehicle1 = new Vehicle();
        Bus bus = new Bus();
// The superclass may be used by itself.
        vehicle1.engine_volume = 1.9;
        vehicle1.price = 25000;
        System.out.println("Contents of vehicle: ");
        vehicle1.show_engine_volume();
        System.out.println();

        /* The subclass has access to all public members of
its superclass. */
        bus.engine_volume = 2.2;
        bus.price = 33000;
        System.out.println("Contents of bus: ");
        bus.show_engine_volume() ;
        System.out.println();
        System.out.println("The number of seats in the bus is:");
        bus.show_number_of_seats();
    }
}
/*private членове на базов клас не могат да се достъпват от клас-наследник!!!
class Vehicle {
    private double engine_volume;
    private double price;
}
class Bus extends Vehicle {
    int number_of_seats;
    void change_price(double pr) {
        price = pr;//ERROR because price is private
    }
}
//private членове на базов клас не могат да се достъпват от клас-наследник!!!
class Vehicle {
    protected double engine_volume;
    protected double price;
}
class Bus extends Vehicle {
    int number_of_seats;
    void change_price(double pr) {
        price = pr;//OK
    }
}*/





