package Models;

public abstract class Car extends Vehicle {
    double co2Emissions;

    public Car(String plate_num, String model, String maker, Person owner, double co2Emissions) {
        super(plate_num, model, maker, owner);
        this.co2Emissions = co2Emissions;
    }

    public double getCo2Emissions() {return co2Emissions;}
    public void setCo2Emissions(double co2Emissions) {this.co2Emissions = co2Emissions;}
}
