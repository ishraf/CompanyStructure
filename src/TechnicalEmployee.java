/*
    Desc: Manage employee of group technical
    Class structure: TechnicalEmployee > Employee
 */
public class TechnicalEmployee extends Employee{
    public int checkIns;        // total code check-ins

    // constructor. set base salary to 75000
    public TechnicalEmployee(String name){
        super(name,75000);
    }

    // getter. return total code check-ins
    public String employeeStatus(){
        return super.toString() + " has " + checkIns + " successful check ins";
    }
}
