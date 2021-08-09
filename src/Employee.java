/*
    Employee is a base class for Company Structure program
 */
public abstract class Employee {
    private static int uId = 1;     // running unique ID
    private int id;                 // employee ID
    private String name;            // employee name
    public double baseSalary;       // employee base salary

    // constructor. initialize all fields
    public Employee(String name, double baseSalary){
        this.id = this.uId++;       // increase unique ID
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // getter. return employee salary
    public double getBaseSalary(){
        return this.baseSalary;
    }

    // getter. return employee name
    public String getName(){
        return this.name;
    }

    // getter . return employee ID
    public int getEmployeeID(){
        return this.id;
    }

    // getter. return current object
    public Employee getManager(){
        return this;
    }

    // checker. return true if employee ID matches
    public boolean equals(Employee other){
        if(this.id == other.id)
            return true;
        else
            return false;
    }

    // getter. return string of ID and name
    public String toString(){
        return this.id+" "+this.name;
    }

    // abstract method. getter. return employee status
    public abstract String employeeStatus();
}
