package projectmanagementapp;

public class Task {

    private String name;
    private String description;
    private String type;
    private TeamMember assignedMember;
    private String status;
    private String deadline;

    public Task(String name, String description, String type, String deadline) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.deadline = deadline;
        this.status = "Pending";
    }

    public void setAssignedMember(TeamMember assignedMember) {
        this.assignedMember = assignedMember;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

}
