package bookLibrary.service;

import bookLibrary.model.Book;
import bookLibrary.model.Person;

public interface BookService2 {
    public void addToQueueOnFirstCome(Person person);
    public String getBookOnFirstCome(Book bookName);
}
