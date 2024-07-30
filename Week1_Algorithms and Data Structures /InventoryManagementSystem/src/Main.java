import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addProduct(inventory, scanner);
                    break;
                case 2:
                    updateProduct(inventory, scanner);
                    break;
                case 3:
                    deleteProduct(inventory, scanner);
                    break;
                case 4:
                    inventory.displayProducts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addProduct(Inventory inventory, Scanner scanner) {
        System.out.print("Enter product ID: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
            System.out.print("Enter product ID: ");
        }
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter quantity: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
            System.out.print("Enter quantity: ");
        }
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter price: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
            System.out.print("Enter price: ");
        }
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline

        Product product = new Product(productId, productName, quantity, price);
        inventory.addProduct(product);
    }

    private static void updateProduct(Inventory inventory, Scanner scanner) {
        System.out.print("Enter product ID to update: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
            System.out.print("Enter product ID to update: ");
        }
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter new product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter new quantity: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
            System.out.print("Enter new quantity: ");
        }
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter new price: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
            System.out.print("Enter new price: ");
        }
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline

        Product updatedProduct = new Product(productId, productName, quantity, price);
        inventory.updateProduct(productId, updatedProduct);
    }

    private static void deleteProduct(Inventory inventory, Scanner scanner) {
        System.out.print("Enter product ID to delete: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consumes the invalid input
            System.out.print("Enter product ID to delete: ");
        }
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline
        inventory.deleteProduct(productId);
    }
}
