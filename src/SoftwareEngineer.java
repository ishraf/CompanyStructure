/*
    Desc: Manage employee of type software engineer
    Class structure: SoftwareEngineer > TechnicalEmployee > Employee
 */
public class SoftwareEngineer extends TechnicalEmployee{
    public boolean access;      // access to code check-in

    // constructor. initialize all fields
    public SoftwareEngineer(String name){
        super(name);            // set employee name
        this.access = false;    // access by default is false
        super.checkIns = 0;     // total check-in is 0
    }

    // getter. return access permission
    public boolean getCodeAccess(){
        return this.access;
    }

    // setter. set access to check-in
    public void setCodeAccess(boolean access){
        this.access = access;
    }

    // getter. return total check-ins
    public int getSuccessfulCheckIns(){
        return super.checkIns;
    }

    // setter & getter. manage code access and total check-ins
    public boolean checkInCode(){
        TechnicalLead manager = (TechnicalLead) getManager();
        if(manager.approveCheckIn(this)){
            checkIns++;
            return true;
        }else{
            access = false;
            return false;
        }
    }
}
