package services;

import models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void insertEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
