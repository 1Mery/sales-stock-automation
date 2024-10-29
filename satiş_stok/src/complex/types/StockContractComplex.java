package complex.types;

public class StockContractComplex {

    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }
    private String employeeName;
    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }

    private String productName;
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }


    private int adet;

    public int getAdet() {
        return this.adet;
    }

    public void setAdet(final int adet) {
        this.adet = adet;
    }

    public  Object[] getVeriler(){

        Object[] veriler= {id,employeeName,productName};

        return veriler;
    }


    @Override
    public String toString() {
        return employeeName+" "+productName;

    }
}
