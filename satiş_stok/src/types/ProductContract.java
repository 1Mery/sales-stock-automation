package types;

import java.util.Date;

public class ProductContract {


    private int id;
    private float price;
    private String name;
    private int categoryId;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }




    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }





    @Override
    public String toString() {
        return name;
    }
}
