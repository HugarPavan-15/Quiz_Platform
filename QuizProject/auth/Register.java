package auth;

import db.UserDAO;
import java.awt.event.ActionEvent;
import javax.swing.*;
import models.User;

public class Register {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Register");
        frame.setSize(300, 200);
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

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 70, 80, 25);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(100, 70, 160, 25);
        frame.add(emailField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(10, 100, 250, 25);
        frame.add(registerButton);

        registerButton.addActionListener((ActionEvent e) -> {
            User user = new User();
            user.setUsername(usernameField.getText());
            user.setPassword(new String(passwordField.getPassword()));
            user.setEmail(emailField.getText());
            
            UserDAO userDAO = new UserDAO();
            if (userDAO.registerUser(user)) {
                JOptionPane.showMessageDialog(frame, "Registration successful!");
            } else {
                JOptionPane.showMessageDialog(frame, "Registration failed.");
            }
        });

        frame.setVisible(true);
    }
}
