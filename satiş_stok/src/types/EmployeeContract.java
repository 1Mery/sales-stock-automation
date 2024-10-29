package types;

public class EmployeeContract {


    private int id;
    private String nameSurname;
    private String email;

    public String getEmail() {
        return email;
    }


    public int getId() {
        return id;
    }


    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }



    public void setId(int id) {
        this.id = id;
    }


    public void setEmail(String email) {
        this.email = email;
    }









    @Override
    public String toString() {
        return nameSurname;
    }
}
