import java.util.ArrayList;
import java.util.List;

// Book class (can exist independently of a Library)
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + "', author='" + author + "'}";
    }
}

// Library class (contains multiple Book objects)
class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        System.out.println("Library: " + name);
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
        System.out.println();
    }
}

// Main class to demonstrate aggregation
public class LibraryAggregationDemo {
    public static void main(String[] args) {
        // Creating books (independent objects)
        Book book1 = new Book("The Alchemist", "Paulo Coelho");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book4 = new Book("Pride and Prejudice", "Jane Austen");

        // Creating libraries
        Library cityLibrary = new Library("City Library");
        Library universityLibrary = new Library("University Library");

        // Adding books to different libraries
        cityLibrary.addBook(book1);
        cityLibrary.addBook(book2);

        universityLibrary.addBook(book3);
        universityLibrary.addBook(book4);

        // Displaying books in each library
        cityLibrary.showBooks();
        universityLibrary.showBooks();
    }
}
