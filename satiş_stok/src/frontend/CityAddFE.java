package frontend;


import interfaces.FrontEInterfaces;

import javax.swing.*;
import java.awt.*;

public class CityAddFE extends JDialog implements FrontEInterfaces {

    public  CityAddFE(){
        initPencere();

    }

    @Override
    public void initPencere() {
        JPanel panel=initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Add City"));

        add(panel);
        setTitle("Add City");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);



    }

    @Override
    public JPanel initPanel() {

        JPanel panel= new JPanel(new GridLayout(1,2));

        JLabel cityLabel= new JLabel("Add City: ",JLabel.RIGHT);
        panel.add(cityLabel);
        JComboBox cityBox= new JComboBox();
        panel.add(cityBox);

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





