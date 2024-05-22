package bookLibrary.service.Impl;
import bookLibrary.model.Book;
import bookLibrary.model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {
    private LibraryServiceImpl libraryService;
    private Library library;
    private Book book;

    @BeforeEach
    public void setUp() {
        libraryService = new LibraryServiceImpl();
        library = new Library();
        book = new Book(1, "Effective Java", 2, 2);
    }

    @Test
    public void testAddBook() {
        libraryService.addBook(library, book);
        assertEquals(1, library.getBooks().size());
        assertEquals(1, library.getTotalBooks());
        assertEquals(book, library.getBooks().get(0));
    }

    @Test
    public void testGetTotalBooks() {
        libraryService.addBook(library, book);
        assertEquals(1, libraryService.getTotalBooks(library));
    }

}