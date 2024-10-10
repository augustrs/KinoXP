package com.example.kinoxp;

import com.example.kinoxp.model.Shift;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Shift> shifts = new ArrayList<>(List.of(new Shift("John", 1, "08:00", "16:00"),
            new Shift("Jane", 1, "08:00", "16:00"),
            new Shift("Jack", 5, "08:00", "16:00")));


    public List<Shift> getAllShifts() {
        return shifts;
    }
    public Shift addShift(Shift shift) {
        shifts.add(shift);
        return shift;
    }
}
