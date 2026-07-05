package practice.chainOfResponsibilityPattern;

public class DirectorApproval extends LeaveApprovalSystem {
    @Override
    public void approveLeave(int days) {
        if (days <= 10) {
            System.out.println("Director approved leave for " + days + " days.");
        } else if (nextHandler != null) {
            nextHandler.approveLeave(days);
        } else {
            System.out.println("Leave request for " + days + " days cannot be approved.");
        }
    }
}
