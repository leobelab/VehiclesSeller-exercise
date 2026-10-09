package Models;

public class Motorcycle extends Vehicle {
    int engineDispl;

    public Motorcycle(String plate_num, String model, String maker, Person owner, int engineDispl) {
        super(plate_num, model, maker, owner);
        this.engineDispl = engineDispl;
    }

    public int getEngineDispl() {return engineDispl;}

    public void setEngineDispl(int engineDispl) {this.engineDispl = engineDispl;}

    @Override
    public double tax_to_pay(){
        return engineDispl*0.1;
    }


}
