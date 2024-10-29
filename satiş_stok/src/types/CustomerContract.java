package types;

public class CustomerContract {


    private int cityId;
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
    private String nameSurname;
    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }


    private int customerId;
    public int getId() {
        return customerId;
    }

    public void setId(int id) {
        this.customerId = id;
    }



    private String phone;
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    private String adress;
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }



    @Override
    public String toString() {
        return customerId+" "+nameSurname+" "+phone+" "+adress+" "+cityId;
    }
}
