package dal;

import core.ObjectHelper;
import interfaces.DALInterfaces;
import types.CategoryContract;
import types.EmployeeContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public  class EmployeeDAL extends ObjectHelper implements DALInterfaces<EmployeeContract> {
    @Override
    public void Insert(EmployeeContract entity) {

        Connection connection= getConnection();
        try {
            Statement statement= connection.createStatement();

            statement.executeUpdate("INSERT INTO Employee (NameSurname,Email) VALUES ('"+entity.getNameSurname()+"','"+entity.getEmail()+"') ");

             statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void Insert(CategoryContract entity) {

    }


    @Override
    public List<EmployeeContract> GetAll() {

        List<EmployeeContract> datacontract= new ArrayList<EmployeeContract>();

        Connection connection= getConnection();
        EmployeeContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM Employee");
            while(resultSet.next()){
                contract= new EmployeeContract();
                contract.setId(resultSet.getInt("EmployeeId"));
                contract.setNameSurname(resultSet.getString("NameSurname"));
                contract.setEmail(resultSet.getString("Email"));


                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;

    }

    @Override
    public EmployeeContract Delete(EmployeeContract entity) {
        return null;
    }

    @Override
    public List<EmployeeContract> GetById(int id) {
        return null;
    }
}
