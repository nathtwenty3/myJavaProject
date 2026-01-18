package controllers;

import models.Employee;
import models.Position;
import services.EmployeeService;
import services.PositionService;
import services.impl.EmployeeServiceImpl;
import services.impl.PositionServiceImpl;

import java.util.List;

public class EmployeeControlller {
    private EmployeeService employeeService;
    private PositionService positionService;
    public EmployeeControlller(){
        this.employeeService = new EmployeeServiceImpl();
        this.positionService = new PositionServiceImpl();
    }
    public List<Employee>getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    public Employee getEmployeeById(int id){
        return employeeService.getEmployeeById(id);
    }
    public void createEmployee(Employee employee){
        employeeService.insertEmployee(employee);
    }
    public void updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
    }
    public void deleteEmployee(int id) {
        employeeService.deleteEmployee(id);
    }

    // Get Position
    public List<Position>getAllPositions(){
        return positionService.getAllPositions();
    }
    public Position getPositionById(int id){
        return positionService.getPositionsById(id);
    }
}
