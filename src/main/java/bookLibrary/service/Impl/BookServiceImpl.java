package bookLibrary.service.Impl;

import bookLibrary.model.Book;
import bookLibrary.model.Library;
import bookLibrary.model.Person;
import bookLibrary.model.PersonComparator;
import bookLibrary.service.BookService;
import bookLibrary.service.LibraryService;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BookServiceImpl implements BookService {

//CREATING A QUEUE TO LINE PERSONS
public PriorityQueue<Person>  personPriorityQueue;
//public PriorityQueue<Person>  personPriorityQueue1;

//CREATE A CONSTRUCTOR TO INITIALISE THE PERSONPRIORITY QUEUE
public BookServiceImpl(){
    personPriorityQueue = new PriorityQueue<>(new PersonComparator());


}
    @Override
    public void addPersonstoQueue(Person person) {

    personPriorityQueue.add(person);
    }

    @Override
    public String borrowBook(Book book) {
      if(personPriorityQueue.isEmpty()){
          return "No person on the queue";
      } if(book.getCurrentNoOfCopies() ==0){
          return "Book taken";
        }
      Person person = personPriorityQueue.poll();
      book.setCurrentNoOfCopies(book.getCurrentNoOfCopies() - 1); // Decrease the book copy count as we borrow

        assert person != null;
        return person.getFullName() + " has borrowed "+ book.getBookName() + ".";
    }

}
