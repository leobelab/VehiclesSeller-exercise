package Models;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String lic_num;
    private String name;
    private String surname;
    private String address;
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();

    public Person(String lic_num, String name, String surname, String address) {

        this.lic_num = lic_num;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public void buyVehicle(Vehicle v){
        if(v.getOwner() != null) vehicles.add(v);
        else {
            v.getOwner().vehicles.remove(v);
            vehicles.add(v);
        }
    }

    public void removeVehicle(Vehicle v){
        if(v.getOwner() == this) vehicles.remove(v);
    }

    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    public String getLic_num() {return lic_num;}
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getAddress() {return address;}
    public List<Vehicle> getVehicles() {return vehicles;}

    public void setLic_num(String lic_num) {this.lic_num = lic_num;}
    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setAddress(String address) {this.address = address;}
}

