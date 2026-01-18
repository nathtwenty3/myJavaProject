package repositories;

import models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private List<Employee> employeeList = new ArrayList<>();
    public List<Employee>getAll(){
        return employeeList;
    }

    public Employee getById(int id){
        for (Employee employee: employeeList){
            if(employee.getId()==id){
                return employee;
            }
        }
        return null;
    }

    // Save
    public void save(Employee employee){
        if(employee.getId()==0){
            employee.setId(employeeList.size()+1);
            employeeList.add(employee);
        }else {
            Employee findEmployee = getById(employee.getId());
            for (int i = 0; i < employeeList.size(); i++) {
                if (findEmployee.getId()==employeeList.get(i).getId()){
                    employeeList.set(i, employee);
                }
            }
        }
    }

    // Delete
    public void delete(int id){
        Employee student = getById(id);
        if (student != null){
            employeeList.remove(student);
        }
    }
}
