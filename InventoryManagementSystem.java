import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private JFrame frame;
    private JPanel currentPanel;
    private Map<String, User> users = new HashMap<>();
    private User currentUser;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventoryManagementSystem().initialize());
    }

    private void initialize() {
        frame = new JFrame("Inventory Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame
        showLoginPanel();
        frame.setVisible(true);
    }

    private void showLoginPanel() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBorder(createShadowBorder());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField emailField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        loginPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(loginButton, gbc);

        gbc.gridy = 3;
        loginPanel.add(signupButton, gbc);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            if (authenticateUser(email, password)) {
                showDashboard();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid email or password");
            }
        });

        signupButton.addActionListener(e -> showSignupPanel());

        setCurrentPanel(loginPanel);
    }

    private void showSignupPanel() {
        JPanel signupPanel = new JPanel(new GridBagLayout());
        signupPanel.setBorder(createShadowBorder());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField nameField = new JTextField(15);
        JTextField emailField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton registerButton = new JButton("Register");

        gbc.gridx = 0;
        gbc.gridy = 0;
        signupPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        signupPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        signupPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        signupPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        signupPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        signupPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        signupPanel.add(registerButton, gbc);

        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            if (registerUser(name, email, password)) {
                JOptionPane.showMessageDialog(frame, "Registration successful");
                showLoginPanel();
            }
        });

        setCurrentPanel(signupPanel);
    }

    private void showDashboard() {
        JPanel dashboardPanel = new JPanel(new BorderLayout());
        dashboardPanel.setBorder(createShadowBorder());

        JLabel welcomeLabel = new JLabel("Welcome, " + currentUser.getName() + "!", JLabel.CENTER);
        JButton logoutButton = new JButton("Logout");

        dashboardPanel.add(welcomeLabel, BorderLayout.CENTER);
        dashboardPanel.add(logoutButton, BorderLayout.SOUTH);

        logoutButton.addActionListener(e -> {
            currentUser = null;
            showLoginPanel();
        });

        setCurrentPanel(dashboardPanel);
    }

    private void setCurrentPanel(JPanel panel) {
        if (currentPanel != null) {
            frame.remove(currentPanel);
        }
        currentPanel = panel;
        frame.add(currentPanel);
        frame.revalidate();
        frame.repaint();
    }

    private boolean authenticateUser(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user; // Set the currentUser when authentication is successful
            return true;
        }
        return false;
    }

    private boolean registerUser(String name, String email, String password) {
        if (users.containsKey(email)) {
            JOptionPane.showMessageDialog(frame, "Email already registered");
            return false;
        }
        users.put(email, new User(name, email, password));
        return true;
    }

    private Border createShadowBorder() {
        Border line = BorderFactory.createLineBorder(new Color(100, 100, 255));
        Border empty = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        return BorderFactory.createCompoundBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED),
                BorderFactory.createEtchedBorder()
            ),
            BorderFactory.createCompoundBorder(line, empty)
        );
    }

    private class User {
        private String name;
        private String email;
        private String password;

        public User(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}