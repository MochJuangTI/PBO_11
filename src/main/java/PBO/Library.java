package PBO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private static final String FILE_PATH = "library.json";
    private Gson gson;

    public Library() {
        this.gson = new Gson();
        this.books = new ArrayList<>();
        loadBooks();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public void borrowBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id) && !book.isBorrowed()) {
                book.setBorrowed(true);
                saveBooks();
                System.out.println("Book borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id) && book.isBorrowed()) {
                book.setBorrowed(false);
                saveBooks();
                System.out.println("Book returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void loadBooks() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
            books = gson.fromJson(reader, listType);
            if (books == null) {
                books = new ArrayList<>();
            }
        } catch (IOException e) {
            books = new ArrayList<>();
        }
    }

    private void saveBooks() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(books, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
