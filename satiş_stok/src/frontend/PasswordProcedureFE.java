package frontend;


import dal.AccountsDAL;
import dal.EmployeeDAL;
import dal.YetkilerDAL;
import interfaces.FrontEInterfaces;
import types.AccountsContract;
import types.EmployeeContract;
import types.YetkilerContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordProcedureFE extends JDialog implements FrontEInterfaces{

    public  PasswordProcedureFE() {

        initPencere();

    }

    @Override
    public void initPencere() {
        JPanel panel=initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Set Password Procedure"));

        add(panel);
        setTitle("Set Password Procedure");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    @Override
    public JPanel initPanel() {

        JPanel panel = new JPanel(new GridLayout(5,2));

        JLabel employeeLabel= new JLabel("Choose Employee:",JLabel.RIGHT);
        panel.add(employeeLabel);
        JComboBox employeeBox= new JComboBox(new EmployeeDAL().GetAll().toArray());
        panel.add(employeeBox);

        JLabel yetkiLabel= new JLabel("Choose Yetki",JLabel.RIGHT);
        panel.add(yetkiLabel);
        JComboBox yetkiBox= new JComboBox(new YetkilerDAL().GetAll().toArray());
        panel.add(yetkiBox);

        JLabel passwordLabel= new JLabel("Set Password:",JLabel.RIGHT);
        panel.add(passwordLabel);
        JPasswordField passField= new JPasswordField(10);
        panel.add(passField);

        JLabel passReplyLabel= new JLabel("Password Again:",JLabel.RIGHT);
        panel.add(passReplyLabel);
        JPasswordField passReply= new JPasswordField(10);
        panel.add(passReply);

        JButton saveButton= new JButton("Save");
        panel.add(saveButton);
        JButton cancelButton= new JButton("Cancel");
        panel.add(cancelButton);


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountsContract contract= new AccountsContract();
                EmployeeContract pContract= (EmployeeContract) employeeBox.getSelectedItem();
                YetkilerContract yContract= (YetkilerContract) yetkiBox.getSelectedItem();

                if (passField.getText().equals(passReply.getText())){


                   contract.setEmployeeId(pContract.getId());
                   contract.setYetkiId(yContract.getId());
                   contract.setPassword(passField.getText());

                    new AccountsDAL().Insert(contract);
                    JOptionPane.showMessageDialog(null,pContract.getNameSurname()+" to the person named "+yContract.getName()+" succesfully added..");

                }
                else {
                    JOptionPane.showMessageDialog(null,"Password does not match.");
                }


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

