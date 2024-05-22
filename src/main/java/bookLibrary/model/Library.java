package bookLibrary.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private int totalBooks;

    public Library() {
        this.books = new ArrayList<>(); // Initialize the books list
        this.totalBooks = 0;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }
}
