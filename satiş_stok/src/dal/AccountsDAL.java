package dal;

import core.ObjectHelper;
import interfaces.DALInterfaces;
import types.AccountsContract;
import types.CategoryContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountsDAL extends ObjectHelper implements DALInterfaces<AccountsContract> {
    @Override
    public void Insert(AccountsContract entity) {
        Connection connection= getConnection();
        try {
            Statement statement= connection.createStatement();

            statement.executeUpdate("INSERT INTO Accounts (EmployeeId,YetkiId,Password) VALUES ("+entity.getEmployeeId()+","+entity.getYetkiId()+","+entity.getPassword()+")");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AccountsContract GetEmployeeIdAndPassword(int employeeId,String password){


        AccountsContract contract= new AccountsContract();
        List<AccountsContract> listele= new ArrayList<AccountsContract>();
        Connection connection= getConnection();
        try {
            Statement sorgu=connection.createStatement();
            ResultSet rs= sorgu.executeQuery("SELECT EmployeeId,YetkiId,Password FROM Accounts  WHERE EmployeeId="+employeeId+" and Password='"+password.trim()+"'");

            while (rs.next()){


                contract.setEmployeeId(rs.getInt("EmployeeId"));
                contract.setYetkiId(rs.getInt("YetkiId"));
                contract.setPassword(rs.getString("Password"));


            }
            sorgu.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contract;
    }

    public AccountsContract GetYetkiId(int employeeId){


        AccountsContract contract= new AccountsContract();
        List<AccountsContract> listele= new ArrayList<AccountsContract>();
        Connection connection= getConnection();
        try {
            Statement sorgu=connection.createStatement();
            ResultSet rs= sorgu.executeQuery("SELECT EmployeeId,YetkiId,Password FROM Accounts  WHERE EmployeeId="+employeeId+" ");

            while (rs.next()){

                contract.setEmployeeId(rs.getInt("EmployeeId"));
                contract.setYetkiId(rs.getInt("YetkiId"));

            }
            sorgu.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;
    }


    @Override
    public void Insert(CategoryContract entity) {

    }

    @Override
    public List<AccountsContract> GetAll() {
        return null;
    }

    @Override
    public AccountsContract Delete(AccountsContract entity) {
        return null;
    }

    @Override
    public List<AccountsContract> GetById(int id) {
        return null;
    }
}
