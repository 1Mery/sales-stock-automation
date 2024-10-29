package frontend;


import dal.CategoryDAL;
import interfaces.FrontEInterfaces;
import types.CategoryContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryAddFE extends JDialog implements FrontEInterfaces {
    public CategoryAddFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel= initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Add Category"));

        add(panel);
        setTitle("Add Category");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    @Override
    public JPanel initPanel() {
        JPanel panel= new JPanel(new GridLayout(3,2));


        JLabel nameLabel=new JLabel("Category Name: ",JLabel.RIGHT);
        panel.add(nameLabel);
        JTextField nameField = new JTextField(15);
        panel.add(nameField);
        JLabel categoryLabel= new JLabel("Choose Category: ",JLabel.RIGHT);
        panel.add(categoryLabel);
        JComboBox categoryBox= new JComboBox(new CategoryDAL().GetAllParentId().toArray());
        panel.add(categoryBox);
        categoryBox.insertItemAt("--Choose Category--",0);
        categoryBox.setSelectedIndex(0);
        JButton saveButton= new JButton("Save");
        panel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CategoryContract contract= new CategoryContract();

                if(categoryBox.getSelectedIndex()!=0){
                    CategoryContract casContract = (CategoryContract) categoryBox.getSelectedItem();

                    contract.setName(nameField.getText());
                    contract.setParentId(casContract.getId());

                    new CategoryDAL().Insert(contract);
                    JOptionPane.showMessageDialog(null,"The record named " +contract.getName() + "has been added successfully.");
                }
               else{
                    contract.setName(nameField.getText());
                    contract.setParentId(categoryBox.getSelectedIndex());

                    new CategoryDAL().Insert(contract);

                    JOptionPane.showMessageDialog(null,"The record named " +contract.getName() + "has been added successfully.");



                }





            }
        });


        JButton cancelButton= new JButton("Cancel");
        panel.add(cancelButton);





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