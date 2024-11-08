package projectmanagementapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

public class ProjectManagementApp extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private CommandInvoker commandInvoker;
    Project project = new Project();
    private JTable taskTable;

    public ProjectManagementApp() {
        commandInvoker = new CommandInvoker();
        setTitle("Project Management App");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel homePanel = createHomePanel();

        mainPanel.add(homePanel, "homeScreen");

        add(mainPanel);

        cardLayout.show(mainPanel, "homeScreen");
    }

    private JPanel createHomePanel() {
        ImageIcon backgroundIcon = new ImageIcon("Background.png");
        Image backgroundImage = backgroundIcon.getImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setLayout(null);

        JLabel projectLabel = new JLabel("Project");
        projectLabel.setFont(new Font("Arial", Font.BOLD, 58));
        projectLabel.setForeground(Color.BLACK);
        projectLabel.setBounds(400, 150, 300, 60);
        panel.add(projectLabel);

        JLabel managementLabel = new JLabel("Management App");
        managementLabel.setFont(new Font("Arial", Font.BOLD, 58));
        managementLabel.setForeground(Color.BLACK);
        managementLabel.setBounds(250, 240, 550, 80);
        panel.add(managementLabel);

        JButton loginButton = new JButton("LOG IN");
        loginButton.setBounds(310, 370, 150, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(230, 230, 250));
        loginButton.setForeground(Color.BLACK);
        loginButton.addActionListener(e -> showLoginScreen());
        panel.add(loginButton);

        JButton signupButton = new JButton("SIGN UP");
        signupButton.setBounds(500, 370, 150, 40);
        signupButton.setFont(new Font("Arial", Font.BOLD, 16));
        signupButton.setBackground(new Color(230, 230, 250));
        signupButton.setForeground(Color.BLACK);
        signupButton.addActionListener(e -> showSignupScreen());
        panel.add(signupButton);

        return panel;
    }

    private void showLoginScreen() {

        if (mainPanel.getComponentCount() < 2) {
            JPanel loginPanel = createLoginScreen();
            mainPanel.add(loginPanel, "loginScreen");
        }

        cardLayout.show(mainPanel, "loginScreen");
    }

    public JPanel createLoginScreen() {
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundIcon = new ImageIcon("Background.png");
                g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        loginPanel.setLayout(null);

        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(new Color(255, 255, 255, 150));
        whitePanel.setBounds(300, 150, 400, 250);
        whitePanel.setLayout(null);
        whitePanel.setOpaque(true);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        emailLabel.setBounds(50, 50, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 50, 200, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        passwordLabel.setBounds(50, 100, 100, 25);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 25);

        JButton loginBtn = new JButton("LOG IN");
        loginBtn.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        loginBtn.setBackground(new Color(230, 230, 250));
        loginBtn.setBounds(150, 180, 100, 30);
        loginBtn.addActionListener(e -> showHomeScreen());
        loginPanel.add(loginBtn);

        whitePanel.add(emailLabel);
        whitePanel.add(emailField);
        whitePanel.add(passwordLabel);
        whitePanel.add(passwordField);
        whitePanel.add(loginBtn);

        loginPanel.add(whitePanel);

        return loginPanel;
    }

    private void showSignupScreen() {

        if (mainPanel.getComponentCount() < 3) {
            JPanel signupPanel = createSignupScreen();
            mainPanel.add(signupPanel, "signupScreen");
        }

        cardLayout.show(mainPanel, "signupScreen");
    }

    public JPanel createSignupScreen() {
        JPanel signupPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundIcon = new ImageIcon("Background.png");
                g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        signupPanel.setLayout(null);

        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(new Color(255, 255, 255, 150));
        whitePanel.setBounds(300, 100, 400, 350);
        whitePanel.setLayout(null);
        whitePanel.setOpaque(true);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        nameLabel.setBounds(50, 50, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 25);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        phoneLabel.setBounds(50, 100, 100, 25);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 100, 200, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        emailLabel.setBounds(50, 150, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 150, 200, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        passwordLabel.setBounds(50, 200, 100, 25);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 200, 200, 25);

        JButton signupBtn = new JButton("SIGN UP");
        signupBtn.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        signupBtn.setBackground(new Color(230, 230, 250));
        signupBtn.setBounds(150, 280, 100, 30);
        signupBtn.addActionListener(e -> showHomeScreen());
        signupPanel.add(signupBtn);

        whitePanel.add(nameLabel);
        whitePanel.add(nameField);
        whitePanel.add(phoneLabel);
        whitePanel.add(phoneField);
        whitePanel.add(emailLabel);
        whitePanel.add(emailField);
        whitePanel.add(passwordLabel);
        whitePanel.add(passwordField);
        whitePanel.add(signupBtn);

        signupPanel.add(whitePanel);

        return signupPanel;
    }

    private void showHomeScreen() {

        if (mainPanel.getComponentCount() < 3) {
            JPanel homeImagePanel = createHomeImagePanel();
            mainPanel.add(homeImagePanel, "homeImageScreen");
        }

        cardLayout.show(mainPanel, "homeImageScreen");
    }

    private JPanel createHomeImagePanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon homeIcon = new ImageIcon("Home.png");
                Image homeImage = homeIcon.getImage();

                if (homeImage != null) {
                    g.drawImage(homeImage, 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Error: Home image not found or failed to load.");
                }
            }
        };
        panel.setLayout(null);

        // Create new project
        JButton createProjectButton = new JButton("");
        createProjectButton.setBounds(50, 220, 150, 40);
        createProjectButton.setFocusPainted(false);
        createProjectButton.setContentAreaFilled(false);
        createProjectButton.setOpaque(false);
        createProjectButton.setBorderPainted(false);
        createProjectButton.addActionListener(e -> showProjectTypeOptions(panel));
        panel.add(createProjectButton);

        // "Show projects"
        JButton showProjectsButton = new JButton("");
        showProjectsButton.setBounds(50, 290, 150, 40);
        showProjectsButton.setFocusPainted(false);
        showProjectsButton.setContentAreaFilled(false);
        showProjectsButton.setOpaque(false);
        showProjectsButton.setBorderPainted(false);
        panel.add(showProjectsButton);

        // "Add friends"
        JButton addFriendsButton = new JButton("");
        addFriendsButton.setBounds(50, 360, 150, 40);
        addFriendsButton.setFocusPainted(false);
        addFriendsButton.setContentAreaFilled(false);
        addFriendsButton.setOpaque(false);
        addFriendsButton.setBorderPainted(false);
        addFriendsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Add friends clicked"));
        panel.add(addFriendsButton);

        // "Settings"
        JButton settingsButton = new JButton("");
        settingsButton.setBounds(50, 430, 150, 40);
        settingsButton.setFocusPainted(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setOpaque(false);
        settingsButton.setBorderPainted(false);
        settingsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Settings clicked"));
        panel.add(settingsButton);

        return panel;
    }

    private void showProjectTypeOptions(JPanel parentPanel) {

        JLabel titleLabel = new JLabel("Select type of the project");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(350, 90, 500, 50);

        parentPanel.add(titleLabel);

        JPanel projectOptionsPanel = new JPanel();
        projectOptionsPanel.setBounds(350, 150, 500, 300);
        projectOptionsPanel.setBackground(new Color(255, 255, 255, 180));
        projectOptionsPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color buttonColor = new Color(230, 230, 250);

        JButton basicProjectButton = new JButton("Basic Project");
        basicProjectButton.setFont(buttonFont);
        basicProjectButton.setBackground(buttonColor);
        basicProjectButton.setFocusPainted(false);
        basicProjectButton.setPreferredSize(new Dimension(200, 40));
        basicProjectButton.addActionListener(e -> showTaskTable());
        projectOptionsPanel.add(basicProjectButton, gbc);

        gbc.gridy++;
        JButton teamProjectButton = new JButton("Team Project");
        teamProjectButton.setFont(buttonFont);
        teamProjectButton.setBackground(buttonColor);
        teamProjectButton.setFocusPainted(false);
        teamProjectButton.setPreferredSize(new Dimension(200, 40));
        teamProjectButton.addActionListener(e -> showTeamProjectPanel());
        projectOptionsPanel.add(teamProjectButton, gbc);

        gbc.gridy++;
        JButton budgetProjectButton = new JButton("Budget Project");
        budgetProjectButton.setFont(buttonFont);
        budgetProjectButton.setBackground(buttonColor);
        budgetProjectButton.setFocusPainted(false);
        budgetProjectButton.setPreferredSize(new Dimension(200, 40));
        budgetProjectButton.addActionListener(e -> showBudgetProjectPanel());
        projectOptionsPanel.add(budgetProjectButton, gbc);

        gbc.gridy++;
        JButton createButton = new JButton("Create");
        createButton.setFont(buttonFont);
        createButton.setBackground(new Color(150, 150, 200));
        createButton.setForeground(Color.WHITE);
        createButton.setFocusPainted(false);
        createButton.setPreferredSize(new Dimension(130, 50));
        createButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Project Created"));
        projectOptionsPanel.add(createButton, gbc);

        parentPanel.add(projectOptionsPanel);
        parentPanel.revalidate();
        parentPanel.repaint();
    }

    private void showTaskTable() {
        JPanel taskPanel = new JPanel(new BorderLayout());
        taskPanel.setBackground(new Color(245, 240, 255));

        JLabel titleLabel = new JLabel("Basic Project");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(100, 50, 150));
        taskPanel.add(titleLabel, BorderLayout.NORTH);

        String[] columns = {"Task Name", "Description", "Subtasks"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        taskTable = new JTable(model);  // Only declare and initialize taskTable

        taskTable.setRowSelectionAllowed(true);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Allow selecting only one row at a time

        taskTable.setFont(new Font("Arial", Font.PLAIN, 14));
        taskTable.setRowHeight(25);
        taskTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        taskTable.getTableHeader().setBackground(new Color(220, 200, 255));
        JScrollPane scrollPane = new JScrollPane(taskTable);
        taskPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(245, 240, 255));

        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addTaskButton.setBackground(new Color(180, 160, 220));
        addTaskButton.setForeground(Color.WHITE);
        addTaskButton.setFocusPainted(false);
        addTaskButton.setEnabled(true);

        //Command pattern for adding Task
        addTaskButton.addActionListener(e -> {
            CommandInvoker commandInvoker = new CommandInvoker();
            commandInvoker.setCommand(new AddTaskCommand(model, project));
            commandInvoker.executeCommand();
        });

        JButton addSubtaskButton = new JButton("Add Subtask");
        addSubtaskButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addSubtaskButton.setBackground(new Color(150, 130, 190));
        addSubtaskButton.setForeground(Color.WHITE);
        addSubtaskButton.setFocusPainted(false);
        addSubtaskButton.setEnabled(true);

        //Command pattern for adding subTask
        addSubtaskButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> {
                int selectedRow = taskTable.getSelectedRow();
                System.out.println("Selected Row in invokeLater: " + selectedRow);

                if (selectedRow != -1) {
                    CommandInvoker commandInvoker = new CommandInvoker();
                    commandInvoker.setCommand(new AddSubtaskCommand(model, taskTable, project));
                    commandInvoker.executeCommand();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a task to add a subtask.");
                }
            });
        });

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setBackground(new Color(200, 100, 100));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "homeScreen"));

        buttonPanel.add(addTaskButton);
        buttonPanel.add(addSubtaskButton);
        buttonPanel.add(backButton);
        taskPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(taskPanel, "taskScreen");
        cardLayout.show(mainPanel, "taskScreen");
    }

    private void showTeamProjectPanel() {
        JPanel teamProjectPanel = new JPanel(new BorderLayout());
        teamProjectPanel.setBackground(new Color(245, 240, 255));

        JLabel titleLabel = new JLabel("Team Project");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(100, 50, 150));
        teamProjectPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(245, 240, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;

        JPanel teamPanel = new JPanel(new BorderLayout());
        teamPanel.setBackground(new Color(245, 240, 255));
        teamPanel.setBorder(BorderFactory.createTitledBorder("Team Members"));

        DefaultListModel<String> teamListModel = new DefaultListModel<>();
        JList<String> teamList = new JList<>(teamListModel);
        JScrollPane teamScrollPane = new JScrollPane(teamList);
        teamPanel.add(teamScrollPane, BorderLayout.CENTER);

        JButton addMemberButton = new JButton("Add Member");
        addMemberButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addMemberButton.setBackground(new Color(180, 160, 220));
        addMemberButton.setForeground(Color.WHITE);
        addMemberButton.setFocusPainted(false);

        // Command pattern for adding member
        addMemberButton.addActionListener(e -> {
            CommandInvoker commandInvoker = new CommandInvoker();
            AddMemberCommand addMemberCommand = new AddMemberCommand(teamListModel);
            commandInvoker.setCommand(addMemberCommand);
            commandInvoker.executeCommand();  // Execute the command to add a member
        });
        teamPanel.add(addMemberButton, BorderLayout.SOUTH);

        contentPanel.add(teamPanel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;

        JPanel taskPanel = new JPanel(new BorderLayout());
        taskPanel.setBackground(new Color(245, 240, 255));
        taskPanel.setBorder(BorderFactory.createTitledBorder("Tasks"));

        String[] columns = {"Task Name", "Description", "Subtasks"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        taskTable = new JTable(model);  // Only declare and initialize taskTable

        taskTable.setRowSelectionAllowed(true);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Allow selecting only one row at a time

        taskTable.setFont(new Font("Arial", Font.PLAIN, 14));
        taskTable.setRowHeight(25);
        taskTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        taskTable.getTableHeader().setBackground(new Color(220, 200, 255));
        JScrollPane scrollPane = new JScrollPane(taskTable);
        taskPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel taskButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        taskButtonPanel.setBackground(new Color(245, 240, 255));

        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addTaskButton.setBackground(new Color(120, 100, 160));
        addTaskButton.setForeground(Color.WHITE);
        addTaskButton.setFocusPainted(false);
        addTaskButton.setEnabled(true);

        //Command pattern for adding Task
        addTaskButton.addActionListener(e -> {
            CommandInvoker commandInvoker = new CommandInvoker();
            commandInvoker.setCommand(new AddTaskCommand(model, project));
            commandInvoker.executeCommand();
        });

        JButton addSubtaskButton = new JButton("Add Subtask");
        addSubtaskButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addSubtaskButton.setBackground(new Color(120, 100, 160));
        addSubtaskButton.setForeground(Color.WHITE);
        addSubtaskButton.setFocusPainted(false);
        addSubtaskButton.setEnabled(true);

        //Command pattern for adding SubTask
        addSubtaskButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> {
                int selectedRow = taskTable.getSelectedRow();
                System.out.println("Selected Row in invokeLater: " + selectedRow);

                if (selectedRow != -1) {
                    CommandInvoker commandInvoker = new CommandInvoker();
                    commandInvoker.setCommand(new AddSubtaskCommand(model, taskTable, project));
                    commandInvoker.executeCommand();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a task to add a subtask.");
                }
            });
        });

        taskButtonPanel.add(addTaskButton);
        taskButtonPanel.add(addSubtaskButton);
        taskPanel.add(taskButtonPanel, BorderLayout.SOUTH);

        contentPanel.add(taskPanel, gbc);

        teamProjectPanel.add(contentPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setBackground(new Color(200, 100, 100));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        teamProjectPanel.add(backButton, BorderLayout.SOUTH);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "homeScreen"));

        mainPanel.add(teamProjectPanel, "teamProjectScreen");
        cardLayout.show(mainPanel, "teamProjectScreen");
    }

    private void showBudgetProjectPanel() {
        JPanel budgetProjectPanel = new JPanel(new BorderLayout());
        budgetProjectPanel.setBackground(new Color(245, 240, 255));

        JLabel titleLabel = new JLabel("Budget Project");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(100, 50, 150));
        budgetProjectPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(245, 240, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;

        JPanel teamPanel = new JPanel(new BorderLayout());
        teamPanel.setBackground(new Color(245, 240, 255));
        teamPanel.setBorder(BorderFactory.createTitledBorder("Team Members"));

        DefaultListModel<String> teamListModel = new DefaultListModel<>();
        JList<String> teamList = new JList<>(teamListModel);
        JScrollPane teamScrollPane = new JScrollPane(teamList);
        teamPanel.add(teamScrollPane, BorderLayout.CENTER);

        JButton addMemberButton = new JButton("Add Member");
        addMemberButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addMemberButton.setBackground(new Color(180, 160, 220));
        addMemberButton.setForeground(Color.WHITE);
        addMemberButton.setFocusPainted(false);

        // Command pattern for adding member
        addMemberButton.addActionListener(e -> {
            CommandInvoker commandInvoker = new CommandInvoker();
            AddMemberCommand addMemberCommand = new AddMemberCommand(teamListModel);
            commandInvoker.setCommand(addMemberCommand);
            commandInvoker.executeCommand();  // Execute the command to add a member
        });

        teamPanel.add(addMemberButton, BorderLayout.SOUTH);
        contentPanel.add(teamPanel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;

        JPanel taskPanel = new JPanel(new BorderLayout());
        taskPanel.setBackground(new Color(245, 240, 255));
        taskPanel.setBorder(BorderFactory.createTitledBorder("Tasks"));

        String[] columns = {"Task Name", "Description", "Subtasks"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        taskTable = new JTable(model);  // Only declare and initialize taskTable

        taskTable.setRowSelectionAllowed(true);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Allow selecting only one row at a time
        taskTable.setFont(new Font("Arial", Font.PLAIN, 14));
        taskTable.setRowHeight(25);
        taskTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        taskTable.getTableHeader().setBackground(new Color(220, 200, 255));
        JScrollPane scrollPane = new JScrollPane(taskTable);
        taskPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel taskButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        taskButtonPanel.setBackground(new Color(245, 240, 255));

        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addTaskButton.setBackground(new Color(150, 130, 190));
        addTaskButton.setForeground(Color.WHITE);
        addTaskButton.setFocusPainted(false);
        addTaskButton.setEnabled(true);

        //Command pattern for adding Task
        addTaskButton.addActionListener(e -> {
            CommandInvoker commandInvoker = new CommandInvoker();
            commandInvoker.setCommand(new AddTaskCommand(model, project));
            commandInvoker.executeCommand();
        });

        JButton addSubtaskButton = new JButton("Add Subtask");
        addSubtaskButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addSubtaskButton.setBackground(new Color(120, 100, 160));
        addSubtaskButton.setForeground(Color.WHITE);
        addSubtaskButton.setFocusPainted(false);
        addSubtaskButton.setEnabled(true);

        //Command pattern for adding SubTask
        addSubtaskButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> {
                int selectedRow = taskTable.getSelectedRow();
                System.out.println("Selected Row in invokeLater: " + selectedRow);

                if (selectedRow != -1) {
                    CommandInvoker commandInvoker = new CommandInvoker();
                    commandInvoker.setCommand(new AddSubtaskCommand(model, taskTable, project));
                    commandInvoker.executeCommand();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a task to add a subtask.");
                }
            });
        });

        taskButtonPanel.add(addTaskButton);
        taskButtonPanel.add(addSubtaskButton);
        taskPanel.add(taskButtonPanel, BorderLayout.SOUTH);

        contentPanel.add(taskPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;

        JPanel budgetPanel = new JPanel();
        budgetPanel.setBackground(new Color(245, 240, 255));
        budgetPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel budgetLabel = new JLabel("Project Budget:");
        budgetLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField budgetField = new JTextField(10);
        budgetField.setFont(new Font("Arial", Font.PLAIN, 16));

        budgetPanel.add(budgetLabel);
        budgetPanel.add(budgetField);

        contentPanel.add(budgetPanel, gbc);

        budgetProjectPanel.add(contentPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setBackground(new Color(200, 100, 100));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        budgetProjectPanel.add(backButton, BorderLayout.SOUTH);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "homeScreen"));

        mainPanel.add(budgetProjectPanel, "budgetProjectScreen");
        cardLayout.show(mainPanel, "budgetProjectScreen");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProjectManagementApp gui = new ProjectManagementApp();
            gui.setVisible(true);
        });
    }
}
