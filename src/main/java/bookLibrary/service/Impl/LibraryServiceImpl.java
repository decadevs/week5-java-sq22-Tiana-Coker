package bookLibrary.service.Impl;

import bookLibrary.model.Book;
import bookLibrary.model.Library;
import bookLibrary.service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {


    @Override
    public void addBook(Library library, Book book) {
        List<Book> books = library.getBooks(); //get list of books from getBooks(getter method)
        books.add(book);   //it adds the new book to the retrieved list of books
        library.setBooks(books); //updates the list of books using (setter method-setbook)
        library.setTotalBooks(library.getTotalBooks() + 1);

    }


    @Override
    public int getTotalBooks(Library library) {
        return library.getTotalBooks();

    }
}
