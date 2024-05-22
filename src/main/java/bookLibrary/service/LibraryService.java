package bookLibrary.service;

import bookLibrary.model.Book;
import bookLibrary.model.Library;

public interface LibraryService {
   public void addBook(Library library, Book book);

  public  int getTotalBooks(Library library);
}
