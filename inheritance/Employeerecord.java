// Problem Statement:
// Objective: To understand the concept of inheritance.
// Problem Description: 
// A construction company wants to keep a record of the employees working in it. 
// There are permanent employees as well as contract employees. 
// Contract employees work on an hourly basis whereas permanent employees are paid monthly salary. 
// The class diagrams are as given below:

class Employee {
    private int empId;
    private String Name;
    private double salary;
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public int getEmpId() {
        return empId;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getName() {
        return Name;
    }
}

class PermanentEmployee extends Employee {
    private double hra;
    private double basicPay;
    private int experience;
    public void setHra(double hra) {
        this.hra = hra;
    }
    public double getHra() {
        return hra;
    }
    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }
    public double getBasicPay() {
        return basicPay;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getExperience() {
        return experience;
    }
    public void calculateSalary() {
        double salary;
        double variablecomponent;
        if(this.experience < 3) {
            variablecomponent = 0 * this.basicPay;
        } else if(this.experience >= 3 && this.experience < 5) {
            variablecomponent = 0.05 * this.basicPay;
        } 
        else if(this.experience >= 5 && this.experience < 10) {
            variablecomponent = 0.07 * this.basicPay;
        } else {
            variablecomponent = 0.12 * this.basicPay;
        }
        salary = this.basicPay + hra + variablecomponent;
        System.out.println("The salary of the permanent employee is " + salary);
        
    }
}

class ContractEmployee extends Employee {
    private double wages;
    private int hours;
    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public double getWages() {
        return wages;
    }
    public void setWages(double wages) {
        this.wages = wages;
    }
    public void calculateSalary() {
        double salary;
        salary = this.wages * this.hours;
        System.out.println("The salary of the contract employee is " + salary);
    }
    
}

public class Employeerecord {
    public static void main(String[] args) {
        PermanentEmployee p = new PermanentEmployee();
        p.setEmpId(101);
        p.setName("Anil");
        p.setBasicPay(10000);
        p.setHra(1500);
        p.setExperience(3);
        p.calculateSalary();        
    }
}