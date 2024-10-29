package frontend;

import dal.YetkilerDAL;
import interfaces.FrontEInterfaces;
import types.YetkilerContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YetkiAddFE extends JDialog implements FrontEInterfaces {

    public YetkiAddFE(){
        initPencere();

    }


    @Override
    public void initPencere() {
        JPanel panel= initPanel();

        panel.setBorder(BorderFactory.createTitledBorder("Add Yetki"));
        add(panel);
        setTitle("Add Yetki");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);



    }

    @Override
    public JPanel initPanel() {

        JPanel panel= new JPanel(new GridLayout(2,2));
        JLabel nameLabel= new JLabel("Yetki Name: ");
        panel.add(nameLabel);
        JTextField nameField= new JTextField(10);
        panel.add(nameField);

        JButton saveButton = new JButton("Save");
        panel.add(saveButton);
        JButton cancelButton = new JButton("Cancel");
        panel.add(cancelButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YetkilerContract contract= new YetkilerContract();

                contract.setName(nameField.getText());
                new YetkilerDAL().Insert(contract);
                JOptionPane.showMessageDialog(null,contract.getName()+ "successfully added..");

            }
        });



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
