package ui.PopupWindows;

import model.patient.*;
import ui.Elements.InformationPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class PatientCardPopup extends JDialog {
    private static final Color backgroundColor = new Color(222, 227, 235);
    private static String fileName;
    static JPanel dataContainer;
    static JButton saveAllergy, savePrescription;
    static ImageIcon profile, imgIcon;
    static Image image;
    static JLabel img, name, age, gender, nextVisit, phone, email, address, allergyLabel, allergyContent, prescriptionLabel;
    static JTextField allergies, prescriptions;
    private String s;
    Patient patient;
    PersonalInformation info;
    public static JLabel totalFeeLabel;

    public PatientCardPopup(Patient patient){
        this.patient = patient.clone();
        this.info = this.patient.getPersonalInfo();

        dataContainer = new JPanel();
        profile = new ImageIcon(patient.getImageURL());
        image = profile.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        image = profile.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(image);
        img = new JLabel(imgIcon);
        img.setHorizontalTextPosition(0);
        img.setVerticalTextPosition(0);
        //img.setBounds(0, 0, imgIcon.getIconWidth(), imgIcon.getIconHeight());

        loadWindow();
    }


    private void loadWindow(){
        InformationPanel informationPanel = new InformationPanel(patient, new Color(0,0,0,0));
        informationPanel.setBorder(new EmptyBorder(10,80,0,0));
        informationPanel.setBorder(new EmptyBorder(10,20,0,0));

        JScrollPane scrollPane = new JScrollPane(informationPanel);
        scrollPane.setBounds(0, 10, WIDTH, 550);
        add(scrollPane);

        name = new JLabel("Name: " + info.getName() + " " + info.getLastName());
        name.setFont(new Font("Serif", Font.PLAIN, 15));

        age = new JLabel("Age: " + info.getAge());
        age.setFont(new Font("Serif", Font.PLAIN, 15));

        gender = new JLabel("Gender: " + info.getGender());
        gender.setFont(new Font("Serif", Font.PLAIN, 15));

        //
        nextVisit = new JLabel();
        nextVisit = new JLabel("Next Visit Date: "+ patient.getNextVisitDate().toString().substring(0,19));
        //nextVisit.setFont(new Font("Serif", Font.PLAIN, 15));

        phone = new JLabel("Phone Number: " + info.getPhoneNumber());
        //phone.setFont(new Font("Serif", Font.PLAIN, 15));

        email = new JLabel("Email Address: " + info.getGmail());
        //email.setFont(new Font("Serif", Font.PLAIN, 15));

        address = new JLabel("Address: " + info.getAddress());
        //address.setFont(new Font("Serif", Font.PLAIN, 15));

        allergyLabel = new JLabel("Allergies");
        allergyContent = new JLabel();
        //allergyLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        allergies = new JTextField("List Allergies", 20);
        allergyContent.setPreferredSize(new Dimension(200, 100));
        allergies.setBackground(backgroundColor);
        saveAllergy = new JButton("Save");
        saveAllergy.addActionListener(e -> {
            s = allergies.getText();
            if (s.equals("Save")) {
                JOptionPane.showMessageDialog(null, "Saved");
                allergyContent.setText(s);
            }
        });

        prescriptionLabel = new JLabel("Allergies");
        //prescriptionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        prescriptions = new JTextField("List Prescriptions", 20);
        prescriptions.setBackground(backgroundColor);
        savePrescription = new JButton("Save");
        savePrescription.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = allergies.getText();
                if (s.equals("Save")) {
                    JOptionPane.showMessageDialog(null, "Saved");
                    allergyContent.setText(s);
                    inputAllergies();
                    showAllergies();
                }
            }
        });

        dataContainer.add(img);
        informationPanel.add(nextVisit);
        informationPanel.add(phone);
        informationPanel.add(email);
        informationPanel.add(address);
        informationPanel.add(allergyLabel);
        informationPanel.add(allergies);
        informationPanel.add(saveAllergy);
        informationPanel.add(prescriptionLabel);
        informationPanel.add(prescriptions);
        informationPanel.add(savePrescription);
        dataContainer.add(informationPanel);
        add(dataContainer);
        setPreferredSize(new Dimension(400, 550));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        JPanel questionPanel = getProcedurePanel();
        questionPanel.setBounds(0,300,300,200);
        dataContainer.add(questionPanel);
        totalFeeLabel = new JLabel("Total Fee:");
        dataContainer.add(totalFeeLabel);
    }


        private static JPanel getProcedurePanel() {
            String[] procedures = {"Surgery", "Appendectomy", "Breast biopsy", "Cataract surgery"};
            double[] fees = {1000.0, 1500.0, 800.0, 2000.0};

            JPanel procedurePanel = new JPanel();
            procedurePanel.setLayout(new GridLayout(procedures.length + 1, 1));

            JLabel questionLabel = new JLabel("Procedures and Fees");
            procedurePanel.add(questionLabel);

            JTextField procedureField = new JTextField();
            JTextField feeField = new JTextField();
            JButton addButton = getAddButton(procedureField, feeField, procedurePanel);

            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new GridLayout(1, 5));
            inputPanel.add(addButton);

            procedurePanel.add(inputPanel);

            return procedurePanel;
        }

        private static JButton getAddButton(JTextField procedureField, JTextField feeField, JPanel procedurePanel) {
            ImageIcon icon = new ImageIcon("src\\pngimg.com - plus_PNG110.png");
            Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            JButton addButton = new JButton(icon);
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Select Procedure");
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setLayout(new GridLayout(0, 1));
                    String[] procedures = {"Surgery", "Appendectomy", "Breast biopsy", "Cataract surgery"};
                    double[] fees = {1000.0, 1500.0, 800.0, 2000.0};

                    ButtonGroup buttonGroup = new ButtonGroup();

                    for (int i = 0; i < procedures.length; i++) {
                        JRadioButton radioButton = new JRadioButton(procedures[i]);
                        dialog.add(radioButton);
                        buttonGroup.add(radioButton);

                        final int index = i;

                        radioButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    double selectedFee = fees[index];
                                    final double[] totalFee = {selectedFee};
                                    String newProcedureText = "<html>Procedure: " + procedures[index] + "<br>Fee: $" + selectedFee + "</html>";
                                    JCheckBox newCheckBox = new JCheckBox(newProcedureText);
                                    newCheckBox.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if (newCheckBox.isSelected()) {
                                                totalFee[0] -= selectedFee;
                                            } else {
                                                totalFee[0] += selectedFee;
                                            }
                                            totalFeeLabel.setText("Total Fee: $" + totalFee[0]);
                                        }
                                    });
                                    procedurePanel.add(newCheckBox, procedurePanel.getComponentCount() - 1);
                                    procedurePanel.revalidate();
                                    procedurePanel.repaint();
                                    dialog.dispose();
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(dialog, "Please enter a valid fee amount.");
                                }
                            }
                        });
                    }
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }
            });
            return addButton;
        }


    private void inputAllergies(){
        fileName = info.getName() + info.getLastName() + ".pdf";
        try{
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName));
            outputStream.println(s);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private void showAllergies(){
        fileName = info.getName() + info.getLastName() + ".pdf";
        try{
            Scanner inputStream = new Scanner(new FileInputStream(fileName));
            while(inputStream.hasNextLine()){
                s = inputStream.nextLine();
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}