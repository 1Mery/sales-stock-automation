package frontend;

import dal.AccountsDAL;
import dal.EmployeeDAL;
import interfaces.FrontEInterfaces;
import types.EmployeeContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFE extends JDialog implements FrontEInterfaces{

    public static JComboBox emailBox;
    public  LoginFE() {
        initPencere();

    }
        @Override
        public void initPencere() {

        JPanel panel= initPanel();

        panel.setBorder(BorderFactory.createTitledBorder("Please enter your information to log in to the system. "));
        add(panel);
        setTitle("Please Enter Login...");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);


        }

        @Override
        public JPanel initPanel() {
        JPanel panel= new JPanel(new GridLayout(3,2));


        JLabel emailLabel= new JLabel("Email:",JLabel.RIGHT);
        panel.add(emailLabel);
        emailBox = new JComboBox(new EmployeeDAL().GetAll().toArray());
        panel.add(emailBox);
        JLabel passwordLabel= new JLabel("Pasword:",JLabel.RIGHT);
        panel.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField(15);
        panel.add(passwordField);

        JButton loginButton = new JButton("Log In");
        panel.add(loginButton);
        JButton cancelButton= new JButton("Cancel");
        panel.add(cancelButton);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EmployeeContract contract= (EmployeeContract) emailBox.getSelectedItem();


               if(new AccountsDAL().GetEmployeeIdAndPassword(contract.getId(), passwordField.getText()).getEmployeeId()!=0){
                    new AnaPencereFE();
                }
                else {
                    JOptionPane.showMessageDialog(null,("Login failed."));


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

