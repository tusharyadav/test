package com.example.test.demo;

import com.example.test.demo.entity.Employee;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EmployeeDatabaseAttributes {

    // A private attribute to store Employee objects
    private final Map<UUID, Employee> employeeDatabase = new HashMap<>();

    // Adds a new Employee to the database
    public void addEmployee(@NonNull Employee employee) {
//        employeeDatabase.put(employee.getEmployeeId(), employee);
    }

    // Updates an existing Employee in the database
    public void updateEmployee(@NonNull Employee employee) {
        UUID id = UUID.randomUUID();

        if (employeeDatabase.containsKey(id)) {
            employeeDatabase.put(id, employee);
        } else {
            throw new IllegalArgumentException("Employee with ID " + id + " does not exist.");
        }
    }

    // Retrieves an Employee's information by ID
    public Employee getEmployee(@NonNull UUID employeeId) {
        Employee employee = employeeDatabase.get(employeeId);
        if (employee != null) {
            return employee;
        } else {
            throw new IllegalArgumentException("Employee with ID " + employeeId + " not found.");
        }
    }

    // Returns all the employees
    public Map<UUID, Employee> getAllEmployees() {
        return new HashMap<>(employeeDatabase);
    }

    // Returns a string representation of all employees in the database
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employeeDatabase.values()) {
            sb.append(employee.toString()).append("\n");
        }
        return sb.toString();
    }
}
