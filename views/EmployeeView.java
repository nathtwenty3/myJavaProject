package views;

import controllers.EmployeeControlller;
import models.Employee;
import models.Position;
import services.EmployeeService;
import services.PositionService;

import java.util.Iterator;
import java.util.Scanner;

public class EmployeeView {
    private EmployeeService employeeService;
    private PositionService positionService;
    
    private EmployeeControlller employeeControlller;
    private Scanner scanner;
    
    public EmployeeView(){
        this.employeeControlller = new EmployeeControlller();
        scanner = new Scanner(System.in);
    }
    
    public void startUp(){
        showOption();
    }
    
    private void showOption(){
        int option;
        do{
            menu();
            print("Please select option : ");
            option = Integer.parseInt(input());
            switch (option){
                case 1:
                    listEmployee();
                    break;
                case 2:
                    getEmployeeById();
                    break;
                case 3:
                    addEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                default:
                    break;
            }
            
        }while (option != 0);
    }

    private void menu(){
        print("------------------\n");
        print("Select option \n");
        print("1. List employee \n");
        print("2. Get employee by id \n");
        print("3. Add new employee \n");
        print("4. Update employee \n");
        print("5. Delete employee \n");
        print("0. Exit \n");
        print("------------------\n");
    }
    private void print(String message){
        System.out.print(message);
    }
    private String input(){
        return scanner.next().trim();
    }

    private boolean inputBoolean(){
        while (true){
            String input = input();
            if(input.equals("y")){
                return true;
            }
            if(input.equals("n")){
                return false;
            }
            else {
                print("Pleas select isMarried (y/n): ");
            }
        }
    }
    
    private void listEmployee(){
        print("1. List Employee \n");
        for(Employee employee: employeeControlller.getAllEmployees()){
            print("----------\n");
            print("Employee Id :"+employee.getId()+"\n");
            print("Employee firstName :"+employee.getFirstName()+"\n");
            print("Employee lastName :"+employee.getLastName()+"\n");
            print("Employee gender :"+employee.getGender()+"\n");
            print("Employee phonenumber :"+employee.getPhoneNumber()+"\n");
            print("Employee salary :"+employee.getSalary()+"\n");
            print("Employee isMarried :"+employee.getIsMarried()+"\n");
            print("Employee position :"+employee.getPosition().getName()+"\n");
            print("----------");
        }
        print("End list employee");
    }

    private void getEmployeeById(){
        print("2. Get employee by id \n");
        print("Enter employee id : ");
        int employeeId = Integer.parseInt(input());
        Employee employee = employeeControlller.getEmployeeById(employeeId);
        if(employee != null){
            print("-----------\n");
            print("Employee Id :"+employee.getId()+"\n");
            print("Employee firstName :"+employee.getFirstName()+"\n");
            print("Employee lastName :"+employee.getLastName()+"\n");
            print("Employee gender :"+employee.getGender()+"\n");
            print("Employee phonenumber :"+employee.getPhoneNumber()+"\n");
            print("Employee salary :"+employee.getSalary()+"\n");
            print("Employee isMarried :"+employee.getIsMarried()+"\n");
            print("Employee position :"+employee.getPosition().getName()+"\n");
            print("----------");
        }else{
            print("Employee id"+employeeId+"not found");
        }
    }

    private void addEmployee(){
        print("3. Add employee \n");
        print("Enter first name :");
        String employeeFirstName = input();
        print("Enter last name :");
        String employeeLastName = input();
        print("Enter gender :");
        String employeeGender = input();
        print("Enter phone number :");
        int employeePhoneNumber = scanner.nextInt();
        print("Enter employee salary :");
        double employeeSalary = scanner.nextDouble();
        print("Enter isMarried (y/n) :");
        boolean employeeIsMarried = inputBoolean();

        Employee employee = new Employee();
        employee.setId(0);
        employee.setFirstName(employeeFirstName);
        employee.setLastName(employeeLastName);
        employee.setGender(employeeGender);
        employee.setPhoneNumber(employeePhoneNumber);
        employee.setSalary(employeeSalary);
        employee.setIsMarried(employeeIsMarried);
        employee.setPosition(selectPositions());
        employeeControlller.createEmployee(employee);
    }

    private void updateEmployee(){
        print("4. Update employee \n");
        print("Enter employee id :");
        int employeeId = Integer.parseInt(input());
        Employee findEmployee = employeeControlller.getEmployeeById(employeeId);
        if (findEmployee == null){
            print("Employee not found \n");
        }else {
            print("Enter first name :");
            String employeeFirstName = input();
            print("Enter last name :");
            String employeeLastName = input();
            print("Enter gender :");
            String employeeGender = input();
            print("Enter phone number :");
            int employeePhoneNumber = Integer.parseInt(input());
            print("Enter employee salary :");
            double employeeSalary = Double.parseDouble(input());
            print("Enter isMarried (y/n) :");
            boolean employeeIsMarried = inputBoolean();
            Employee employee = new Employee();

            employee.setId(employeeId);
            employee.setFirstName(employeeFirstName);
            employee.setLastName(employeeLastName);
            employee.setGender(employeeGender);
            employee.setPhoneNumber(employeePhoneNumber);
            employee.setSalary(employeeSalary);
            employee.setIsMarried(employeeIsMarried);
            employee.setPosition(selectPositions());
            employeeControlller.updateEmployee(employee);

            print("------------------------------\n");
            print("Employee id :"+employee.getId()+"\n");
            print("Employee firstName :"+employee.getFirstName()+"\n");
            print("Employee lastName :"+employee.getLastName()+"\n");
            print("Employee gender :"+employee.getGender()+"\n");
            print("Employee phonenumber :"+employee.getPhoneNumber()+"\n");
            print("Employee salary :"+employee.getSalary()+"\n");
            print("Employee isMarried :"+employee.getIsMarried()+"\n");
            print("Employee position :"+employee.getPosition().getName()+"\n");
            print("------------------------------\n");
        }
    }

    private void deleteEmployee(){
        print("5. Delete employee \n");
        print("Enter employee id :");
        int employeeId = Integer.parseInt(input());
        Employee employee = employeeControlller.getEmployeeById(employeeId);
        if(employee == null){
            print("Employee not found \n");
        }else {
            employeeControlller.deleteEmployee(employeeId);
        }
    }

    private Position selectPositions(){
        print("Select position \n");
        for (Position position: employeeControlller.getAllPositions()){
            print("Position"+position.getId());
            print(" "+position.getName()+"\n");
        }
        while (true){
            int positionId = Integer.parseInt(input());
            Position position = employeeControlller.getPositionById(positionId);
            if(position != null){
                return position;
            }else{
                print("Pleas select position \n");
            }
        }
    }
}
