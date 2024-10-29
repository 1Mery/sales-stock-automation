package dal;

import core.ObjectHelper;
import interfaces.DALInterfaces;
import types.CategoryContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAL  extends ObjectHelper implements DALInterfaces<CategoryContract> {


    @Override
    public void Insert(CategoryContract entity) {

        Connection connection= getConnection();
        try {
            Statement statement= connection.createStatement();

            statement.executeUpdate("INSERT INTO Category (Name,ParentId) VALUES ('"+entity.getName()+"',"+entity.getParentId()+")");

        statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<CategoryContract> GetAll() {
        List<CategoryContract> datacontract= new ArrayList<CategoryContract>();
        Connection connection= getConnection();
        CategoryContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM Category");
            while(resultSet.next()){
                contract= new CategoryContract();
                contract.setId(resultSet.getInt("CategoryId"));
                contract.setName(resultSet.getString("Name"));
                contract.setParentId(resultSet.getInt("ParentId"));

                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return datacontract;
    }

    public List<CategoryContract> GetAllParentId() {
        List<CategoryContract> datacontract= new ArrayList<CategoryContract>();
        Connection connection= getConnection();
        CategoryContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM Category WHERE ParentId=0");
            while(resultSet.next()){
                contract= new CategoryContract();
                contract.setId(resultSet.getInt("CategoryId"));
                contract.setName(resultSet.getString("Name"));
                contract.setParentId(resultSet.getInt("ParentId"));

                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return datacontract;
    }




    @Override
    public CategoryContract Delete(CategoryContract entity) {
        return null;
    }

    @Override
    public List<CategoryContract> GetById(int id) {
        return null;
    }
}
