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

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 180, 100, 25);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(180, 180, 70, 25);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(260, 180, 80, 25);
        JRadioButton other = new JRadioButton("Other");
        other.setBounds(350, 180, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);
        frame.add(other);

        JLabel dateofbirthLabel = new JLabel("Date of Birth:");
        dateofbirthLabel.setBounds(30, 220, 100, 25);
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] years = new String[50];
        for (int i = 0; i < 50; i++) years[i] = String.valueOf(2025 - i);

        JComboBox<String> dayBox = new JComboBox<>(days);
        dayBox.setBounds(180, 220, 50, 25);
        JComboBox<String> monthBox = new JComboBox<>(months);
        monthBox.setBounds(240, 220, 70, 25);
        JComboBox<String> yearBox = new JComboBox<>(years);
        yearBox.setBounds(320, 220, 70, 25);

        frame.add(dateofbirthLabel);
        frame.add(dayBox);
        frame.add(monthBox);
        frame.add(yearBox);

        JLabel degreeLabel = new JLabel("Degree:");
        degreeLabel.setBounds(30, 260, 100, 25);
        String[] degrees = {"BSc in IIT", "MSc in IIT"};
        JComboBox<String> degreeBox = new JComboBox<>(degrees);
        degreeBox.setBounds(180, 260, 350, 25);
        frame.add(degreeLabel);
        frame.add(degreeBox);

        JLabel pictureLabel = new JLabel("Picture:");
        pictureLabel.setBounds(30, 300, 100, 25);
        JButton uploadButton = new JButton("Upload");
        uploadButton.setBounds(180, 300, 120, 25);
        JLabel picturePathLabel = new JLabel();
        picturePathLabel.setBounds(310, 300, 220, 25);
        frame.add(pictureLabel);
        frame.add(uploadButton);
        frame.add(picturePathLabel);

        final String[] selectedPicturePath = {""};
        uploadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                selectedPicturePath[0] = file.getAbsolutePath();
                picturePathLabel.setText(selectedPicturePath[0]);
            }
        });

        JLabel positionLabel = new JLabel("Position:");
        positionLabel.setBounds(30, 340, 130, 25);
        String[] positions = {"Goalkeeper", "Defender", "Midfielder", "Striker"};
        JComboBox<String> positionBox = new JComboBox<>(positions);
        positionBox.setBounds(180, 340, 350, 25);
        frame.add(positionLabel);
        frame.add(positionBox);

        JLabel interdepartmentLabel = new JLabel("Played Inter-department?");
        interdepartmentLabel.setBounds(30, 380, 130, 25);
        JCheckBox interdepartmentCheck = new JCheckBox("Yes");
        interdepartmentCheck.setBounds(180, 380, 50, 25);
        JCheckBox interdepartmentCheckNo = new JCheckBox("No");
        interdepartmentCheckNo.setBounds(240, 380, 50, 25);
        ButtonGroup interdepartmentGroup = new ButtonGroup();
        interdepartmentGroup.add(interdepartmentCheck);
        frame.add(interdepartmentLabel);
        frame.add(interdepartmentCheck);
        frame.add(interdepartmentCheckNo);


        JLabel experienceLabel = new JLabel("Experience:");
        experienceLabel.setBounds(30, 420, 130, 25);
        JTextArea experienceArea = new JTextArea();
        experienceArea.setBounds(180, 420, 350, 60);
        frame.add(experienceLabel);
        frame.add(experienceArea);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 500, 120, 30);
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();
            String address = addressField.getText().trim();
            String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : (other.isSelected() ? "Other" : ""));
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String degree = (String) degreeBox.getSelectedItem();
            String picture = selectedPicturePath[0];
            String position = (String) positionBox.getSelectedItem();
            String interDept = interdepartmentCheck.isSelected() ? "Yes" : "No";
            String experience = experienceArea.getText().trim();

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() ||
                    gender.isEmpty() || degree.isEmpty() || picture.isEmpty() ||
                    position.isEmpty() || experience.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try (FileWriter fw = new FileWriter("football_registrations.txt", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    out.println("Name: " + name);
                    out.println("Phone: " + phone);
                    out.println("Email: " + email);
                    out.println("Address: " + address);
                    out.println("Gender: " + gender);
                    out.println("DOB: " + dob);
                    out.println("Degree: " + degree);
                    out.println("Picture: " + picture);
                    out.println("Preferred Position: " + position);
                    out.println("Played Inter-Dept: " + interDept);
                    out.println("Experience: " + experience);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error in saving ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(frame, "Submitted Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                String message = "Registration Details:\n" +
                        "Name: " + name + "\n" +
                        "Phone: " + phone + "\n" +
                        "Email: " + email + "\n" +
                        "Address: " + address + "\n" +
                        "Gender: " + gender + "\n" +
                        "DOB: " + dob + "\n" +
                        "Degree: " + degree + "\n" +
                        "Picture: " + picture + "\n" +
                        "Preferred Position: " + position + "\n" +
                        "Played Inter-Dept: " + interDept + "\n" +
                        "Experience: " + experience + "\n";
                JOptionPane.showMessageDialog(frame, message, "Registration Details", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            }
        });

        frame.setVisible(true);


    }


}
