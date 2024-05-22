package bookLibrary.service.Impl;
import bookLibrary.model.Book;
import bookLibrary.model.Person;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImpl2Test {
    private BookServiceImpl2 bookService;
    private Book book;
    private Person person1;
    private Person person2;

    @BeforeEach
    public void setUp() {
        bookService = new BookServiceImpl2();
        book = new Book(1, "Effective Java", 2, 2);

        person1 = new Person("John Doe", true, false, false);
        person2 = new Person("Jane Smith", false, false, true);
    }

    @Test
    public void testAddToQueueOnFirstCome() {
        bookService.addToQueueOnFirstCome(person1);
        assertEquals(1, bookService.peopleQueue.size());
        assertEquals(person1, bookService.peopleQueue.peek());
    }

    @Test
    public void testGetBookOnFirstCome_NoPersonInQueue() {
        String result = bookService.getBookOnFirstCome(book);
        assertEquals("No person in the queue", result);
    }

    @Test
    public void testGetBookOnFirstCome_BookTaken() {
        book.setCurrentNoOfCopies(0);
        bookService.addToQueueOnFirstCome(person1);

        String result = bookService.getBookOnFirstCome(book);
        assertEquals("Book taken", result);
    }

    @Test
    public void testGetBookOnFirstCome_SuccessfulBorrow() {
        bookService.addToQueueOnFirstCome(person1);
        bookService.addToQueueOnFirstCome(person2);

        String result1 = bookService.getBookOnFirstCome(book);
        assertEquals("John Doe is the first person to get the book 'Effective Java' ", result1);

        String result2 = bookService.getBookOnFirstCome(book);
        assertEquals("Jane Smith is the second person to get the book 'Effective Java' ", result2);

        assertEquals(0, book.getCurrentNoOfCopies());
    }

}