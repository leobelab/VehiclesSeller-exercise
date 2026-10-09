package facade;

import Models.*;

import java.util.*;

public class System_ {

    private List<Person> people = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Record_> yearlyRecords = new ArrayList<>();

    public System_() {
        people = new ArrayList<>();
        vehicles = new ArrayList<>();
    }

    public void addPerson(String licenseNumber,
                          String name,
                          String surname,
                          String address) {

        Person person = new Person(
                licenseNumber,
                name,
                surname,
                address
        );

        people.add(person);
    }

    public void deletePerson(String licenseNumber) {
        for (Person person : people) {
            if(person.getLic_num().equals(licenseNumber)) {
                for (Vehicle v : new ArrayList<>(person.getVehicles())) {
                    v.setOwner(null);
                }
                people.remove(person);
                return;
            }
        }
    }

    public void editPerson(String licenseNumber,
                           String new_name,
                           String new_surname,
                           String new_address) {
        for (Person person : people) {
            if (person.getLic_num().equals(licenseNumber)) {
                person.setName(new_name);
                person.setSurname(new_surname);
                person.setAddress(new_address);
                return;
            }
        }
    }

    public Person searchPerson(String licenseNumber) {
        for (Person person : people) {
            if (person.getLic_num().equals(licenseNumber)) {
                return person;
            }
        }
        return null;
    }


    public void addMotorcycle(String plate_num, String model, String maker, Person owner, int engineDispl) {
        Vehicle v = new Motorcycle(plate_num, model, maker, owner, engineDispl);
        vehicles.add(v);
    }

    public void addPetrolCar(String plate_num, String model, String maker, Person owner, double co2Emissions) {
        Vehicle v = new PetrolCar(plate_num, model, maker, owner, co2Emissions);
        vehicles.add(v);
    }

    public void addDieselCar(String plate_num, String model, String maker, Person owner,  double co2Emissions) {
        Vehicle v = new DieselCar(plate_num, model, maker, owner, co2Emissions);
        vehicles.add(v);
    }

    public void addHybridCar(String plate_num, String model, String maker, Person owner,  double co2Emissions) {
        Vehicle v = new HybridCar(plate_num, model, maker, owner, co2Emissions);
        vehicles.add(v);
    }

    public void deleteVehicle(String plate_num) {
        for (Vehicle vehicle : vehicles) {
            if(vehicle.getPlate_num().equals(plate_num)) {
                if (vehicle.getOwner() != null) vehicle.getOwner().removeVehicle(vehicle);
                vehicles.remove(vehicle);
                return;
            }
        }
    }

    public void editMotorcycle(String plate_num, String model, String maker, Person owner, int engineDispl) {
        for (Vehicle vehicle : vehicles) {
            if(vehicle.getPlate_num().equals(plate_num)) {
                if(vehicle instanceof Motorcycle m) {
                    if (!m.getModel().equals(model)) {m.setModel(model);}
                    if (!m.getMaker().equals(maker)) {m.setMaker(maker);}
                    if (m.getOwner() != owner) {m.setOwner(owner);}
                    if (m.getEngineDispl() != engineDispl) {m.setEngineDispl(engineDispl);}
                }
            }
        }
    }

    public void editCar(String plate_num, String model, String maker, Person owner, double co2Emissions) {
        for (Vehicle vehicle : vehicles) {
            if(vehicle.getPlate_num().equals(plate_num)) {
                if(vehicle instanceof Car c) {
                    if (!c.getModel().equals(model)) {c.setModel(model);}
                    if (!c.getMaker().equals(maker)) {c.setMaker(maker);}
                    if (c.getOwner() != owner) {c.setOwner(owner);}
                    if (c.getCo2Emissions() != co2Emissions) {c.setCo2Emissions(co2Emissions);}
                }
            }
        }
    }

    public Vehicle searchVehicle(String plate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlate_num().equals(plate)) {
                return vehicle;
            }
        }
        return null;
    }


    public void sellVehicle(Vehicle vehicle, Person newOwner) {
        Person oldOwner = vehicle.getOwner();
        if (oldOwner == newOwner) return;

        if (oldOwner != null) {
            oldOwner.removeVehicle(vehicle);
        }
        vehicle.setOwner(newOwner);
        newOwner.addVehicle(vehicle);
    }

    public Record_ generateYearlyRecord(int year) {
        Record_ rec = new Record_(year);
        for (Person person : people) {
            if(person.getVehicles() != null) {
                Map<Vehicle, Double> taxes = new HashMap<>();
                double totalTax = 0;
                for (Vehicle vehicle : person.getVehicles()) {
                    double tax = vehicle.tax_to_pay();
                    totalTax += tax;
                    taxes.put(vehicle, tax);
                }
                OwnerRecord own_rec = new OwnerRecord(person, taxes, totalTax);
                rec.addOwnerRecord(own_rec);
            }
        }
        yearlyRecords.add(rec);
        return rec;
    }
}