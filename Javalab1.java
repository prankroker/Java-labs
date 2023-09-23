import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "Назва: " + title + ", Автор: " + author + ", ISBN: " + isbn + ", Рік: " + publicationYear;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Книгу додано до бібліотеки під назвою: " + book.getTitle());
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Тут нічого ще немає.");
        }
        else if(books.size()<2){
            System.out.println("Наявна книга: ");
            for (Book book : books) {
                System.out.println(book);
            }
        } 
        else {
            System.out.println("Наявні книги: ");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void removeBookByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                System.out.println("Книгу було видалено: " + books.get(i).getTitle());
                books.remove(i);
                return;
            }
        }
        System.out.println("Книги за ISBN " + isbn + " не було знайдено.");
    }
}
public class Javalab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nМеню опцій:");
            System.out.println("1. Додати книгу");
            System.out.println("2. Вивести книжки");
            System.out.println("3. Знайти книжку");
            System.out.println("4. Видалити книжку за ISBN");
            System.out.println("5. Вихід");

            System.out.print("Введіть ваш вибір: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Назва: ");
                    String title = scanner.nextLine();
                    System.out.print("Автор: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Рік публікації: ");
                    int year = scanner.nextInt();
                    Book newBook = new Book(title, author, isbn, year);
                    library.addBook(newBook);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Введіть назву книжки: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Книгу знайдено:\n" + foundBook);
                    } else {
                        System.out.println("Книгу не знайдено.");
                    }
                    break;
                case 4:
                    System.out.print("Введіть ISBN для видалення книги: ");
                    String removeIsbn = scanner.nextLine();
                    library.removeBookByIsbn(removeIsbn);
                    break;
                case 5:
                    System.out.println("Вихід.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Виберіть доступний варіант.");
            }
        }
    }
}