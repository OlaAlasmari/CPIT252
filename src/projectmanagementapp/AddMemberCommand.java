package projectmanagementapp;


import javax.swing.*;
import java.util.Objects;

public class AddMemberCommand implements Command {
    private DefaultListModel<String> teamListModel;

    public AddMemberCommand(DefaultListModel<String> teamListModel) {
        this.teamListModel = teamListModel;
    }

    @Override
    public void execute() {
        // Prompt user for a new member's email
        String memberEmail = JOptionPane.showInputDialog("Enter team member's email:");
        
        // Check if input is valid
        if (Objects.nonNull(memberEmail) && !memberEmail.trim().isEmpty()) {
            teamListModel.addElement(memberEmail.trim()); // Add member to the list
        } else {
            JOptionPane.showMessageDialog(null, "Invalid email. Please enter a valid email.");
        }
    }
}

