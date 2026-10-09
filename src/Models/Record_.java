package Models;

import java.util.ArrayList;
import java.util.List;

public class Record_ {
    private int year;
    private List<OwnerRecord> ownersRecords = new ArrayList<>();

    public Record_(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void addOwnerRecord(OwnerRecord own_rec) {
        ownersRecords.add(own_rec);
    }
    public List<OwnerRecord> getOwnerRecords() {
        return ownersRecords;
    }
}
