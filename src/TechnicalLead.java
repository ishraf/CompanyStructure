/*
    Desc: Manage employee of type technical lead
    Class structure: TechnicalLead > TechnicalEmployee > Employee
 */
public class TechnicalLead extends TechnicalEmployee{
    private int maxHeadCount;           // max employee to handle
    public int curHeadCount;            // current employee handled
    public SoftwareEngineer[] employee; // employee object of type software engineer

    // constructor. initiate all fields
    public TechnicalLead(String name){
        super(name);
        baseSalary = super.getBaseSalary() * 1.3;   // baseSalary for businessLead x 1.3 baseSalary of technical group
        this.maxHeadCount = 4;                      // set max employee to 4
        this.curHeadCount = 0;
        employee = new SoftwareEngineer[this.maxHeadCount];
    }

    // getter. return true if total handled employee < max
    public boolean hasHeadCount(){
        return this.curHeadCount < this.maxHeadCount;
    }

    // getter and setter. if handled employee < max, add employee object, return true
    public boolean addReport(SoftwareEngineer e){
        if(this.curHeadCount < this.maxHeadCount){
            employee[this.curHeadCount] = e;
            this.curHeadCount++;
            return true;
        }
        else
            return false;
    }

    // getter. if employee is under managed employee, grant check-in access
    public boolean approveCheckIn(SoftwareEngineer e){
        int i;

        for(i=0;i<this.curHeadCount;i++){
            if(employee[i].equals(e)) break;
        }

        return (i<this.curHeadCount && e.access);
    }

    // getter. return true if bonus requested is approved for employee
    public boolean requestBonus(Employee e, double bonus){
        BusinessLead lead = (BusinessLead) e;
        return lead.approveBonus(e,bonus);
    }

    // getter. return employee details managed by the technical lead
    public String getTeamStatus(){
        int i;
        StringBuilder s = new StringBuilder();

        s.append(employeeStatus());
        if(this.curHeadCount <= 0)
            s.append(" and no direct reports yet");
        else {
            s.append(" and is managing:");
            for(i=0;i<this.curHeadCount;i++){
                s.append("\n");
                s.append(this.employee[i].employeeStatus());
            }
        }

        return s.toString();
    }
}
