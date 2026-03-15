package P02;

import java.util.Scanner;

class Building {
    protected double area;

    Building(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void printCapacity() {
        System.out.println("Capacity of the building: " + area);
    }

}

class Accomodation extends Building {
    protected Building buildingName;

    Accomodation(double area, Building buildingName) {
        super(area);
        this.buildingName = buildingName;
    }

    @Override
    public void printCapacity() {
        System.out.println("Capacity of entire accomodation is: " + area);

    }
}

class Room extends Accomodation {
    private int numberOfBeds;

    public Room(double area, Building building, int numberOfBeds) {
        super(area, building);
        this.numberOfBeds = numberOfBeds;

    }

    @Override
    public void printCapacity() {
        System.out.println(area + numberOfBeds + "is the capacity of the room");
    }

    public void printData() {
        System.out.println("Room with area: " + area + " and " + numberOfBeds + " bed/s.");
    }
}

class Apartment extends Accomodation {

    private int terrace;

    Apartment(double area, Building building, int terrace) {
        super(area, building);
        this.terrace = terrace;
    }

    @Override
    public void printCapacity() {
        System.out.println("Capacity of entire apartment is: " + terrace + area);
    }

    public void printData() {
        System.out.printf("Apartment with %.2f capacity and %d terraces", area, terrace);

    }

}

class Office extends Accomodation {
    private int workingStations;

    Office(double area, Building building, int workingStations) {
        super(area, building);
        this.workingStations = workingStations;
    }

    @Override
    public void printCapacity() {
        System.out.println("Capacity of the entire office with " + area + workingStations + " working stations");
    }

    public void printData() {
        System.out.printf("Office with %.2f capacity and %d working stations.", area, workingStations);

    }

}
public class P02{
    static void main() {
        Scanner sc = new Scanner(System.in);

        double buildingArea = sc.nextDouble();
        Building building = new Building(buildingArea);

        double roomArea = sc.nextDouble();
        int beds = sc.nextInt();
        Room room = new Room(roomArea, building, beds);

        double apartmentArea = sc.nextDouble();
        int balconies = sc.nextInt();
        Apartment apartment = new Apartment(apartmentArea, building, balconies);

        double officeArea = sc.nextDouble();
        int workPlaces = sc.nextInt();
        Office office = new Office(officeArea, building, workPlaces);

        building.printCapacity();

        room.printCapacity();
        room.printData();

        apartment.printCapacity();
        apartment.printData();

        office.printCapacity();
        office.printData();
    }
}