import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
    static String openingHours = "9am to 5pm";
    String address;
    ArrayList<Book> books = new ArrayList<>();

    Library(String address) {
        this.address = address;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from " + openingHours);
    }
    public void printAddress() {
        System.out.println(address);
    }
    public void borrowBook(String bookTitle) {
        boolean hasTheBook = false;
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                hasTheBook = true; //这里的位置要写对，不然会出大错
                if (!book.isBorrowed()) {
                    book.borrowed();
                    System.out.println("You successfully borrowed " + bookTitle + ".");
                    break;
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                }
            }
        }
        if (!hasTheBook){
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }

    public void printAvailableBooks() {
        if (books.isEmpty()){
            System.out.println("No book in catalog");
            return;
        }
        boolean hasBookRemain = false;
        for (Book book : books) {
            if (!book.isBorrowed()){ //边界情况：都被借光了
                hasBookRemain = true;
                System.out.println(book.title);
            }
        }
        if (!hasBookRemain) {
            System.out.println("Sorry, no book remain.");
        }
    }

    public void returnBook(String bookTitle) {
        for (Book book : books) {
            if (book.title.equals(bookTitle)) {
                book.returned();
                System.out.println("You successfully returned " + book.title);
            }
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 