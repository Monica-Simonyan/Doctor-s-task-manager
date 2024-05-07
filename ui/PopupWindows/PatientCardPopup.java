package ui.PopupWindows;

import model.patient.*;

import ui.Elements.InformationPanel;
import ui.HomePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;

public class PatientCardPopup extends JDialog {
    private static final Color backgroundColor = new Color(222, 227, 235);
    private static String fileName;
    private JPanel dataContainer;
    private JButton saveAllergy, savePrescription, back;
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

        back = new JButton("Back");
        back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });

        prescriptionPanel.add(prescriptionLabel);
        prescriptionPanel.add(prescriptions);
        prescriptionPanel.add(savePrescription);
        prescriptionPanel.add(back);

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



    private JPanel getProcedurePanel() {
        String[] procedures = {"Surgery", "Appendectomy", "Breast biopsy", "Cataract surgery"};

        JPanel procedurePanel = new JPanel();
        procedurePanel.setLayout(new GridLayout(procedures.length + 2, 1));

        JLabel questionLabel = new JLabel("Procedures and Fees");
        procedurePanel.add(questionLabel);

        JTextField procedureField = new JTextField();
        JTextField feeField = new JTextField();
        JButton addButton = getAddButton(procedureField, feeField, procedurePanel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 5));
        inputPanel.add(addButton);

        procedurePanel.add(inputPanel);

        totalFeeLabel.setText("Total Payments: AMD 0.0");
        procedurePanel.add(totalFeeLabel);

        return procedurePanel;
    }

    private JButton getAddButton(JTextField procedureField, JTextField feeField, JPanel procedurePanel) {
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
                                JDialog feeDialog = new JDialog();
                                feeDialog.setTitle("Select Fee");
                                feeDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                                feeDialog.setLayout(new GridLayout(0, 1));

                                SpinnerModel spinnerModel = new SpinnerNumberModel(20000, 10000, 2000000, 1000); // Initial value, minimum value, maximum value, step size
                                JSpinner spinner = getjSpinner(spinnerModel);

                                JButton confirmButton = new JButton("Confirm Fee");
                                confirmButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int fee = (int) spinner.getValue();
                                        String newProcedureText = "<html>Procedure: " + procedures[index] + "<br>Fee: AMD" + fee + "</html>";
                                        JCheckBox newCheckBox = new JCheckBox(newProcedureText);
                                        newCheckBox.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                if (!newCheckBox.isSelected()) {
                                                    totalFeeLabel.setText("Total Payments: AMD" + (extractAmount(totalFeeLabel.getText()) + fee));
                                                } else {
                                                    totalFeeLabel.setText("Total Payments: AMD" + (extractAmount(totalFeeLabel.getText()) - fee));
                                                }
                                            }
                                        });
                                        procedurePanel.add(newCheckBox, procedurePanel.getComponentCount() - 2);
                                        procedurePanel.revalidate();
                                        procedurePanel.repaint();
                                        feeDialog.dispose();
                                    }
                                });

                                feeDialog.add(spinner);
                                feeDialog.add(confirmButton);
                                feeDialog.pack();
                                feeDialog.setLocationRelativeTo(null);
                                feeDialog.setVisible(true);

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

    private JSpinner getjSpinner(SpinnerModel spinnerModel) {
        JSpinner spinner = new JSpinner(spinnerModel);
        spinner.setPreferredSize(new Dimension(100, 30));
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int amount = (int) spinner.getValue();
                // Add the amount to the total fee
                totalFeeLabel.setText("Total Payments: AMD" + amount);
            }
        });
        return spinner;
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
    private int extractAmount(String labelText) {
        int amount = 0;
        String[] parts = labelText.split("AMD");
        if (parts.length > 1) {
            try {
                amount = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return amount;
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

    private void closeWindow(){
        WindowEvent we = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
        setVisible(false);
    }
}