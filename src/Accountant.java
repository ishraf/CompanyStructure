/*
    Desc: Manage employee of type Accountant
    Class structure: Accountant > BusinessEmployee > Employee
 */
public class Accountant extends BusinessEmployee{
    private TechnicalLead techLead;     // techLead under accountant

    // constructor. initiate fields
    public Accountant(String name){
        super(name);
        this.techLead = null;
    }

    // getter. return fields if set, if not return null
    public TechnicalLead getTeamSupported(){
        if(this.techLead == null)
            return null;
        else
            return this.techLead;
    }

    // setter. set bonus value based on techLead object
    public void supportTeam(TechnicalLead lead){
        double bonus = 0;
        int i;

        this.techLead = lead;
        for(i=0;i<lead.curHeadCount;i++){
            bonus += lead.employee[i].getBaseSalary();
        }
        bonus += (bonus * 0.1);
        super.bonus = bonus;
    }

    // getter. return true if bonus requested is in budget
    public boolean approveBonus(double bonus){
        if(this.techLead == null)
            return false;

        return (bonus <= super.bonus);
    }

    // getter. return status string with budget and supporting techLead name
    public String employeeStatus(){
        if(this.techLead == null)
            return super.toString() + " with a budget of " + getBonusBudget() + " is supporting nobody";
        else
            return super.toString() + " with a budget of " + getBonusBudget() + " is supporting " + techLead.getName();
    }
}
