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
    private JPanel dataContainer;
    private JButton saveAllergy, savePrescription;
    private ImageIcon profile, imgIcon;
    private Image image;
    private JLabel img, nextVisit, phone, email, address, allergyLabel, allergyContent, prescriptionLabel;
    private JTextField allergies, prescriptions;
    private String s;
    private Patient patient;
    private PersonalInformation info;
    private static JLabel totalFeeLabel = new JLabel();

    public PatientCardPopup(Patient patient) {
        this.patient = patient.clone();
        this.info = this.patient.getPersonalInfo();

        dataContainer = new JPanel();
        profile = new ImageIcon(patient.getImageURL());
        image = profile.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(image);
        img = new JLabel(imgIcon);
        img.setHorizontalTextPosition(0);
        img.setVerticalTextPosition(0);

        loadWindow();
    }

    private void loadWindow() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout

        InformationPanel informationPanel = new InformationPanel(patient, new Color(0, 0, 0, 0));
        informationPanel.setBorder(new EmptyBorder(10, 20, 0, 0));

        // Add patient information labels
        nextVisit = new JLabel("Next Visit Date: " + patient.getNextVisitDate().toString().substring(0, 19));
        nextVisit.setFont(new Font("Serif", Font.PLAIN, 15));
        phone = new JLabel("Phone Number: " + info.getPhoneNumber());
        phone.setFont(new Font("Serif", Font.PLAIN, 15));
        email = new JLabel("Email Address: " + info.getGmail());
        email.setFont(new Font("Serif", Font.PLAIN, 15));
        address = new JLabel("Address: " + info.getAddress());
        address.setFont(new Font("Serif", Font.PLAIN, 15));

        // Add allergy panel
        JPanel allergyPanel = new JPanel();
        allergyLabel = new JLabel("Allergies");
        allergyContent = new JLabel();
    //    allergyLabel.setFont(new Font("Serif", Font.PLAIN, 18));
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
        allergyPanel.add(allergyLabel);
        allergyPanel.add(allergies);
        allergyPanel.add(saveAllergy);

        // Add prescription panel
        JPanel prescriptionPanel = new JPanel();
        prescriptionLabel = new JLabel("Prescriptions");
        prescriptions = new JTextField("List Prescriptions", 20);
        prescriptions.setBackground(backgroundColor);
        savePrescription = new JButton("Save");
        savePrescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = prescriptions.getText();
                if (s.equals("Save")) {
                    JOptionPane.showMessageDialog(null, "Saved");
                    prescriptionLabel.setText(s);
                }
            }
        });
        prescriptionPanel.add(prescriptionLabel);
        prescriptionPanel.add(prescriptions);
        prescriptionPanel.add(savePrescription);

        // Add components to panel
        informationPanel.add(nextVisit);
        informationPanel.add(phone);
        informationPanel.add(email);
        informationPanel.add(address);

        panel.add(img);
        panel.add(informationPanel);
        panel.add(allergyPanel);
        panel.add(prescriptionPanel);
        panel.add(getProcedurePanel());

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400, 400)); // Set preferred size for JScrollPane

        add(scrollPane);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }



    private static JPanel getProcedurePanel() {
        String[] procedures = {"Surgery", "Appendectomy", "Breast biopsy", "Cataract surgery"};
        int[] fees = {450000, 650000, 250000, 850000};

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
        ImageIcon icon = new ImageIcon("src\\ui\\DefaultImages\\pngimg.com - plus_PNG110.png");
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


    private void inputAllergies() {
        fileName = info.getName() + info.getLastName() + ".pdf";
        try {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName));
            outputStream.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void showAllergies() {
        fileName = info.getName() + info.getLastName() + ".pdf";
        try {
            Scanner inputStream = new Scanner(new FileInputStream(fileName));
            while (inputStream.hasNextLine()) {
                s = inputStream.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}