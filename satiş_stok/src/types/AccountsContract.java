package types;

public class AccountsContract {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public int getYetkiId() {
        return yetkiId;
    }

    public void setYetkiId(int yetkiId) {
        this.yetkiId = yetkiId;
    }

    private int yetkiId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    private int employeeId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


    @Override
    public String toString() {
        return id+" "+yetkiId+" "+employeeId+" "+password;
    }
}
