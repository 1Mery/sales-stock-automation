package frontend;

import dal.EmployeeDAL;
import interfaces.FrontEInterfaces;
import types.EmployeeContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAddFE extends JDialog implements FrontEInterfaces {
    public EmployeeAddFE(){

        initPencere();
    }


    @Override
    public void initPencere() {
        JPanel panel= initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Add Employee"));

        add(panel);
        setTitle("Add Employee");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);


    }

    @Override
    public JPanel initPanel() {

        JPanel panel=new JPanel(new GridLayout(3,2));
        JLabel nameSurnameLabel= new JLabel("Name Surname: ",JLabel.RIGHT);
        panel.add(nameSurnameLabel);
        JTextField nameSurnameField= new JTextField(10);
        panel.add(nameSurnameField);
        JLabel emailLabel= new JLabel("Email: ",JLabel.RIGHT);
        panel.add(emailLabel);
        JTextField emailField= new JTextField(10);
        panel.add(emailField);

        JButton saveButton=new JButton("Save");
        panel.add(saveButton);
        JButton cancelButton= new JButton("Cancel");
        panel.add(cancelButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EmployeeContract contract= new EmployeeContract();
                contract.setNameSurname(nameSurnameField.getText());
                contract.setEmail(emailField.getText());

                new EmployeeDAL().Insert(contract);
                JOptionPane.showMessageDialog(null,contract.getNameSurname()+"successfully added..");

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
