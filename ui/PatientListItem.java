package ui;

import model.patient.Patient;
import model.patient.PersonalInformation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        //More button opens the window with patient card
        JLabel moreBtn = new JLabel("More...");
        moreBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        moreBtn.setForeground(new Color(38, 44, 107));
        moreBtn.setBorder(new EmptyBorder(3, 0, 0, 0));
        moreBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openProfileWindow(info);
            }
        });

        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(new EmptyBorder(0, 0, 0, 120));
        infoPanel.setLayout(new GridLayout(6, 2));
        infoPanel.setBackground(color);

        infoPanel.add(closeBtn);
        infoPanel.add(category);
        infoPanel.add(fullNameTxt);
        infoPanel.add(ageTxt);
        infoPanel.add(genderTxt);
        infoPanel.add(moreBtn);

        ImageIcon profileImage = new ImageIcon("src/ui/149071.png");
        Image resizedImage = profileImage.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel img = new JLabel(resizedImageIcon);

        add(infoPanel);
        add(img);
        setSize(new Dimension(HomePage.WIDTH, 170));
        setBackground(color);
    }

    private void openProfileWindow(PersonalInformation info) {
        PatientCard profileFrame = new PatientCard();
        profileFrame.setVisible(true);
    }
}
