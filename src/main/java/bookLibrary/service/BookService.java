package bookLibrary.service;

import bookLibrary.model.Book;
import bookLibrary.model.Person;

public interface BookService {
    void addPersonToPriorityQueue(Person person);
    String borrowBookWithPriority(Book book);

    void addPersonToFirstComeQueue(Person person);
    String borrowBookOnFirstCome(Book book);



}
