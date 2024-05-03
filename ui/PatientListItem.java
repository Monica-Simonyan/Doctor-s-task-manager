package ui;

import model.patient.PersonalInformation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class PatientListItem extends JPanel {
    private static final int HEIGHT = 100;
    private static final Color color = new Color(252, 217, 217);

    public PatientListItem(PersonalInformation info) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton closeBtn = new JButton("x");
        closeBtn.setForeground(Color.RED);
        closeBtn.setBorder(null);
        closeBtn.setBackground(color);
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container parent = getParent();
                if (parent != null) {
                    // Remove this panel from its parent
                    parent.remove(PatientListItem.this);
                    // Repaint the parent to reflect the change
                    parent.revalidate();
                    parent.repaint();
                }
            }
        });

        JLabel fullNameTxt = new JLabel(info.getName() + " " + info.getLastName());
        JLabel ageTxt = new JLabel("Age: " + info.getAge());
        JLabel genderTxt = new JLabel("Gender: " + info.getGender().toString().toLowerCase());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(4, 2));
        infoPanel.setBorder(new EmptyBorder(0,0,0,HEIGHT));
        infoPanel.setBackground(color);

        infoPanel.add(closeBtn);
        infoPanel.add(fullNameTxt);
        infoPanel.add(ageTxt);
        infoPanel.add(genderTxt);

        ImageIcon profileImage = new ImageIcon("src/ui/149071.png");
        Image resizedImage = profileImage.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel img = new JLabel(resizedImageIcon);

        add(infoPanel);
        add(img);
        setSize(new Dimension(HomePage.WIDTH, HEIGHT*2));
        setBackground(color);
    }
}
