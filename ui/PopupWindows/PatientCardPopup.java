package ui.PopupWindows;

import model.patient.*;

import ui.Elements.InformationPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;

public class PatientCardPopup extends JDialog {
    private static final Color backgroundColor = new Color(222, 227, 235);
    private String fileName;
    private final JLabel img;
    private JTextArea allergies, prescriptions;
    private String allergyText, prescriptionText;
    private final Patient patient;
    private final PersonalInformation info;
    private final History history = new History();
    Payments payments = new Payments();
    private final JLabel totalFeeLabel = new JLabel();

    /**
     * Constructs a patient's medical card
     *
     * @param patient the <code>Patient</code> patient whose medical
     *                card is being constructed
     */
    public PatientCardPopup(Patient patient) {
        this.patient = patient.clone();
        this.info = this.patient.getPersonalInfo();
        patient.setPayments(payments);
        ImageIcon profile = new ImageIcon(patient.getImageURL());
        Image image = profile.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(image);
        img = new JLabel(imgIcon);
        img.setHorizontalTextPosition(0);
        img.setVerticalTextPosition(0);
        writePrescriptions(prescriptionText);
        writeAllergies(allergyText);
        readAllergies();
        readPrescriptions();
        loadWindow();
    }

    /**
     * Loads the window displaying the medical card
     */
    private void loadWindow() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout

        InformationPanel informationPanel = new InformationPanel(patient, new Color(0, 0, 0, 0));
        informationPanel.setBorder(new EmptyBorder(10, 20, 0, 0));

        // Add patient information labels
        JLabel nextVisit = new JLabel("Next Visit Date: " + patient.getNextVisitDate().toString().substring(0, 19));
        nextVisit.setFont(new Font("Serif", Font.PLAIN, 15));
        JLabel phone = new JLabel("Phone Number: " + info.getPhoneNumber());
        phone.setFont(new Font("Serif", Font.PLAIN, 15));
        JLabel email = new JLabel("Email Address: " + info.getGmail());
        email.setFont(new Font("Serif", Font.PLAIN, 15));
        JLabel address = new JLabel("Address: " + info.getAddress());
        address.setFont(new Font("Serif", Font.PLAIN, 15));

        // Add allergy panel
        JPanel allergyPanel = new JPanel();
        allergies = new JTextArea(10, 30);
        allergies.setLineWrap(true);
        //allergies.setText("List Allergies");
        allergies.append("\n" + allergyText);
        allergies.setBackground(backgroundColor);
        JButton saveAllergy = getSaveAllergy();
        allergyPanel.add(allergies);
        allergyPanel.add(saveAllergy);

        // Add prescription panel
        JPanel prescriptionPanel = new JPanel();
        prescriptions = new JTextArea(10, 30);
        prescriptions.setLineWrap(true);
        //prescriptions.setText("List Prescriptions");
        prescriptions.append("\n" + prescriptionText);
        prescriptions.setBackground(backgroundColor);
        JButton savePrescription = getSavePrescription();
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
        scrollPane.setPreferredSize(new Dimension(500, 400)); // Set preferred size for JScrollPane
        JButton okButton = getOkButton();
        panel.add(okButton);
        add(scrollPane);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public JButton getSaveAllergy() {
        JButton saveAllergy = new JButton("Save");
        saveAllergy.addActionListener(e -> {
            allergyText = allergies.getText();
            JOptionPane.showMessageDialog(null, "Saved");
        });
        return saveAllergy;
    }

    private JButton getSavePrescription() {
        JButton savePrescription = new JButton("Save");
        savePrescription.addActionListener(e -> {
            prescriptionText = prescriptions.getText();
            JOptionPane.showMessageDialog(null, "Saved");
        });
        return savePrescription;
    }

    private JButton getOkButton() {
        JButton okButton = new JButton("Ok");
        okButton.setSize(100, 60);
        okButton.addActionListener(e -> {

            history.setAllergies(allergyText);
            history.setPrescriptions(prescriptionText);
            patient.setHistory(history);
            writeAllergies(allergyText);
            writePrescriptions(prescriptionText);
            System.out.println(patient.getHistory().getPrescriptions() + " " + patient.getHistory().getAllergies());
            closeWindow();
        });

        return okButton;
    }

    /**
     *
     */
    private JPanel getProcedurePanel() {
        String[] procedures = {"Surgery", "Appendectomy", "Breast biopsy", "Cataract surgery"};

        JPanel procedurePanel = new JPanel();
        procedurePanel.setLayout(new GridLayout(procedures.length + 2, 1));

        JLabel questionLabel = new JLabel("Procedures and Fees");
        procedurePanel.add(questionLabel);

        JButton addButton = getAddFeeButton(procedurePanel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 5));
        inputPanel.add(addButton);
        procedurePanel.add(inputPanel);

        totalFeeLabel.setText("Total Unpaid Fee: AMD 0.0");
        procedurePanel.add(totalFeeLabel);

        return procedurePanel;
    }

    private JButton getAddFeeButton(JPanel procedurePanel) {
        //    patient.setPayments(payments);

        ImageIcon icon = new ImageIcon("src\\ui\\DefaultImages\\pngimg.com - plus_PNG110.png");
        Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JButton addButton = new JButton(icon);
        addButton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setTitle("Select Procedure");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setLayout(new GridLayout(0, 1));
            String[] procedures = {"Appendectomy", "Breast biopsy", "Cataract surgery", "MRI", "CT", "Blood analysis"};

            ButtonGroup buttonGroup = new ButtonGroup();

            for (int i = 0; i < procedures.length; i++) {
                JRadioButton radioButton = new JRadioButton(procedures[i]);
                dialog.add(radioButton);
                buttonGroup.add(radioButton);

                final int index = i;

                radioButton.addActionListener(e1 -> {
                    try {
                        JDialog feeDialog = new JDialog();
                        feeDialog.setTitle("Select Fee");
                        feeDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        feeDialog.setLayout(new GridLayout(0, 1));

                        SpinnerModel spinnerModel = new SpinnerNumberModel(20000, 10000, 2000000, 1000);
                        JSpinner spinner = getjSpinner(spinnerModel);

                        JButton confirmButton = new JButton("Confirm Fee");
                        confirmButton.addActionListener(e11 -> {
                            int fee = (int) spinner.getValue();
                            Payments.Fee newFee = new Payments.Fee(false, fee);
                            String newProcedureText = "<html>Procedure: " + procedures[index] + "<br>Fee: AMD" + newFee + "</html>";
                            JCheckBox newCheckBox = new JCheckBox(newProcedureText);
                            patient.addDiscountedFee(newFee);
                            newCheckBox.addActionListener(e111 -> {
                                if (newCheckBox.isSelected()) {
                                    newFee.setWasPaid(true);
                                    totalFeeLabel.setText("Total Unpaid Fees: " + (patient.countUnpaidFees()) + " AMD");
                                } else {
                                    newFee.setWasPaid(false);
                                    totalFeeLabel.setText("Total Unpaid Fees: " + (patient.countUnpaidFees()) + " AMD");
                                }
                            });
                            totalFeeLabel.setText("Total Fee: " + (patient.countUnpaidFees()) + " AMD");
                            procedurePanel.add(newCheckBox, procedurePanel.getComponentCount() - 2);
                            procedurePanel.revalidate();
                            procedurePanel.repaint();
                            feeDialog.dispose();
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
                });
            }
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        });
        return addButton;
    }

    private JSpinner getjSpinner(SpinnerModel spinnerModel) {
        JSpinner spinner = new JSpinner(spinnerModel);
        spinner.setPreferredSize(new Dimension(100, 30));
        return spinner;
    }


    /**
     * Reads the allergies a patient has
     */
    private void writeAllergies(String allergies) {
        fileName = info.getName() + info.getLastName() + "allergies.txt";
        try {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("src/ui/PatientFiles/" + fileName, true));
            if (allergies != null)
                outputStream.println(allergies);
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Displays the allergies the patient has
     */
    private void readAllergies() {
        fileName = info.getName() + info.getLastName() + "allergies.txt";
        StringBuilder str = new StringBuilder();
        try {
            Scanner inputStream = new Scanner(new FileInputStream("src/ui/PatientFiles/" + fileName));
            while (inputStream.hasNextLine()) {
                str.append(inputStream.nextLine());
            }
            allergyText = str.toString();
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads the prescriptions a patient has
     */
    private void writePrescriptions(String prescriptions) {
        fileName = info.getName() + info.getLastName() + "prescriptions.txt";
        try {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("src/ui/PatientFiles/" + fileName, true));
            if (prescriptions != null)
                outputStream.println(prescriptions);
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Displays the prescriptions the patient has
     */
    private void readPrescriptions() {
        fileName = info.getName() + info.getLastName() + "prescriptions.txt";
        StringBuilder str = new StringBuilder();
        try {
            Scanner inputStream = new Scanner(new FileInputStream("src/ui/PatientFiles/" + fileName));
            while (inputStream.hasNextLine()) {
                str.append(inputStream.nextLine());
            }
            prescriptionText = str.toString();
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Closes the medical card and returns to HomePage
     */
    private void closeWindow() {
        WindowEvent we = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
        setVisible(false);
    }
}