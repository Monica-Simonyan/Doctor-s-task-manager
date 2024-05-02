package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PatientList extends JFrame {
    JPanel searchPanel;
    JPanel listPanel;
    JTextField search;
    JTextArea area;
    JButton searchButton;
    static final int WIDTH = 350;
    static final int HEIGHT = 650;

    public PatientList() {
        listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(1000, 1, 0, 5));


        search = new JTextField(10);
        searchButton = new JButton("Search");
        searchButton.addActionListener((ActionEvent e) -> {
            // Perform search action here
        });

        searchPanel = new JPanel();
        searchPanel.add(search);
        searchPanel.add(searchButton);
        searchPanel.setBounds(0, 10, 250, 50); // Set bounds for searchPanel
        add(searchPanel);
        AddButton addButton = new ui.AddButton(40, listPanel);
        addButton.setBackground(Color.WHITE);
        addButton.setBounds(270, 10, 40, 40);
        add(addButton);

       // Set grid layout for listPanel

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBounds(0, 70, WIDTH, 550); // Set bounds for scrollPane
        add(scrollPane);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Patient List");
        setVisible(true);
    }

    public static void main(String[] args) {
        new PatientList();
    }
}
