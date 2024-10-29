import dal.ProductDAL;
import frontend.AnaPencereFE;
import frontend.LoginFE;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try{
            for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                if ("Nimbus".equals(info.getName()))
                UIManager.setLookAndFeel(info.getClassName());
                 break;
            }

        } catch (Exception e) {
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
             //  new AnaPencereFE();
                new LoginFE();
                //new ProductDAL().GetAll();


            }
        });
    }
}