package com.example.test.demo.service;

import com.example.test.demo.CountryCode;
import com.example.test.demo.entity.Employee;
import com.example.test.demo.exceptions.CustomExceptions;
import com.example.test.demo.repository.EmployeeRepository;
import com.example.test.demo.request.EmployeeRequest;
import com.example.test.demo.utility.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private LocationRepository locationRepository;

    @Autowired
    private CommonService commonService;


    public Employee addEmployee(EmployeeRequest request) throws CustomExceptions {

        if (!EmailValidator.isValidEmail(request.getEmail())) {
            throw new IllegalArgumentException("Invalid email address");
        }
        UUID employeeId = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();


//        CountryCode location = commonService.getOrSaveLocation(request.getLocation());

        // Create an Employee with the location
        Employee employee = new Employee(
                employeeId,
                request.getName(),
                request.getPosition(),
                request.getEmail(),
                request.getSalary(),
                now,
                now,
                request.getLocation() // Pass the Location object directly
        );
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(UUID employeeId, EmployeeRequest request) throws CustomExceptions {
        Optional<Employee> existingEmployee = employeeRepository.findById(employeeId);
        if(existingEmployee.isEmpty()){
            throw new CustomExceptions(123,"No employee found", "this employee not present");
        }


        Employee employee = requestToEmployeeObjectConvertor(existingEmployee.get(),request);


        return employeeRepository.save(employee);

    }

    public Employee getEmployee(UUID employeeId) throws CustomExceptions {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new CustomExceptions(123,"Employee with ID " + employeeId + " not found.", "search correct employee"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    private Employee requestToEmployeeObjectConvertor(Employee employee, EmployeeRequest request){

        if(request.getLocation() != null)
            employee.setLocation(request.getLocation());

        if(request.getName() != null)
            employee.setName(request.getName());

        if (request.getSalary() != null) {
            employee.setSalary(request.getSalary()); // Use the getter to retrieve the salary value
        }
        if(request.getEmail() != null)
            employee.setEmail(request.getEmail());

        employee.setModifiedAt(LocalDateTime.now());

        return employee;


    }
}
