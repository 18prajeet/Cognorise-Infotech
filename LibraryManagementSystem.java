import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;  // Default status is available
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Set book availability
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}

// LibraryCatalog class
class LibraryCatalog {
    private ArrayList<Book> books;

    // Constructor
    public LibraryCatalog() {
        books = new ArrayList<>();
    }

    // Add a book to the catalog
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Search for a book by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                found = true;
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor() +
                        " - " + (book.isAvailable() ? "Available" : "Checked Out"));
            }
        }
        if (!found) {
            System.out.println("No book found with the title: " + title);
        }
    }

    // Search for a book by author
    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                found = true;
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor() +
                        " - " + (book.isAvailable() ? "Available" : "Checked Out"));
            }
        }
        if (!found) {
            System.out.println("No book found by the author: " + author);
        }
    }

    // Check out a book
    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book checked out: " + book.getTitle());
                } else {
                    System.out.println("Book is already checked out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return a book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned: " + book.getTitle());
                } else {
                    System.out.println("Book was not checked out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);
        
        // Adding some books
        catalog.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        catalog.addBook(new Book("1984", "George Orwell"));
        catalog.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        // Sample menu for testing
        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. Check Out Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add a new book
                    System.out.print("Enter title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String newAuthor = scanner.nextLine();
                    catalog.addBook(new Book(newTitle, newAuthor));
                    break;
                case 2:
                    // Search by title
                    System.out.print("Enter title: ");
                    String searchTitle = scanner.nextLine();
                    catalog.searchByTitle(searchTitle);
                    break;
                case 3:
                    // Search by author
                    System.out.print("Enter author: ");
                    String searchAuthor = scanner.nextLine();
                    catalog.searchByAuthor(searchAuthor);
                    break;
                case 4:
                    // Check out a book
                    System.out.print("Enter title: ");
                    String checkOutTitle = scanner.nextLine();
                    catalog.checkOutBook(checkOutTitle);
                    break;
                case 5:
                    // Return a book
                    System.out.print("Enter title: ");
                    String returnTitle = scanner.nextLine();
                    catalog.returnBook(returnTitle);
                    break;
                case 6:
                    // Exit
                    System.out.println("Exiting library system.");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}