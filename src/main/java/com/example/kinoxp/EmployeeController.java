package com.example.kinoxp;

import com.example.kinoxp.model.Shift;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public String employeePage() {
        return "employee";
    }

    @GetMapping("/manage-schedule")
    public String manageSchedulePage() {
        return "schedule";
    }


    @GetMapping("/api/shifts")
    @ResponseBody
    public List<Shift> getAllShifts() {
        return employeeService.getAllShifts();
    }

    @PostMapping("/api/shifts")
    @ResponseBody
    public Shift addShift(@RequestBody Shift shift) {
        return employeeService.addShift(shift);
    }
}
