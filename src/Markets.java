import java.util.List;

public class Markets {
    private String name;
    private String description;
    private List<Products>product;

    public Markets(String name,  List<Products> product) {
        this.name = name;

        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Products> getProduct() {
        return product;
    }

    public void setProduct(List<Products> product) {
        this.product = product;
    }
}
