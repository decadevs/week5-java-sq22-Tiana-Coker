package bookLibrary.service.Impl;

import bookLibrary.model.Book;
import bookLibrary.model.Library;
import bookLibrary.service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public void addBook(Library library, Book book) {
        library.getBooks().add(book);
        library.setTotalBooks(library.getBooks().size());
    }

    @Override
    public int getTotalBooks(Library library) {
        return library.getBooks().size();
    }



}
