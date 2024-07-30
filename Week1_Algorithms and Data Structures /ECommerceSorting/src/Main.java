import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Order[] orders = {
                new Order(1, "Grace", 250.75),
                new Order(2, "Prakash", 120.50),
                new Order(3, "Joe", 320.00),
                new Order(4, "Ernest", 150.20),
                new Order(5, "Annie", 450.00)
        };

        System.out.println("Choose sorting method: 1. Bubble Sort 2. Quick Sort");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                Sort.bubbleSort(orders);
                break;
            case 2:
                Sort.quickSort(orders, 0, orders.length - 1);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Sorted orders by total price:");
        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}
