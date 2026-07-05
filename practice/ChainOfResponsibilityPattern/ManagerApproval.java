package practice.chainOfResponsibilityPattern;

public class ManagerApproval extends LeaveApprovalSystem {
    @Override
    public void approveLeave(int days) {
        if(days <= 5) {
            System.out.println("Leave approved by Manager for " + days + " days.");
        }
        else if(nextHandler != null) {
            nextHandler.approveLeave(days);
        } else {
            System.out.println("Leave request for " + days + " days cannot be approved.");
        }
    }
    
}
