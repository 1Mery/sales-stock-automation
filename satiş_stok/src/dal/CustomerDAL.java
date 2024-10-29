package dal;


import core.ObjectHelper;
import interfaces.DALInterfaces;
import types.CustomerContract;
import types.CategoryContract;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDAL  extends ObjectHelper implements DALInterfaces<CustomerContract> {


    @Override
    public void Insert(CustomerContract entity) {

        Connection connection= getConnection();
        try {
            Statement statement= connection.createStatement();

            statement.executeUpdate("INSERT INTO Customer (NameSurname,Phone,Adress,CityId)  VALUES ('"+entity.getNameSurname()+"','"+entity.getPhone()+"','"+entity.getAdress()+"',"+entity.getCityId()+")");

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
    public List<CustomerContract> GetAll() {
        return null;
    }

    @Override
    public CustomerContract Delete(CustomerContract entity) {
        return null;
    }

    @Override
    public List<CustomerContract> GetById(int id) {
        return null;
    }


}