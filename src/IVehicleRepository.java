import java.util.List;

public interface IVehicleRepository {
    void rentCar(String plate_number);
    void returnCar(String plate_number);
    void loadVehicles();
    List<Vehicle> getVehicles();
    void save();

}
