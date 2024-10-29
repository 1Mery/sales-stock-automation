package frontend;

import interfaces.DALInterfaces;
import interfaces.FrontEInterfaces;

import javax.swing.*;
import java.awt.*;

public class CustomerAddFE extends JDialog implements FrontEInterfaces {

    public CustomerAddFE(){
        initPencere();
    }


    @Override
    public void initPencere() {
        JPanel panel=initPanel();

        add(panel);
        setTitle("Add Customer");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);


    }

    @Override
    public JPanel initPanel() {
        JPanel panel= new JPanel(new BorderLayout());
        JPanel fieldPanel= new JPanel(new GridLayout(5,2));

        JLabel nameSurnameLabel= new JLabel("Name Surname: ",JLabel.RIGHT);
        fieldPanel.add(nameSurnameLabel);
        JTextField nameSurnameField= new JTextField(15);
        fieldPanel.add(nameSurnameField);
        JLabel phoneLabel= new JLabel("Phone: ",JLabel.RIGHT);
        fieldPanel.add(phoneLabel);
        JTextField phoneField= new JTextField(15);
        fieldPanel.add(phoneField);
        JLabel cityChooseLabel= new JLabel("Choose City: ",JLabel.RIGHT);
        fieldPanel.add(cityChooseLabel);
        JComboBox cityBox= new JComboBox();
        fieldPanel.add(cityBox);
        JLabel adressLabel= new JLabel();
        fieldPanel.add(adressLabel);
        JTextArea adressArea= new JTextArea();
        JScrollPane pane= new JScrollPane(adressArea);

        panel.add(fieldPanel,BorderLayout.NORTH);
        panel.add(pane,BorderLayout.SOUTH);


        return panel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {
        return null;
    }
}
