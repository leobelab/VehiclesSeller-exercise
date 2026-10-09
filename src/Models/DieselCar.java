package Models;

public class DieselCar extends Car {

    public DieselCar(String plate_num, String model, String maker, Person owner, double co2Emissions) {
        super(plate_num, model, maker, owner, co2Emissions);
    }

    @Override
    public double tax_to_pay(){
        return co2Emissions*1.8;
    }

}

