package ui.PopupWindows;

import model.patient.Patient;
import model.patient.PersonalInformation;
import ui.PatientCardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class PatientCardPopup extends JFrame {
    private static final Color color = new Color(252, 217, 217);
    private static final Color backgroundColor = new Color(222, 227, 235);

    static JFrame f;
    static JPanel panel;
    static JButton close, saveAllergy, savePrescription;
    static ImageIcon profile, imgIcon;
    static Image image;
    static JLabel img;
    static JLabel name;
    static JLabel age;
    static JLabel gender;
    static JLabel lastVisit;
    static JLabel nextVisit;
    static JLabel phone;
    static JLabel email;
    static JLabel address;
    static JLabel history;
    static JLabel allergyLabel;
    static JLabel prescLabel;
    static JTextField allergies, prescriptions;
    Patient patient;
    PersonalInformation info;

    public PatientCardPopup(PersonalInformation info){
        //this.patient = patient.clone();
        System.out.println("I'm here");
        f = new JFrame("Patient Card");
        setSize(400, 500);
        setTitle("Patient Card");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(1000, 1, 0, 5));
        panel.setBackground(new Color(252, 217, 217));
        panel.setLayout(new BorderLayout());

//        close = new JButton("x");
//        close.setBackground(color);
//        close.setForeground(Color.RED);
//        close.setBorder(null);
//        close.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Container previous = getParent();
//                if(previous != null){
//                    previous.remove(PatientCardPopup.this);
//                    previous.revalidate();
//                    previous.repaint();
//                }
//            }
//        });

        this.info = info;
//        try{
//            //image
//            throw new NullPointerException();
//        }
//        catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
        setWindow();
    }

    public void setWindow(){

        profile = new ImageIcon("src/ui/149071.png");
        image = profile.getImage().getScaledInstance(80, 120, Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(image);
        img = new JLabel(imgIcon);

        name = new JLabel();
        name.setText("Name: ");
        name.setFont(new Font("Serif", Font.PLAIN, 15));

        age = new JLabel("Age: " + info.getAge());
        age.setFont(new Font("Serif", Font.PLAIN, 15));

        gender = new JLabel("Gender: " + info.getGender());
        gender.setFont(new Font("Serif", Font.PLAIN, 15));
        //
        lastVisit = new JLabel();
        lastVisit.setFont(new Font("Serif", Font.PLAIN, 15));
        //
        nextVisit = new JLabel();
        nextVisit.setFont(new Font("Serif", Font.PLAIN, 15));

        phone = new JLabel("Phone Number: " + info.getPhoneNumber());
        phone.setFont(new Font("Serif", Font.PLAIN, 15));

        email = new JLabel("Email Address: " + info.getGmail());
        email.setFont(new Font("Serif", Font.PLAIN, 15));

        address = new JLabel("Address:" + info.getAddress());
        address.setFont(new Font("Serif", Font.PLAIN, 15));

        history = new JLabel("History");
        history.setFont(new Font("Serif", Font.PLAIN, 20));

        allergyLabel = new JLabel("Allergies");
        allergyLabel.setFont(new Font("Serif", Font.PLAIN, 18));

        allergies = new JTextField("List Allergies", 10);
        allergies.setBackground(backgroundColor);

        saveAllergy = new JButton("Save");
        saveAllergy.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if(s.equals("Save")){
                    JOptionPane.showMessageDialog(null, "Saved");
                    // make allergies seen
                }
            }
        });

        prescLabel = new JLabel("Allergies");
        prescLabel.setFont(new Font("Serif", Font.PLAIN, 18));

        prescriptions = new JTextField("List Prescriptions", 10);
        prescriptions.setBackground(backgroundColor);
        savePrescription = new JButton("Save");
        savePrescription.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if(s.equals("Save")){
                    JOptionPane.showMessageDialog(null, "Saved");
                    // make prescriptions seen
                }
            }
        });



        //PatientCardPanel p = new PatientCardPanel(patient);
    }
}
