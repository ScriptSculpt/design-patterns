package practice.ChainOfResponsibilityPattern;

public class Main {
    public static void main(String[] args) {
        LeaveApprovalSystem teamLead = new TeamLeadApproval();
        LeaveApprovalSystem manager = new ManagerApproval();
        LeaveApprovalSystem director = new DirectorApproval();

        teamLead.setNextHandler(manager);
        manager.setNextHandler(director);

        teamLead.approveLeave(1);  // Leave approved by Team Lead
        System.out.println(" ---------------------------------------------------- ");
        teamLead.approveLeave(3);  // Leave approved by Manager
        System.out.println(" ---------------------------------------------------- ");
        teamLead.approveLeave(6);  // Leave approved by Manager
        System.out.println(" ---------------------------------------------------- ");
        teamLead.approveLeave(9); // Leave approved by Director
        System.out.println(" ---------------------------------------------------- ");
        teamLead.approveLeave(15); // Leave request cannot be approved
    }
}
