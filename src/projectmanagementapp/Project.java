package projectmanagementapp;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private String description;
    private String Type;
    private List<Task> tasks;
    private double budget;

    public Project() {
        tasks = new ArrayList<>();
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public Project(String name, String description, String Type) {
        this.name = name;
        this.description = description;
        this.Type = Type;

    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getType() {
        return Type;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public String getDescription() {
        return description;
    }


}
