package StaticProprety;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3", "Skyativ 3");
        System.out.println(Car.numberOfCar);
        Car car2 = new Car("Mazda 6", "Skyativ 6");
        System.out.println(Car.numberOfCar);
    }
}
