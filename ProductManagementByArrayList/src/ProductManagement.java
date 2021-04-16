import java.util.*;

public class ProductManagement {
    Scanner sc = new Scanner(System.in);
    List<Product> products = new ArrayList<>();


    public void init() {
        Product product1 = new Product("banana", 1, 1.0);
        Product product2 = new Product("orange", 2, 2.0);
        Product product3 = new Product("grape", 3, 6.0);
        Product product4 = new Product("lemon", 4, 4.0);
        Product product5 = new Product("apple", 5, 9.0);
        Product product6 = new Product("watermelon", 6, 3.0);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
    }

    public void display() {
        for (Product product :
                products) {
            System.out.println(product);
        }
    }

    public void addNewProduct() {
        System.out.println("Nhập vào thông tin sản phẩm mới");
        System.out.println("Nhập tên");
        String name = sc.nextLine();
        System.out.println("Nhập id");
        int id = sc.nextInt();
        System.out.println("Nhập giá");
        double price = sc.nextDouble();
        products.add(new Product(name, id, price));
    }

    public void editProduct() {
        System.out.println("Nhập id sản phẩm");
        int editID = sc.nextInt();
        boolean isProductExsist = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == editID) {
                isProductExsist = true;
                System.out.println("Tên mới");
                String newName = sc.nextLine();
                System.out.println("id mới");
                int newID = sc.nextInt();
                System.out.println("Giá mới");
                double newPrice = sc.nextDouble();
                products.get(i).setId(newID);
                products.get(i).setName(newName);
                products.get(i).setPrice(newPrice);
                break;
            }
        }
        if (!isProductExsist) {
            System.out.println("Không thấy ID");
        }
    }

    public void deleteProduct() {
        System.out.println("Nhập id sản phẩm");
        int deleteID = sc.nextInt();
        for (Product product : products) {
            if (product.getId() == deleteID){
                products.remove(product);
                break;
            }
        }
    }

    public void searchByName() {
        System.out.println("Nhập tên sản phẩm");
        String name = sc.nextLine();
        boolean isProductExsist = false;
        for (Product product:
             products) {
            if (product.getName().equals(name)) {
                System.out.println(product);
                isProductExsist = true;
            }
            break;
        }
        if (!isProductExsist) {
            System.out.println("Không có ID");
        }
    }

    public void sortByPrice() {
        PriceComparator priceComparator = new PriceComparator();
        Collections.sort(products,priceComparator);
    }
}
