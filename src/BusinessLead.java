/*
    Desc: Manage employee of type business lead
    Class structure: BusinessLead > BusinessEmployee > Employee
 */
public class BusinessLead extends BusinessEmployee{
    private int maxHeadCount;           // max employee to handle
    public int curHeadCount;            // current employee handled
    private Accountant[] employee;      // employee object of type accountant

    // constructor. initiate all fields
    public BusinessLead(String name){
        super(name);
        baseSalary = super.getBaseSalary() * 2;     // baseSalary for businessLead x 2 baseSalary of business group
        this.maxHeadCount = 10;                     // set max employee to 10
        this.curHeadCount = 0;
        this.employee = new Accountant[this.maxHeadCount];
    }

    // getter. return true if employee handled hasn't reach max
    public boolean hasHeadCount(){
        if(this.curHeadCount < this.maxHeadCount)
            return true;
        else
            return false;
    }

    // getter. add employee data of type TechnicalLead and Accountant
    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        // add support team to Accountant. if can't add, return false
        e.supportTeam(supportTeam);
        if(e.getTeamSupported() == null)
            return false;

        // add new Accountant data and return true. if reach max, return false
        if(this.curHeadCount < this.maxHeadCount){
            this.employee[this.curHeadCount] = e;
            this.curHeadCount++;
            super.bonus += (e.getBaseSalary() * 1.1);
            return true;
        }
        else
            return false;
    }

    // getter. return true if bonus is still within budget. update bonus field
    public boolean requestBonus(Employee e, double bonus){
        if(bonus <= super.bonus){
            super.bonus -= bonus;
            return true;
        }
        else
            return false;
    }

    // getter. return true if bonus requested for an employee is approved
    public boolean approveBonus(Employee e, double bonus){
        int i;
        boolean status = false;

        for(i=0;i<this.curHeadCount;i++){
            if(this.employee[i].getTeamSupported().equals(e) == true) {
                status = this.requestBonus(e, bonus);
                break;
            }
        }

        return status;
    }

    // getter. return employee managed by this lead
    public String getTeamStatus(){
        String status;
        int i;

        status = employeeStatus();
        if(this.curHeadCount <= 0)
            status += " and no direct reports yet";
        else {
            status += " and is managing:";
            for(i=0;i<this.curHeadCount;i++){
                status += "\n" + this.employee[i].employeeStatus();
            }
        }

        return status;
    }
}
