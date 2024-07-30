// src/Main.java
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Smartphone", "Electronics"),
                new Product(3, "Tablet", "Electronics"),
                new Product(4, "Headphones", "Accessories"),
                new Product(5, "Charger", "Accessories")
        };

        Arrays.sort(products); // Sorting the array for binary search

        System.out.println("Enter the product name to search:");
        String productName = scanner.nextLine();

        System.out.println("Choose search method: 1. Linear Search 2. Binary Search");
        int choice = scanner.nextInt();
        Product result = null;
        switch (choice) {
            case 1:
                result = Search.linearSearch(products, productName);
                break;
            case 2:
                result = Search.binarySearch(products, productName);
                break;
            default:
                System.out.println("Invalid choice.");
        }
        //The Binary Search algorithm works to find the target element
        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product not found.");
        }

        scanner.close(); //Make sure to close the scanner properly
    }
}
