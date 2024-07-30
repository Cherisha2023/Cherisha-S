import java.util.Arrays;
import java.util.Scanner;

public class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size >= books.length) {
            System.out.println("Library is full!");
            return;
        }
        books[size++] = book;
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) {
                return books[mid];
            }
            if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, (b1, b2) -> b1.title.compareToIgnoreCase(b2.title));
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem(10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Linear Search by Title");
            System.out.println("3. Binary Search by Title");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter bookId: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(id, title, author);
                    system.addBook(book);
                    system.sortBooksByTitle(); // Keep the books array sorted for binary search
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundLinear = system.linearSearchByTitle(searchTitle);
                    if (foundLinear != null) {
                        System.out.println("Book found: " + foundLinear);
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter title to search: ");
                    String searchBinaryTitle = scanner.nextLine();
                    Book foundBinary = system.binarySearchByTitle(searchBinaryTitle);
                    if (foundBinary != null) {
                        System.out.println("Book found: " + foundBinary);
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
