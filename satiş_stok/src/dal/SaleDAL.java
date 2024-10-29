package dal;

import core.ObjectHelper;
import interfaces.DALInterfaces;
import types.CategoryContract;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SaleDAL<SaleContract> extends ObjectHelper implements DALInterfaces<SaleContract> {
    @Override
    public void Insert(SaleContract entity) {


        Connection connection= getConnection();

        try {
            Statement statement= connection.createStatement();
            statement.executeUpdate("INSERT INTO Sale (ProductId) VALUES()");
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
    public List<SaleContract> GetAll() {
        return null;
    }

    @Override
    public SaleContract Delete(SaleContract entity) {
        return null;
    }

    @Override
    public List<SaleContract> GetById(int id) {
        return null;
    }
}
