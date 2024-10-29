package frontend;

import dal.CategoryDAL;
import dal.ProductDAL;
import interfaces.FrontEInterfaces;
import types.CategoryContract;
import types.ProductContract;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class ProductAddFE extends JDialog implements FrontEInterfaces {

    public ProductAddFE(){
        initPencere();

    }

    @Override
    public void initPencere() {
        JPanel panel= initPanel();

        panel.setBorder(BorderFactory.createTitledBorder("Product Registration Area"));
        add(panel);
        setTitle("Add Product");
        setModalityType(DEFAULT_MODALITY_TYPE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);



    }

    @Override
    public JPanel initPanel() {
        JPanel panel=new JPanel(new GridLayout(5,2));
        JLabel nameLabel= new JLabel("Product Name: ", JLabel.RIGHT);
        panel.add(nameLabel);
        JTextField nameField = new JTextField(10);
        panel.add(nameField);
        JLabel categoryLabel= new JLabel("Choose Category: ",JLabel.RIGHT);
        panel.add(categoryLabel);
        JComboBox categoryBox= new JComboBox(new CategoryDAL().GetAll().toArray());
        panel.add(categoryBox);
        JLabel priceLabel = new JLabel("Enter Price: ",JLabel.RIGHT);
        panel.add(priceLabel);
        JTextField priceField = new JTextField(10);
        panel.add(priceField);

        JButton saveButton = new JButton("Save");
        panel.add(saveButton);
        JButton cancelButton= new JButton("Cancel");
        panel.add(cancelButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductContract contract= new ProductContract();
                CategoryContract casContract= (CategoryContract) categoryBox.getSelectedItem();


                contract.setName(nameField.getText());
                contract.setCategoryId(casContract.getId());
                ;
                contract.setPrice(Float.parseFloat(priceField.getText()));


                new ProductDAL().Insert(contract);
                JOptionPane.showMessageDialog(null,contract.getName()+"successfully added..");
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
