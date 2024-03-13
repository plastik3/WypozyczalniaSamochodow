public class Car extends Vehicle{

    public Car(String brand, String model, int year, int price,boolean rented, String plate_number) {
        super(brand, model, year, price, plate_number);
        this.rented = rented;
    }

    @Override
    public String toCSV(){
        return String.join(";",brand,model,String.valueOf(year),String.valueOf(price),String.valueOf(rented),plate_number);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", rented=" + rented +
                ", plate_number='" + plate_number + '\'' +
                '}';
    }


}
