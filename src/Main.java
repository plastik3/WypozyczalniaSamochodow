import java.util.List;

public class Main {
    public static void main(String[] args) {

    VehicleRepository repository = new VehicleRepository();

    repository.loadVehicles();

    repository.rentCar("UWU34O");
    repository.save();
    repository.rentCar("UWU678");
    repository.save();
    repository.returnCar("JKL567");
    repository.save();

    List<Vehicle> vehiclesAfter = repository.getVehicles();


    System.out.println("\n Available Cars: ");
    for (Vehicle vehicle : vehiclesAfter) {
        System.out.println(vehicle.toString());
    }
    }
}