package ui;

import model.patient.Patient;
import model.patient.PersonalInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class PatientList extends JFrame {
    static final int WIDTH = 300;
    static final int HEIGHT = 600;
    ArrayList<Patient> patients;
    JPanel searchPanel;
    JPanel listPanel;
    JTextField search;
    JTextArea area;
    JButton searchButton;

    public PatientList() {

        listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(0, 1));
        JScrollPane scrollPane = new JScrollPane(listPanel);

        // Set up scrolling options
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        AddButton addButton = new AddButton(50, listPanel);
        addButton.setBackground(Color.WHITE);
        addButton.setBounds( 200, 200, 50, 50);
        JPanel btnP = new JPanel();
        btnP.setSize(WIDTH, addButton.HEIGHT);
        btnP.setLayout(null);
        btnP.add(addButton);
        add(btnP);

        // Add the scroll pane to the frame
        add(scrollPane);
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem("mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem("mno", "lastName", 14, PersonalInformation.Gender.FEMALE));

        search = new JTextField(5);
        searchButton = new JButton("Search");
        area = new JTextArea(10, 30);
        area.setEditable(false);

        searchButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //search();
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(0, 1));
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Patient List");

        searchPanel = new JPanel();
        searchPanel.add(new JLabel("Find patient..."));
        searchPanel.add(search);
        searchPanel.add(searchButton);

        getContentPane().add(searchPanel, "North");
        getContentPane().add(new JScrollPane(area), "Center");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /*
    private void search() {
        String query = search.getText();
        StringBuilder results = new StringBuilder();
        for (String item : listPanel) {
            if (item.toLowerCase().contains(query.toLowerCase())) {
                results.append(item).append("\n");
            }
        }
        area.setText(results.toString());
    }




     */
    public static void main(String[] args) {
        new PatientList();
    }
}



