package types;

public class CategoryContract {

    private int categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getId() {
        return categoryId;
    }

    public void setId(int id) {
        this.categoryId = categoryId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    private int parentId;

    @Override
    public String toString() {
        return name ;
    }
}
