package utilities;

import dal.AccountsDAL;
import frontend.*;
import types.EmployeeContract;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCom {


    public static JMenuBar initBar() {

        JMenuBar bar= new JMenuBar();
        JMenu dosyaMenu= new  JMenu("File");
        bar.add(dosyaMenu);
        JMenuItem exitItem = new JMenuItem("Exit");
        dosyaMenu.add(exitItem);

        //product
        JMenu productMenu= new JMenu("Products");
        bar.add(productMenu);
        JMenuItem productAddItem= new JMenuItem("Add Product");
        productMenu.add(productAddItem);
        JMenuItem categoryAddItem = new JMenuItem("Add Category");
        productMenu.add(categoryAddItem);
        productMenu.addSeparator();
        JMenuItem productEditIdem = new JMenuItem("Edit Product");
        productMenu.add(productEditIdem);
        JMenuItem categoryEditItem = new JMenuItem("Edit Category");
        productMenu.add(categoryEditItem);
        //employee
        JMenu employeesMenu= new JMenu("Employee Procedures");
        bar.add(employeesMenu);
        JMenuItem employeeAddItem= new JMenuItem("Add Employee");
        employeesMenu.add(employeeAddItem);
        JMenuItem yetkiAddItem= new JMenuItem("Add Yetki");
        employeesMenu.add(yetkiAddItem);
        JMenuItem passwordSetItem = new JMenuItem("Set Password");
        employeesMenu.add(passwordSetItem);
        employeesMenu.addSeparator();

        JMenuItem employeeEditItem= new JMenuItem("Edit Employee");
        employeesMenu.add(employeeEditItem);
        JMenuItem yetkiEdit= new JMenuItem("Edit Yetki");
        employeesMenu.add(yetkiEdit);
        JMenuItem passwordEditItem = new JMenuItem("Edit Password");
        employeesMenu.add(passwordEditItem);

        //customer
        JMenu customerMenu= new JMenu("Customers");
        bar.add(customerMenu);
        JMenuItem customerAddItem= new JMenuItem("Add Customer");
        customerMenu.add(customerAddItem);
        JMenuItem cityAddItem= new JMenuItem("Add City");
        customerMenu.add(cityAddItem);
        customerMenu.addSeparator();

        JMenuItem customerEditItem= new JMenuItem("Edit Customer");
        customerMenu.add(customerEditItem);
        JMenuItem cityEditItem= new JMenuItem("Edit City");
        customerMenu.add(cityEditItem);

        EmployeeContract contract= (EmployeeContract) LoginFE.emailBox.getSelectedItem();

        if (new AccountsDAL().GetYetkiId(contract.getId()).getYetkiId()==2){

            employeesMenu.hide();
        } else if (new AccountsDAL().GetYetkiId(contract.getId()).getYetkiId()==3) {
            customerMenu.hide();
            employeesMenu.hide();
            productMenu.hide();

        }


        productAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ProductAddFE();
                    }
                });

            }
        });


        categoryAddItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CategoryAddFE();
            }
        });
    }
});


        employeeAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {

                        new EmployeeAddFE();


                    }
                });

            }
        });


        yetkiAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new YetkiAddFE();
                    }
                });

            }
        });

        passwordSetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new PasswordProcedureFE();

            }
        });

        customerAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {

                        new CustomerAddFE();
                    }
                });
            }
        });

        cityAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new CityAddFE();
                    }
                });
            }
        });


        return bar;
    }

}
