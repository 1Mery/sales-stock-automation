package dal;

import core.ObjectHelper;
import interfaces.DALInterfaces;
import types.CategoryContract;
import types.EmployeeContract;
import types.YetkilerContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class YetkilerDAL extends ObjectHelper implements DALInterfaces<YetkilerContract> {



    @Override
    public void Insert(YetkilerContract entity) {

        Connection connection= getConnection();
        try {
            Statement statement= connection.createStatement();

            statement.executeUpdate("INSERT INTO Yetkiler (Name) VALUES ('"+entity.getName()+"')");

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
    public List<YetkilerContract> GetAll() {

        List<YetkilerContract> datacontract= new ArrayList<YetkilerContract>();

        Connection connection= getConnection();
        YetkilerContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM Yetkiler");
            while(resultSet.next()){
                contract= new YetkilerContract();
                contract.setId(resultSet.getInt("YetkiId"));
                contract.setName(resultSet.getString("Name"));

                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;


    }

    @Override
    public YetkilerContract Delete(YetkilerContract entity) {
        return null;
    }

    @Override
    public List<YetkilerContract> GetById(int id) {
        return null;
    }
}
