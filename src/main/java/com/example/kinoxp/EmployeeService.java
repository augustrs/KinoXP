package com.example.kinoxp;


import com.example.kinoxp.model.Shift;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Shift> getAllShifts() {
        return employeeRepository.getAllShifts();
    }

    public Shift addShift(Shift shift) {
        return employeeRepository.addShift(shift);
    }
}
