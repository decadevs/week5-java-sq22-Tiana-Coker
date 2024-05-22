package bookLibrary.service.Impl;

import bookLibrary.model.Book;
import bookLibrary.model.Person;
import bookLibrary.model.PersonComparator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
    private BookServiceImpl bookService;
    private Book book;
    private Person person1;
    private Person person2;

    @BeforeEach
    public void setUp() {
        bookService = new BookServiceImpl();
        book = new Book(1, "Effective Java", 2, 2);

        person1 = new Person("John Doe", true, false, false);
        person2 = new Person("Jane Smith", false, false, true);
    }

    @Test
    public void testAddPersonstoQueue() {
        bookService.addPersonstoQueue(person1);
        assertEquals(1, bookService.personPriorityQueue.size());
        assertEquals(person1, bookService.personPriorityQueue.peek());
    }

    @Test
    public void testBorrowBook_NoPersonInQueue() {
        String result = bookService.borrowBook(book);
        assertEquals("No person on the queue", result);
    }

    @Test
    public void testBorrowBook_BookTaken() {
        book.setCurrentNoOfCopies(0);
        bookService.addPersonstoQueue(person1);

        String result = bookService.borrowBook(book);
        assertEquals("Book taken", result);
    }

    @Test
    public void testBorrowBook_SuccessfulBorrow() {
        bookService.addPersonstoQueue(person1);
        bookService.addPersonstoQueue(person2);

        String result1 = bookService.borrowBook(book);
        assertEquals("John Doe has borrowed Effective Java.", result1);

        String result2 = bookService.borrowBook(book);
        assertEquals("Jane Smith has borrowed Effective Java.", result2);

        assertEquals(0, book.getCurrentNoOfCopies());
    }

}