import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        List<Products> market1 = new LinkedList<>();

        market1.add(new Meats("SAUSAGE", 180));
        market1.add(new Meats("BEEF", 320));
        market1.add(new Meats("MUTTON", 300));
        market1.add(new Meats("SALMON", 120));
        market1.add(new Meats("CHIKEN", 300));
        market1.add(new Drinks("COCA COLA", 150));
        market1.add(new Drinks("FANTA", 140));
        market1.add(new Drinks("PEPSI", 130));
        market1.add(new Drinks("SULTAN TEA", 40));
        market1.add(new Dairy("CHEESE", 150));
        market1.add(new Dairy("MILK", 70));
        market1.add(new Dairy("KEFIR", 70));
        market1.add(new Dairy("ICE CREAM", 35));
        market1.add(new Confectionery("BREAD", 30));
        market1.add(new Confectionery("CAKE", 150));
        market1.add(new Confectionery("COOKIE", 100));
        market1.add(new Confectionery("BUNS", 150));
        market1.add(new Stationery("PEN", 35));
        market1.add(new Stationery("NOTEBOOK", 15));
        market1.add(new Stationery("COVER", 5));
        market1.add(new Stationery("ALBUM", 50));


        List<Products> market2 = new LinkedList<>();

        market2.add(new Dairy("CHEESE", 120));
        market2.add(new Dairy("MILK", 60));
        market2.add(new Dairy("KEFIR", 70));
        market2.add(new Dairy("PIE", 150));
        market2.add(new Meats("SAUSAGE", 180));
        market2.add(new Meats("BEEF", 350));
        market2.add(new Meats("MUTTON", 340));
        market2.add(new Meats("SALMON", 100));
        market2.add(new Meats("FISH", 200));
        market2.add(new Drinks("COCA COLA", 150));
        market2.add(new Drinks("FANTA", 140));
        market2.add(new Drinks("PEPSI", 140));
        market2.add(new Drinks("FLASH", 65));
        market2.add(new Drinks("NITRO", 65));
        market2.add(new Confectionery("BREAD", 30));
        market2.add(new Confectionery("CAKE", 150));
        market2.add(new Confectionery("COOKIE", 100));
        market2.add(new Confectionery("BUNS", 150));
        market2.add(new Stationery("PEN", 30));
        market2.add(new Stationery("NOTEBOOK", 15));
        market2.add(new Stationery("COVER", 5));
        market2.add(new Stationery("ALBUM", 50));


        Markets magaz1 = new Markets("~~~~~~~~~ F R U N Z E ~~~~~~~~~", market1);
        Markets magaz2 = new Markets("~~~~~~~~ K A N Y K E Y ~~~~~~~~", market2);


        getMain(market1,market2,magaz1,magaz2);





    }
    public static void getMain(List<Products>market1,List<Products>market2,Markets magaz1,Markets magaz2){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("    Select a market please ");
            System.out.println("Press 1 to go market 'FRUNZE'\nPress 2 to go market 'KANYKEY' ");
            switch (scanner.nextInt()) {
                case 1 -> {
                    market1Catalog(magaz1);
                    commandEvecution(market1);
                }
                case 2 -> {
                    market1Catalog(magaz2);
                    commandEvecution(market2);
                }
            }
        }
    }

    public static void market1Catalog(Markets markets){
        System.out.println("                W e l c o m e       ");
        System.out.println("       "+markets.getName());
    }

    public static void commandEvecution (List <Products> product){
        Scanner scanner = new Scanner(System.in);
        while (true){
            Products products = new Products();
            commands();
            int num = scanner.nextInt();

            switch (num){
                case 1 -> {
                    products.getAllProduct(product).forEach(System.out::println);
                }
                case 2 -> {
                    products.findByName(product);
                }
                case 3 -> {
                    for (Products p : product) {
                        if (p instanceof Drinks){
                            System.out.println(p);
                        }
                    }
                }
                case 4 -> {
                    for (Products p : product) {
                        if (p instanceof Meats){
                            System.out.println(p);
                        }
                    }
                }
                case 5 -> {
                    for (Products p : product) {
                        if (p instanceof Dairy){
                            System.out.println(p);
                        }
                    }
                }
                case 6 -> {
                    for (Products p : product) {
                        if (p instanceof Confectionery){
                            System.out.println(p);
                        }
                    }
                }
                case 7 -> {
                    for (Products p : product) {
                        if (p instanceof Stationery){
                            System.out.println(p);
                        }
                    }
                }
                case 8 -> {
                    products.sortByPrice(product);
                }
                case 9 -> {
                    Scanner scanner1 = new Scanner(System.in);
                    Scanner scanner2 = new Scanner(System.in);
                    List<String> purchases = new ArrayList<>();
                    System.out.print("Write your NAME please: ");
                    String name = scanner2.nextLine();
                    System.out.print("Write how much MONEY you have: ");
                    int som = scanner2.nextInt();

                    while (true) {
                         System.out.print("Do you want to BUY something? (yes or no) :   =  ");
                         if (scanner1.nextLine().trim().toUpperCase().equals("YES")) {
                            System.out.print("What would you like to buy?:  -  ");
                            String order = scanner1.nextLine();
                             purchases.add(order);
                             } else {
                            System.out.println(products.total(product,purchases,name,som));
                        break;
                            }
                    }
                }

            }
            if (num == 10){
                break;
            }
        }
    }







    public static void commands (){
        System.out.println("""
                ~~~~~~~~~~~~~~~ C O M M A N D S ~~~~~~~~~~~~~~~~~~
                    |----------------------------------------|
                    | Press 1 to get all products            |   
                    | Press 2 to find by name product        |                       |         
                    | Press 3 to get all drinks              |        
                    | Press 4 to get all meats               |    
                    | Press 5 to get all dairy               |    
                    | Press 6 to get all confectionery       |        
                    | Press 7 to get all stationery          |
                    | Press 8 to sort by price               |
                    | Press 9 to complete the purchase       |
                    | Press 10 to go to exit from the market |   
                    |----------------------------------------|      
                ``````````````````````````````````````````````````
                """);
    }

}