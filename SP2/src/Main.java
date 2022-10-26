public class Main {

    public static void main(String[] args) {
        Car c1 = new GasolineCar("AB12212", "Ford", "Fiesta 2016", 5, 21);
        Car c2 = new DieselCar("CF99210", "Ford", "Armstrong 1998", 5, 14, false);
        Car c3 = new ElectricCar("GA02121", "Audi", "E2 2021", 4, 2000, 100, 12);

        FleetOfCars adamsFleet = new FleetOfCars();
        adamsFleet.addCar(c1);
        adamsFleet.addCar(c2);
        adamsFleet.addCar(c3);
        System.out.println(adamsFleet);
    }
}