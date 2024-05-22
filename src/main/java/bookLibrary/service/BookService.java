package bookLibrary.service;

import bookLibrary.model.Book;
import bookLibrary.model.Person;

public interface BookService {
    public void addPersonstoQueue(Person person);

    public String borrowBook(Book book);


    //A book library where a student, teacher borrow books.
    // When the copy of the book is no longer in the library.
    // The library should return ‘book taken’.
    // They can be multiple copies of the same book in the library.

}
