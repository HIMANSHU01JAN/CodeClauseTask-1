import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int id;

    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public void listBooks() {
        System.out.println("Library Catalog:");
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. List all books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.next();
                    System.out.print("Enter book author: ");
                    String author = scanner.next();
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    Book book = new Book(title, author, id);
                    library.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter the ID of the book to remove: ");
                    int removeId = scanner.nextInt();
                    library.removeBook(removeId);
                    break;
                case 3:
                    library.listBooks();
                    break;
                case 4:
                    System.out.println("Exiting Library Management System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
