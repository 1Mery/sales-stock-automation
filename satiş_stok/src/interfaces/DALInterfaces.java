package interfaces;

import types.CategoryContract;

import java.util.List;

public interface DALInterfaces <T>{
    public void Insert(T entity);

    void Insert(CategoryContract entity);


    public List<T> GetAll();
    public T Delete(T entity);
    public List<T> GetById(int id);



}
