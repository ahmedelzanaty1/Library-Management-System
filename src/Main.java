import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        library.addBook();
                        break;
                    case 2:
                        library.listBooks();
                        break;
                    case 3:
                        library.deleteBook();
                        break;
                    case 4:
                        library.registerMember();
                        break;
                    case 5:
                        library.listMembers();
                        break;
                    case 6:
                        library.borrowBook();
                        break;
                    case 7:
                        library.returnBook();
                        break;
                    case 0:
                        System.out.println("👋 Exiting the system. Goodbye!");
                        return;
                    default:
                        System.out.println("❗ Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("❗ Error: Please enter a valid number.");
                scanner.nextLine(); // clear input buffer
            }

            System.out.println(); // space between iterations
        }

    }
    private static void showMenu() {
        System.out.println("========== 📚 Library Management System ==========");
        System.out.println("1. Add Book");
        System.out.println("2. List All Books");
        System.out.println("3. Delete Book");
        System.out.println("4. Register Member");
        System.out.println("5. List Members");
        System.out.println("6. Borrow Book");
        System.out.println("7. Return Book");
        System.out.println("0. Exit");
        System.out.println("==================================================");
    }
}