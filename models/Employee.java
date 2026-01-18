package models;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private int phoneNumber;
    private double salary;
    private boolean isMarried;
    private Position position;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String gender, int phoneNumber, double salary, boolean isMarried, Position position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.isMarried = isMarried;
        this.position = position;
    }

    public void setId(int id) {this.id = id;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setGender(String gender) {this.gender = gender;}
    public void setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setSalary(double salary) {this.salary = salary;}
    public void setIsMarried(boolean married) {isMarried = married;}
    public void setPosition(Position position) {this.position = position;}

    public int getId() {return id;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getGender() {return gender;}
    public int getPhoneNumber() {return phoneNumber;}
    public double getSalary() {return salary;}
    public boolean getIsMarried() {return isMarried;}
    public Position getPosition() {return position;}
}