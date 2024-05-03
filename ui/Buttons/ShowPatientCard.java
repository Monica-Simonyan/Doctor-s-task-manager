package ui.Buttons;

import model.patient.PersonalInformation;
import ui.PopupWindows.PatientCardPopup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowPatientCard extends JLabel {
    public ShowPatientCard(PersonalInformation info) {
        setText("More...");
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setForeground(new Color(38, 44, 107));
        setBorder(new EmptyBorder(3, 0, 0, 0));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openProfileWindow(info);
            }
        });
    }

    private void openProfileWindow(PersonalInformation info) {

        PatientCardPopup profileFrame = new PatientCardPopup(info);
        profileFrame.setVisible(true);
    }
}
