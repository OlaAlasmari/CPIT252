package projectmanagementapp;

import javax.swing.*;
import java.util.Objects;

public class AddMemberCommand implements Command {

    private DefaultListModel<String> teamListModel;
    private Project project;

    public AddMemberCommand(DefaultListModel<String> teamListModel) {
        this.teamListModel = teamListModel;

    }
    
    public AddMemberCommand(DefaultListModel<String> teamListModel, Project project) {
        this.teamListModel = teamListModel;
        this.project = project; // Properly initialize the project
    }

    @Override
    public void execute() {
        // Prompt user for a new member's email
        String memberEmail = JOptionPane.showInputDialog("Enter team member's email:");

        // Check if input is valid
        if (Objects.nonNull(memberEmail) && !memberEmail.trim().isEmpty()) {
            TeamMember member = new TeamMember(memberEmail);
            project.addMember(member); // Add member to the project's member list
            teamListModel.addElement(member.getEmail()); // Add member to the GUI list display
            System.out.println("Member added to Project: " + member.getEmail());
        } else {
            JOptionPane.showMessageDialog(null, "Invalid email. Please enter a valid email.");
        }
    }
}
