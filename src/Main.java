import facade.System_;
import Models.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.run();

    }

    public void run() {

        System_ system = new System_();

        // ========================================
        // 1. TEST PEOPLE
        // ========================================

        System.out.println("===== PEOPLE =====");

        system.addPerson("L001", "John", "Smith", "Barcelona");
        system.addPerson("L002", "Alice", "Brown", "Sitges");
        system.addPerson("L003", "Peter", "Jones", "Vilanova");

        Person john = system.searchPerson("L001");
        Person alice = system.searchPerson("L002");
        Person peter = system.searchPerson("L003");

        System.out.println("John found: " + (john != null));
        System.out.println("Alice found: " + (alice != null));
        System.out.println("Peter found: " + (peter != null));
        System.out.println("Unknown person: "
                + (system.searchPerson("L999") == null));

        system.editPerson("L001", "John", "Smith", "Madrid");

        System.out.println("John's new address: " + peter.getAddress());

        // ========================================
        // 2. TEST ADDING VEHICLES
        // ========================================

        System.out.println("\n===== ADD VEHICLES =====");

        system.addMotorcycle("M001", "MT-07", "Yamaha", john, 689);
        system.addPetrolCar("C001", "Civic", "Honda", john, 120.0);
        system.addDieselCar("C002", "Golf", "Volkswagen", alice, 135.0);
        system.addHybridCar("C003", "Prius", "Toyota", peter, 90.0);

        Vehicle motorcycle = system.searchVehicle("M001");
        Vehicle petrolCar = system.searchVehicle("C001");
        Vehicle dieselCar = system.searchVehicle("C002");
        Vehicle hybridCar = system.searchVehicle("C003");

        System.out.println("Motorcycle found: " + (motorcycle != null));
        System.out.println("Petrol car found: " + (petrolCar != null));
        System.out.println("Diesel car found: " + (dieselCar != null));
        System.out.println("Hybrid car found: " + (hybridCar != null));

        System.out.println("Unknown vehicle: "
                + (system.searchVehicle("X999") == null));

        // ========================================
        // 3. TEST EDITING VEHICLES
        // ========================================

        System.out.println("\n===== EDIT VEHICLES =====");

        system.editVehicle("M001", "MT-09", "Yamaha", john, 890);

        System.out.println("Motorcycle model: "
                + motorcycle.getModel());
        System.out.println("Motorcycle engine: "
                + ((Motorcycle) motorcycle).getEngineDispl());


        system.editCar("C001", "Accord", "Honda", john, 110.0);

        System.out.println("Car model: " + petrolCar.getModel());
        System.out.println("Car emissions: "
                + ((Car) petrolCar).getCo2Emissions());

        // ========================================
        // 4. TEST SELLING VEHICLES
        // ========================================

        System.out.println("\n===== SELL VEHICLES =====");

        system.sellVehicle(petrolCar, alice);

        System.out.println("Alice is the new owner: "
                + (petrolCar.getOwner() == alice));

        System.out.println("John no longer owns the car: "
                + !john.getVehicles().contains(petrolCar));

        System.out.println("Alice owns the car: "
                + alice.getVehicles().contains(petrolCar));

        // Selling to the same owner should do nothing.
        system.sellVehicle(petrolCar, alice);

        System.out.println("Same-owner sale handled: "
                + (petrolCar.getOwner() == alice));

        // ========================================
        // 5. TEST YEARLY RECORD GENERATION
        // ========================================

        System.out.println("\n===== YEARLY RECORDS =====");

        Record_ r2025 = system.generateYearlyRecords(2025);
        List<OwnerRecord> ownRecs2025 = r2025.getOwnerRecords();
        for (OwnerRecord r : ownRecs2025) {
            System.out.println("2025 RECORD for: " + r.getOwner().getName());
            System.out.println("Vehicles-Taxes related: " + r.getTaxes());
            System.out.println("Total taxes: " + r.getTotal());
        }

        system.sellVehicle(petrolCar, john);

        system.generateYearlyRecords(2026);

        Record_ r2026 = system.generateYearlyRecords(2025);
        List<OwnerRecord> ownRecs2026 = r2025.getOwnerRecords();
        for (OwnerRecord r : ownRecs2026) {
            System.out.println("2026 RECORD for: " + r.getOwner().getName());
            System.out.println("Vehicles-Taxes related: " + r.getTaxes());
            System.out.println("Total taxes: " + r.getTotal());
        }

        System.out.println("Records generated for 2025 and 2026.");

        // The current System_ class has no public getter
        // to inspect yearlyRecords or their tax values.

        // ========================================
        // 6. TEST DELETING VEHICLES
        // ========================================

        System.out.println("\n===== DELETE VEHICLES =====");

        system.deleteVehicle("C002");

        System.out.println("Deleted vehicle not found: "
                + (system.searchVehicle("C002") == null));

        // ========================================
        // 7. TEST DELETING PEOPLE
        // ========================================

        System.out.println("\n===== DELETE PEOPLE =====");

        List<Vehicle> peterVehicles = system.searchPerson("L003").getVehicles();

        system.deletePerson("L003");

        System.out.println("Deleted person not found: "
                + (system.searchPerson("L003") == null));

        for (Vehicle v : peterVehicles) {
            if(v.getOwner() != null) {System.out.println("Peter's vehicles have not been unregistered from him correctly");}
            else System.out.println("Peter's vehicles have been unregistered from him correctly");
        }

        System.out.println("\n===== ALL TESTS COMPLETED =====");
    }
}




