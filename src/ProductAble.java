import java.util.List;

public interface ProductAble {

    List<Products> getAllProduct (List<Products>product);
    void findByName (List<Products>product);
    void sortByPrice (List<Products>product);
    StringBuilder total (List<Products>product, List<String>products, String name,int som);




}

