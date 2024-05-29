package bookLibrary;

import bookLibrary.model.Book;
import bookLibrary.model.Library;
import bookLibrary.model.Person;
import bookLibrary.service.Impl.BookServiceImpl;
import bookLibrary.service.Impl.LibraryServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Create an instance of LibraryService
        LibraryServiceImpl libraryService = new LibraryServiceImpl();

        // Create three instances of books
        Book book1 = new Book(1, "Java for Beginners", 2, 2);
        Book book2 = new Book(2, "Intro to Testing", 1, 1);
        Book book3 = new Book(3, "Advanced Java", 2, 2);

        // Add books to the library

        Arrays.asList(book1, book2, book3).forEach(book -> libraryService.addBook(library, book));

        // Display the total books in the library
        System.out.println("Total Books in the library: " + libraryService.getTotalBooks(library));

        // Create instances of persons
        Person person1 = new Person("Okoro Esther", true, false, false);
        Person person2 = new Person("Edet Richard", false, true, false);
        Person person3 = new Person("Ogunyemi John", false, false, true);

        // Priority queue implementation
        BookServiceImpl bookService = new BookServiceImpl();

        // Based on priority queue
        Arrays.asList(person1, person2, person3).forEach(bookService::addPersonToPriorityQueue);

        // Printing to see who gets the book
        System.out.println("************************************");
        System.out.println("BASED ON PRIORITY: Teacher First, Senior Second, Junior Last");
        System.out.println("************************************");

        System.out.println(bookService.borrowBookWithPriority(book1));
        System.out.println(bookService.borrowBookWithPriority(book1));
        System.out.println(bookService.borrowBookWithPriority(book1)); // Additional borrow to test when book is taken

        // First come, first served
        // Based on first come, first served
        Arrays.asList(person1, person2, person3).forEach(bookService::addPersonToFirstComeQueue);

        System.out.println("************************************");
        System.out.println("FIRST COME, FIRST SERVE");
        System.out.println("************************************");

        System.out.println(bookService.borrowBookOnFirstCome(book3));
        System.out.println(bookService.borrowBookOnFirstCome(book3));
        System.out.println(bookService.borrowBookOnFirstCome(book3)); // Additional borrow to test when book is taken
    }
}
