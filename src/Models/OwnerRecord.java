package Models;

import java.util.LinkedHashMap;
import java.util.Map;

public class OwnerRecord {
    private Person owner;
    private Map<Vehicle, Double> taxes;
    private double total = 0;

    public OwnerRecord(Person owner,  Map<Vehicle, Double> taxes,  double total) {
        this.owner = owner;
        this.taxes = taxes;
        this.total = total;
    }

    public void addVehicle(Vehicle v, double tax) {
        taxes.put(v, tax);
        total += tax;
    }

    public Person getOwner() {
        return owner;
    }

    public Map<Vehicle, Double> getTaxes() {
        return taxes;
    }

    public double getTotal() {
        return total;
    }
}