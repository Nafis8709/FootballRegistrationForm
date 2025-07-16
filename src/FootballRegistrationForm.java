import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class FootballRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IITDU Football League Registration Form");
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel namelabel = new JLabel("Name:");
        namelabel.setBounds(30, 20, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(180, 20, 350, 25);
        frame.add(namelabel);
        frame.add(nameField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 60, 100, 25);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(180, 60, 350, 25);
        frame.add(phoneLabel);
        frame.add(phoneField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 100, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(180, 100, 350, 25);
        frame.add(emailLabel);
        frame.add(emailField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 140, 100, 25);
        JTextField addressField = new JTextField();
        addressField.setBounds(180, 140, 350, 25);
        frame.add(addressLabel);
        frame.add(addressField);


    }


}
