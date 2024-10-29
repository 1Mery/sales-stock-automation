package complex.types;

public class SaleContractComplex {

    private int id;
    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }


    private String customerName;

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }
    private String  employeeName;
    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }


    private int adet;
    public int getAdet() {
        return this.adet;
    }

    public void setAdet(final int adet) {
        this.adet = adet;
    }


    private  String productName;
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return employeeName+" "+customerName+" "+productName;
    }
}
