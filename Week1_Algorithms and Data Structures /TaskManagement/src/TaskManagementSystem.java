import java.util.Scanner;
public class TaskManagementSystem {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskManagementSystem() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }
        if (head.task.taskId == taskId) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.task.taskId != taskId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Task not found!");
        } else {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter taskId: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter taskName: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();
                    Task task = new Task(id, name, status);
                    system.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter taskId to search: ");
                    int searchId = scanner.nextInt();
                    Task found = system.searchTask(searchId);
                    if (found != null) {
                        System.out.println("Task found: " + found);
                    } else {
                        System.out.println("Task not found!");
                    }
                    break;
                case 3:
                    system.traverseTasks();
                    break;
                case 4:
                    System.out.print("Enter taskId to delete: ");
                    int deleteId = scanner.nextInt();
                    system.deleteTask(deleteId);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
