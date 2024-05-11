package ui.Buttons;

import model.patient.Patient;
import ui.PopupWindows.PatientCardPopup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Represents the patient's medical card
 */
public class ShowPatientCard extends JLabel {

    /**
     * Displays the patient card
     * @param patient     <code>Patient</code> patient
     */
    public ShowPatientCard(Patient patient) {
        setText("More...");
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setForeground(new Color(38, 44, 107));
        setBorder(new EmptyBorder(3, 0, 0, 0));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openProfileWindow(patient);
            }
        });
    }


    /**
     * Displays the medical card window
     * @param patient     <code>Patient</code> patient
     */
    private void openProfileWindow(Patient patient) {

        PatientCardPopup profileFrame = new PatientCardPopup(patient);
        profileFrame.setVisible(true);
    }
}