/*
    Desc: Manage employee of group business
    Class structure: BusinessEmployee > Employee
 */
public class BusinessEmployee extends Employee{
    public double bonus;    // bonus budget

    // constructor. initiate all fields
    public BusinessEmployee(String name){
        super(name,50000);  // set base salary to 50000
        this.bonus = 0.0;             // set bonus to 0
    }

    // getter. return bonus value
    public double getBonusBudget(){
        String b = String.format("%.2f",this.bonus);
        return Double.parseDouble(b);
    }

    // getter. override method from parent. return status with bonus value
    public String employeeStatus(){
        return super.toString() + " with a budget of " + this.getBonusBudget();
    }
}
