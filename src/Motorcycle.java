public class Motorcycle extends Vehicle{
    String category;

    public Motorcycle(String brand, String model, int year, int price, boolean rented, String plate_number,String category) {
        super(brand, model, year, price, plate_number);
        this.rented = rented;
        this.category = category;
    }

    @Override
    public String toCSV(){
        return String.join(";",brand,model,String.valueOf(year),String.valueOf(price),String.valueOf(rented),plate_number,category);
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", rented=" + rented +
                ", plate_number='" + plate_number + '\'' +
                '}';
    }
}
