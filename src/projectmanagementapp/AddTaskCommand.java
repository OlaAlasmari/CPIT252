package projectmanagementapp;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddTaskCommand implements Command {
    private DefaultTableModel tableModel;
    private Project project;

    public AddTaskCommand(DefaultTableModel tableModel, Project project) {
        this.tableModel = tableModel;
        this.project = project;
    }

    @Override
    public void execute() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
        if (taskName != null && taskDescription != null && !taskName.isEmpty()) {
            Task newTask = new Task(taskName, taskDescription, "Development", "2024-11-30");
            project.addTask(newTask);  // Ensure this method adds the task to Project's list
            System.out.println("Task added to Project: " + newTask.getName());  
            System.out.println("Current tasks in project: " + project.getTasks().size());  

            // Add task to the table model
            tableModel.addRow(new Object[]{taskName, taskDescription, ""});
        }
    }
}


