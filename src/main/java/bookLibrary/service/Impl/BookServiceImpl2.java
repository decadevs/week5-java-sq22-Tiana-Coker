package bookLibrary.service.Impl;

import bookLibrary.model.Book;
import bookLibrary.model.Person;
import bookLibrary.service.BookService;
import bookLibrary.service.BookService2;

import java.util.LinkedList;
import java.util.Queue;

public class BookServiceImpl2 implements BookService2 {
    // Create a queue to hold the people waiting for books
    Queue<Person> peopleQueue;

    public BookServiceImpl2() {
        peopleQueue = new LinkedList<>();;
    }

    @Override
    public void addToQueueOnFirstCome(Person person) {
              peopleQueue.add(person);
    }

    @Override
    public String getBookOnFirstCome(Book bookName) {
        if (peopleQueue.isEmpty()) {
            return "No person in the queue";
        }
        if (bookName.getCurrentNoOfCopies() == 0) {
            return "Book taken";
        }

        // Calculate the position order based on initial copies and current copies
        int positionOrder = bookName.getInitialCopies() - bookName.getCurrentNoOfCopies() + 1;

        Person person = peopleQueue.poll();
        String positionText = getPositionText(positionOrder); // Get the correct position text
        bookName.setCurrentNoOfCopies(bookName.getCurrentNoOfCopies() - 1); // Decrease the book copy count

        assert person != null;
        return person.getFullName() +" is the " + positionText +" person to get the book '" + bookName.getBookName() + "' " ;

    }

    // Method to get the correct position text(e.g first to get,second to get)
    private String getPositionText(int order) {
        switch (order) {
            case 1:
                return "first";
            case 2:
                return "second";
            case 3:
                return "third";
            default:
                return order + "th";
        }
    }
}
