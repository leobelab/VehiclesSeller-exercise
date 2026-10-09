package Models;

public abstract class Vehicle {
    private String plate_num;
    private String model;
    private String maker;
    private Person owner = null;

    public Vehicle(String plate_num, String model, String maker, Person owner) {
        this.plate_num = plate_num;
        this.model = model;
        this.maker = maker;
        this.owner = owner;
    }

    public String getPlateNum() {return plate_num;}
    public String getModel() {return model;}
    public String getMaker() {return maker;}
    public Person getOwner() {return owner;}

    public void setModel(String model) {this.model = model;}
    public void setMaker(String maker) {this.maker = maker;}
    public void setOwner(Person owner) {this.owner = owner;}

    public double tax_to_pay() {
        return 0;
    }

    public String getPlate_num() {return plate_num;}
}
