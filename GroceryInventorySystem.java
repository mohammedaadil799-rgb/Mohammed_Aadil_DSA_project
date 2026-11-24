
import java.util.*;

public class GroceryInventorySystem {

    // 1. ArrayList to store products
    static ArrayList<Product> products = new ArrayList<>();

    // 2. HashMap to search products using ID
    static HashMap<Integer, Product> productMap = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    // Add sample products
    public static void addSampleProducts() {

        addProduct(101, "Rice", 60, 50);
        addProduct(102, "Milk", 30, 20);
        addProduct(103, "Sugar", 45, 35);
        addProduct(104, "Bread", 40, 15);
        addProduct(105, "Oil", 150, 10);
    }

    // 3. Add Product
    public static void addProduct() {

        System.out.print("Enter Product ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (productMap.containsKey(id)) {
            System.out.println("Product ID already exists!");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        if (name.trim().isEmpty() || price < 0 || quantity < 0) {
            System.out.println("Invalid product details!");
            return;
        }

        addProduct(id, name, price, quantity);

        System.out.println("Product Added Successfully!");
    }

    // Helper method to add in both collections
    public static void addProduct(
            int id, String name, double price, int quantity) {

        Product p = new Product(id, name, price, quantity);

        products.add(p);
        productMap.put(id, p);
    }

    // 4. Display all products
    public static void displayProducts() {

        if (products.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        System.out.println("\nID        Name            Price        Quantity");
        System.out.println("------------------------------------------------");

        for (Product p : products) {
            p.displayProduct();
        }
    }

    // 5. Search using HashMap
    public static void searchProduct() {

        System.out.print("Enter Product ID to search: ");
        int id = Integer.parseInt(sc.nextLine());

        if (productMap.containsKey(id)) {

            Product p = productMap.get(id);

            System.out.println("\nProduct Found!");
            System.out.println("ID: " + p.id);
            System.out.println("Name: " + p.name);
            System.out.println("Price: " + p.price);
            System.out.println("Quantity: " + p.quantity);

        } else {
            System.out.println("Product Not Found!");
        }
    }

    // 6. Update product
    public static void updateProduct() {

        System.out.print("Enter Product ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Product p = productMap.get(id);

        if (p == null) {
            System.out.println("Product Not Found!");
            return;
        }

        System.out.print("Enter New Price: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Enter New Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        if (price < 0 || quantity < 0) {
            System.out.println("Invalid values!");
            return;
        }

        p.price = price;
        p.quantity = quantity;

        System.out.println("Product Updated Successfully!");
    }

    // 7. Delete product
    public static void deleteProduct() {

        System.out.print("Enter Product ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        Product p = productMap.get(id);

        if (p != null) {

            products.remove(p);
            productMap.remove(id);

            System.out.println("Product Deleted Successfully!");

        } else {
            System.out.println("Product Not Found!");
        }
    }

    // 8. Bubble Sort by price (Manual Sorting)
    public static void bubbleSortByPrice() {

        int n = products.size();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (products.get(j).price >
                    products.get(j + 1).price) {

                    Product temp = products.get(j);

                    products.set(j, products.get(j + 1));

                    products.set(j + 1, temp);
                }
            }
        }

        System.out.println("Sorted by Price using Bubble Sort!");
        displayProducts();
    }

    // 9. Selection Sort by quantity (Manual Sorting)
    public static void selectionSortByQuantity() {

        int n = products.size();

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (products.get(j).quantity <
                    products.get(minIndex).quantity) {

                    minIndex = j;
                }
            }

            Product temp = products.get(i);

            products.set(i, products.get(minIndex));

            products.set(minIndex, temp);
        }

        System.out.println("Sorted by Quantity using Selection Sort!");
        displayProducts();
    }

    // 10. Built-in sorting by product name
    public static void builtInSortByName() {

        products.sort(
            Comparator.comparing(p -> p.name.toLowerCase())
        );

        System.out.println("Sorted Alphabetically using Built-in Sort!");
        displayProducts();
    }

    // 11. Built-in sorting by price
    public static void builtInSortByPrice() {

        products.sort(
            Comparator.comparingDouble(p -> p.price)
        );

        System.out.println("Sorted by Price using Built-in Sort!");
        displayProducts();
    }

    // 12. Display products with low stock
    public static void lowStockProducts() {

        System.out.println("\nProducts with quantity below 10:");

        boolean found = false;

        for (Product p : products) {

            if (p.quantity < 10) {
                p.displayProduct();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No low-stock products!");
        }
    }

    // 13. Main menu
    public static void main(String[] args) {

        addSampleProducts();

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("    GROCERY INVENTORY SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Bubble Sort (Price)");
            System.out.println("7. Selection Sort (Quantity)");
            System.out.println("8. Built-in Sort (Name)");
            System.out.println("9. Built-in Sort (Price)");
            System.out.println("10. Check Low Stock");
            System.out.println("11. Exit");

            System.out.print("\nEnter Your Choice: ");

            choice = Integer.parseInt(sc.nextLine());
            
            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    displayProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateProduct();
                    break;

                case 5:
                    deleteProduct();
                    break;

                case 6:
                    bubbleSortByPrice();
                    break;

                case 7:
                    selectionSortByQuantity();
                    break;

                case 8:
                    builtInSortByName();
                    break;

                case 9:
                    builtInSortByPrice();
                    break;

                case 10:
                    lowStockProducts();
                    break;

                case 11:
                    System.out.println("Thank You for Using Grocery Inventory System!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 11);

        sc.close();
    }

// Product Class
static class Product {

    int id;
    String name;
    double price;
    int quantity;

    // Constructor
    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Display Product
    public void displayProduct() {
        System.out.printf("%-10d %-15s %-12.2f %-10d%n",
                id, name, price, quantity);
    }
}}
