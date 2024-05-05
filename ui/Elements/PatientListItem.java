package ui.Elements;

import model.patient.Patient;
import model.patient.PersonalInformation;
import ui.Buttons.ShowPatientCard;
import ui.HomePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Represents a JPanel for displaying information about a patient in a list.
 */
public class PatientListItem extends JPanel {
    private static final Color color = new Color(252, 217, 217);
    Patient patient;
    PersonalInformation info;

    /**
     * Constructs a PatientListItem with the specified Patient object.
     *
     * @param patient The Patient object to display information about
     */
    public PatientListItem(Patient patient) {
        this.patient = patient.clone();
        info = this.patient.getPersonalInfo();
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton closeBtn = new JButton("x");
        closeBtn.setForeground(Color.RED);
        closeBtn.setBorder(null);
        closeBtn.setBackground(color);
        closeBtn.setBounds(10, 10, HomePage.WIDTH - 15, 100);
        closeBtn.addActionListener(e -> {
            Container parent = getParent();
            if (parent != null) {
                HomePage.accessPatients().remove(patient);
                // Remove this panel from its parent
                parent.remove(PatientListItem.this);
                // Repaint the parent
                parent.revalidate();
                parent.repaint();
            }
        });


        ImageIcon profileImage = new ImageIcon(patient.getImageURL());
        Image resizedImage = profileImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel img = new JLabel(resizedImageIcon);

        InformationPanel infoPanel = new InformationPanel(patient, color);
        infoPanel.setBorder(new EmptyBorder(0, 0, 0, 70));
        add(infoPanel);
        infoPanel.add(new ShowPatientCard(patient));
        infoPanel.add(closeBtn);
        add(img);

        setSize(new Dimension(HomePage.WIDTH, 170));
        setBackground(color);
    }


}
