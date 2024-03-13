abstract public class Vehicle {
    String brand;
    String model;
    int year;
    int price;
    boolean rented;
    String plate_number;


    public Vehicle(String brand, String model, int year, int price, String plate_number) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.rented = false;
        this.plate_number = plate_number;
    }

    public String getPlate(){
        return plate_number;
    }

    public void setRented(boolean choice){
        rented = choice;
    }

    public boolean isRented(){
        return rented;
    }
    abstract public String toCSV();

    abstract public String toString();


}
