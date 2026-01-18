package services.impl;

import models.Employee;
import repositories.EmployeeRepository;
import services.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(){
        employeeRepository = new EmployeeRepository();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.delete(id);
    }
}
