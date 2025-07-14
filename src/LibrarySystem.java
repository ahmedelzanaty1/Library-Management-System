import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private Scanner scanner;

    public LibrarySystem() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // ======================
    // Book Operations
    // ======================

    public void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("✅ Book added successfully.");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("❗ No books found.");
            return;
        }
        System.out.println("📚 List of Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = scanner.nextInt();

        Book bookToRemove = findBookById(id);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("✅ Book deleted.");
        } else {
            System.out.println("❌ Book not found.");
        }
    }

    // ======================
    // Member Operations
    // ======================

    public void registerMember() {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();

        members.add(new Member(id, name));
        System.out.println("✅ Member registered.");
    }

    public void listMembers() {
        if (members.isEmpty()) {
            System.out.println("❗ No members found.");
            return;
        }
        System.out.println("👤 List of Members:");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    // ======================
    // Borrowing Operations
    // ======================

    public void borrowBook() {
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        if (member == null || book == null) {
            System.out.println("❌ Member or Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("❗ Book is already borrowed.");
            return;
        }

        book.setAvailable(false);
        member.borrowBook(book);
        System.out.println("✅ Book borrowed successfully.");
    }

    public void returnBook() {
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        if (member == null || book == null) {
            System.out.println("❌ Member or Book not found.");
            return;
        }

        if (!member.getBorrowedBooks().contains(book)) {
            System.out.println("❗ Member has not borrowed this book.");
            return;
        }

        member.returnBook(book);
        book.setAvailable(true);
        System.out.println("✅ Book returned successfully.");
    }

    // ======================
    // Helper Methods
    // ======================

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id)
                return book;
        }
        return null;
    }

    private Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id)
                return member;
        }
        return null;
    }
}

