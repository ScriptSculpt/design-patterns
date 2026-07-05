package practice.ChainOfResponsibilityPattern;

public class TeamLeadApproval extends LeaveApprovalSystem {
    @Override
    public void approveLeave(int days) {
        if (days <= 2) {
            System.out.println("Team Lead approved leave for " + days + " days.");
        } else if (nextHandler != null) {
            nextHandler.approveLeave(days);
        } else {
            System.out.println("Leave request for " + days + " days cannot be approved.");
        }
    }
    
}
