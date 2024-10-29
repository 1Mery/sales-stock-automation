package dal;

import core.ObjectHelper;
import interfaces.DALInterfaces;
import types.CategoryContract;
import types.StockContract;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StockDAL extends ObjectHelper implements DALInterfaces<StockContract> {


    @Override
    public void Insert(StockContract entity) {
        Connection connection= getConnection();

        try {
            Statement statement= connection.createStatement();

            statement.executeUpdate("INSERT INTO Stock (ProductId,EmployeeId , Adet) VALUES ("+entity.getProductId()+","+entity.getEmployeeId()+","+entity.getAdet()+")");

            statement.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void Insert(CategoryContract entity) {

    }

    @Override
    public List<StockContract> GetAll() {
        return null;
    }

    @Override
    public StockContract Delete(StockContract entity) {
        return null;
    }

    @Override
    public List<StockContract> GetById(int id) {
        return null;
    }
}
