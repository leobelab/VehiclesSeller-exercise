package Models;

public class PetrolCar extends Car {

    public PetrolCar(String plate_num, String model, String maker, Person owner, double co2Emissions) {
        super(plate_num, model, maker, owner, co2Emissions);
    }

    @Override
    public double tax_to_pay(){
        return co2Emissions*1.4;
    }

}
