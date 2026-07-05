package practice.chainOfResponsibilityPattern;

public abstract class LeaveApprovalSystem {
    protected LeaveApprovalSystem nextHandler;

    public abstract void approveLeave(int days);
    public void setNextHandler(LeaveApprovalSystem nextHandler) {
        this.nextHandler = nextHandler;
    }
}
