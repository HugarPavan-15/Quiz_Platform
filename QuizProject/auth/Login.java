package auth;

import db.UserDAO;
import java.awt.event.ActionEvent;
import javax.swing.*;
import models.User;

public class Login {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 10, 80, 25);
        frame.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(100, 10, 160, 25);
        frame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 40, 80, 25);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 40, 160, 25);
        frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 70, 250, 25);
        frame.add(loginButton);

        loginButton.addActionListener((ActionEvent e) -> {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.loginUser(usernameField.getText(), new String(passwordField.getPassword()));
            if (user != null) {
                JOptionPane.showMessageDialog(frame, "Login successful!");
                // Proceed to quiz dashboard
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials.");
            }
        });

        frame.setVisible(true);
    }
}
