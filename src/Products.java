import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Products implements ProductAble{
    private String productName;
    private int price;


    public Products( String productName, int price) {
        this.productName = productName;
        this.price = price;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Products() {
    }

    @Override
    public String toString() {
        return  ",  productName = " + productName +
                ",  price = " + price + "\n"
                ;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public List<Products> getAllProduct(List<Products> product) {
        return product;
    }

    @Override
    public void findByName(List<Products> product) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (Products p:product) {
            if (p.getProductName().trim().toLowerCase().contains(name.trim().toLowerCase())){
                System.out.println(p);
            }

        }
    }

    @Override
    public void sortByPrice(List<Products> product) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to sort ascending" +"" +
                "\nPress 2 to sort descending");
        switch (scanner.nextInt()){
            case 1 -> {
                product.sort(Products.ascending);
                System.out.println(product);
            }
            case 2 -> {
                product.sort(Products.descending);
                System.out.println(product);
            }
        }
    }
    @Override
    public StringBuilder total(List<Products> product, List<String> products,String name,int som) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder check = new StringBuilder(">>>>>>>>>>>>> C H E C K <<<<<<<<<<<\n");
        int discount = 0;
        int summa = 0;
        for (Products p : product) {

            for (int i = 0; i < products.size(); i++) {

                if (p.getProductName().trim().toUpperCase().contains(products.get(i).trim().toUpperCase())){
                    check.append(p.productName).append("      ").append(p.price).append("\n");
                    discount += p.price;


                }
            }
        }
        discount += getPrice();
        summa = discount * 10 / 100;
        int inAll = discount - summa;
        int change = som - inAll;

        return check.append("\n~BUYER: ").append(name).append("\nTHE COST OF ALL PRODUCTS: = ").append(discount).append(" SOM")
                .append("\nPROMOTION FOR EVERY PURCHASE - 10% !!! ").append("\n  TOTAL: - ").append(inAll).append(" SOM").
                append("\n  YOUR CHANGE: = ").append(change).append(" SOM").append("\n~~~T H A N K S    F O R   V I S I T I N G   U S !!!~~~");
    }






    public static Comparator <Products> ascending = new Comparator<Products>() {
        @Override
        public int compare(Products o1, Products o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };
    public static Comparator <Products> descending = new Comparator<Products>() {
        @Override
        public int compare(Products o1, Products o2) {
            return  o2.getPrice() - o1.getPrice() ;
        }
    };


}
