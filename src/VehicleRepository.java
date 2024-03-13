import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRepository implements IVehicleRepository{

    private List<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
        loadVehicles();
    }
    @Override
    public void rentCar(String plate_number){
        for(Vehicle v : vehicles){
            if(v.getPlate().equals(plate_number) && !v.isRented()){
                v.setRented(true);
                System.out.println("Vehicle with plate number " + plate_number + " has been rented.");
                return;
            } else {
                System.out.println("Vehicle with plate number " + plate_number + " is already rented.");
                break;
            }
        }
    }

    @Override
    public void returnCar(String plate_number) {
        for(Vehicle v : vehicles){
            if(v.getPlate().equals(plate_number) && v.isRented()){
                v.setRented(false);
                System.out.println("Vehicle with plate number " + plate_number + " has been returned.");
                return;
            } else {
                System.out.println("Vehicle with plate number " + plate_number + " is already returned.");
                break;
            }

        }
    }

    @Override
    public List<Vehicle> getVehicles(){
        return vehicles;
    }

    @Override
    public void loadVehicles() {
        vehicles.clear();
        try {
            Scanner s = new Scanner(new File("vehicles.csv"));
            while(s.hasNextLine()){
                String line = s.nextLine();
                //System.out.println("Read line from CSV: " + line);
                String[] parts = line.split(";");
                String type = parts[0];
                String brand = parts[1];
                String model = parts[2];
                int year = Integer.parseInt(parts[3]);
                int price = Integer.parseInt(parts[4]);
                boolean rented = Boolean.parseBoolean(parts[5]);
                String plate_number = parts[6];
                if(type.equals("Car")){
                    vehicles.add(new Car(brand,model,year,price,rented,plate_number));
                } else if (type.equals("Motorcycle")){
                    String category = parts[7];
                    vehicles.add(new Motorcycle(brand, model, year, price, rented, plate_number, category));
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vehicles.csv"))) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Car) {
                    writer.write("Car;");
                } else if (vehicle instanceof Motorcycle) {
                    writer.write("Motorcycle;");
                }
                writer.write(vehicle.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
