package dal;

import core.ObjectHelper;
import interfaces.DALInterfaces;
import types.CategoryContract;
import types.ProductContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAL extends ObjectHelper implements DALInterfaces<ProductContract> {


    @Override
    public void Insert(ProductContract entity) {

        Connection connection= getConnection();

        try {
            Statement statement= connection.createStatement();
            statement.executeUpdate("INSERT INTO Product (Name , CategoryID,Price)"+"VALUES('"+entity.getName()+"',"+entity.getCategoryId()+","+entity.getPrice()+")");
            statement.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void Insert(CategoryContract entity) {

    }

    @Override
    public List<ProductContract> GetAll() {
        List<ProductContract> datacontract= new ArrayList<ProductContract>();
        Connection connection= getConnection();
        ProductContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM Product");
            while(resultSet.next()){
                contract= new ProductContract();
                contract.setId(resultSet.getInt("ProductId"));
                contract.setName(resultSet.getString("Name"));
                contract.setCategoryId(resultSet.getInt("CategoryId"));

                datacontract.add(contract);

                System.out.println(resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return datacontract;

    }

    @Override
    public ProductContract Delete(ProductContract entity) {
        return null;
    }

    @Override
    public List<ProductContract> GetById(int id) {
        return null;
    }
}
