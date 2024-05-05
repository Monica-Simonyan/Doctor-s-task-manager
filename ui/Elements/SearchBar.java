package ui.Elements;

import model.patient.Patient;
import model.patient.Payments;

import javax.swing.*;
import java.util.ArrayList;

public class SearchBar extends JFrame {
    ArrayList<Patient> patients;

    public SearchBar(){
        JTextField searchField = new JTextField(30);

    }

    /*
    searchField.setLayout(new BorderLayout());
    JLabel label = new JLabel(icon);
    label.setCursor(Cursor.getDefaultCursor());
    searchField.add(label, BorderLayout.LINE_END);
    label.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            searchField.setText("");
        }
    });

     */
}
