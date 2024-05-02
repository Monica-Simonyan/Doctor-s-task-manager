package ui;

import model.patient.Patient;
import model.patient.PersonalInformation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 * Represents a JPanel for displaying information about a patient in a list.
 */
public class PatientListItem extends JPanel {
    private static final Color color = new Color(252, 217, 217);

    /**
     * Constructs a PatientListItem with the specified Patient object.
     *
     * @param patient The Patient object to display information about.
     */
    public PatientListItem(Patient patient) {
        PersonalInformation info = patient.getPersonalInfo();
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton closeBtn = new JButton("x");
        closeBtn.setForeground(Color.RED);
        closeBtn.setBorder(null);
        closeBtn.setBackground(color);
        closeBtn.addActionListener(e -> {
            Container parent = getParent();
            if (parent != null) {
                // Remove this panel from its parent
                parent.remove(PatientListItem.this);
                // Repaint the parent
                parent.revalidate();
                parent.repaint();
            }
        });

        JLabel category = new JLabel("Category: " + patient);
        JLabel fullNameTxt = new JLabel(info.getName() + " " + info.getLastName());
        JLabel ageTxt = new JLabel("Age: " + info.getAge());
        JLabel genderTxt = new JLabel("Gender: " + info.getGender().toString().toLowerCase());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 2));
        infoPanel.setBorder(new EmptyBorder(0, 0, 0, 120));
        infoPanel.setBackground(color);

        infoPanel.add(closeBtn);
        infoPanel.add(category);
        infoPanel.add(fullNameTxt);
        infoPanel.add(ageTxt);
        infoPanel.add(genderTxt);

        ImageIcon profileImage = new ImageIcon("src/ui/149071.png");
        Image resizedImage = profileImage.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel img = new JLabel(resizedImageIcon);

        add(infoPanel);
        add(img);
        setSize(new Dimension(HomePage.WIDTH, 200));
        setBackground(color);
    }
}
