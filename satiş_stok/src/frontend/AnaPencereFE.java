package frontend;

import dal.ProductDAL;
import dal.SaleDAL;
import dal.StockDAL;
import interfaces.FrontEInterfaces;
import types.EmployeeContract;
import types.ProductContract;
import types.SaleContract;
import types.StockContract;
import utilities.MenuCom;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnaPencereFE extends JFrame implements FrontEInterfaces {

    public AnaPencereFE(){
        initPencere();
    }



    @Override
    public void initPencere() {
        JPanel panel= initPanel();
        JMenuBar bar= initBar();

        add(panel);
        setJMenuBar(bar);
        setTitle("Sale and Stock Automation");
        setSize(600,250);
        setVisible(true);
        setLocation(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    @Override
    public JPanel initPanel() {
        JPanel panel=new JPanel(new BorderLayout());

        JTabbedPane pane = initTabs();
        panel.add(pane,BorderLayout.CENTER);
        return panel;

    }

    @Override
    public JMenuBar initBar() {
        JMenuBar bar= MenuCom.initBar();
        return bar;
    }

    @Override
    public JTabbedPane initTabs() {
        JTabbedPane pane= new JTabbedPane();

        ImageIcon icon= new ImageIcon("icons/stock.icon.png");
        ImageIcon icon2= new ImageIcon("icons/stock.icon.png");



        JPanel stockPanel = new JPanel(new BorderLayout());
        JPanel salePanel= new JPanel(new BorderLayout());

        //Stock Items
        JPanel stockLeftPanel= new JPanel(new BorderLayout());
        JPanel stockLeftUpPanel= new JPanel(new GridLayout(4,2));
        JPanel stockLeftDownPanel= new JPanel();


        stockLeftPanel.setBorder((BorderFactory.createTitledBorder("Stock Procedure")));


        Object [] stockColumns= {"Id","EmployeeName","ProductName","Adet"};
        DefaultTableModel model= new DefaultTableModel(stockColumns,0);

        JTable stockTable= new JTable(model);
        JScrollPane stockTablePane= new JScrollPane(stockTable);

        JLabel stockProductLabel= new JLabel("Product Name:", JLabel.RIGHT);
        stockLeftUpPanel.add(stockProductLabel);
        JComboBox stockProductNameBox= new JComboBox(new ProductDAL().GetAll().toArray());
        stockLeftUpPanel.add(stockProductNameBox);
        JLabel stockAdetLabel= new JLabel("Adet:",JLabel.RIGHT);
        stockLeftUpPanel.add(stockAdetLabel);
        JTextField stockAdetfield= new JTextField(15);
        stockLeftUpPanel.add(stockAdetfield);

        JButton stockAddButton= new JButton("Add Stock");
        stockLeftUpPanel.add(stockAddButton);
        JButton stockRefreshButton= new JButton("Refresh Stock");
        stockLeftUpPanel.add(stockRefreshButton);


        stockRefreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        stockAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                StockContract contract= new StockContract();
                ProductContract uContract= (ProductContract) stockProductNameBox.getSelectedItem();
                EmployeeContract pContrat = (EmployeeContract) LoginFE.emailBox.getSelectedItem();


                contract.setEmployeeId(pContrat.getId());
                contract.setProductId(uContract.getId());
                contract.setAdet(Integer.parseInt(stockAdetfield.getText()));
                new StockDAL().Insert(contract);

                JOptionPane.showMessageDialog(null,"The product named" +uContract.getName()+ "has been added.");


            }
        });

        //Sale Items
        JPanel saleRightPanel= new JPanel(new BorderLayout());
        JPanel saleRightUpPanel= new JPanel(new GridLayout(4,2));
        JPanel saleRightDownPanel= new JPanel();

        Object [] saleColumns= {"Id","Employee Name","Customer Name","Product Name","Adet"};
        DefaultTableModel saleModel= new DefaultTableModel(saleColumns,0);

        JTable saleTable= new JTable(saleModel);
        JScrollPane saleTablePane= new JScrollPane(saleTable);

        JLabel saleProductLabel= new JLabel("Product Name:", JLabel.RIGHT);
        saleRightUpPanel.add(saleProductLabel);
        JComboBox saleProductNameBox= new JComboBox();
        saleRightUpPanel.add(saleProductNameBox);
        JLabel saleAdetLabel= new JLabel("Adet:",JLabel.RIGHT);
        saleRightUpPanel.add(saleAdetLabel);
        JTextField saleAdetfield= new JTextField(10);
        saleRightUpPanel.add(saleAdetfield);

        JButton saleAddButton= new JButton("Sell");
        saleRightUpPanel.add(saleAddButton);
        JButton saleRefreshButton= new JButton("Refresh");
        saleRightUpPanel.add(saleRefreshButton);

        stockPanel.add(stockLeftPanel,BorderLayout.WEST);
        stockPanel.add(stockTablePane,BorderLayout.CENTER);

        salePanel.add(saleRightPanel,BorderLayout.EAST);
        salePanel.add(saleTablePane,BorderLayout.CENTER);

        saleRightPanel.add(saleRightUpPanel,BorderLayout.NORTH);
        saleRightPanel.add(saleRightDownPanel,BorderLayout.SOUTH);



        stockLeftPanel.add(stockLeftUpPanel,BorderLayout.NORTH);
        stockLeftPanel.add(stockLeftDownPanel,BorderLayout.SOUTH);






        pane.addTab("Stocks",icon,stockPanel,"does nothing");
        pane.addTab("Sales",icon2,salePanel,"yazı");


        return pane;
    }
}
