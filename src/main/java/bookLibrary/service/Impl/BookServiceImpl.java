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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookServiceImpl implements BookService {

    private final Queue<Person> personPriorityQueue;
    private final Queue<Person> peopleQueue;

    public BookServiceImpl() {
        personPriorityQueue = new PriorityQueue<>(new PersonComparator());
        peopleQueue = new LinkedList<>();
    }

    @Override
    public void addPersonToPriorityQueue(Person person) {
        personPriorityQueue.add(person);
    }

    @Override
    public String borrowBookWithPriority(Book book) {
        return borrowBookFromQueue(personPriorityQueue, book, "priority queue");
    }

    @Override
    public void addPersonToFirstComeQueue(Person person) {
        peopleQueue.add(person);
    }

    @Override
    public String borrowBookOnFirstCome(Book book) {
        return borrowBookFromQueue(peopleQueue, book, "first-come-first-serve queue");
    }

    private String borrowBookFromQueue(Queue<Person> queue, Book book, String queueName) {
        try {
            if (queue.isEmpty()) {
                return "No person in the " + queueName;
            }
            if (book.getCurrentNoOfCopies() == 0) {
                return "Book taken";
            }

            Person person = queue.poll();
            book.setCurrentNoOfCopies(book.getCurrentNoOfCopies() - 1);

            int positionOrder = book.getInitialCopies() - book.getCurrentNoOfCopies();
            String positionText = getPositionText(positionOrder);

            return person.getFullName() + " is the " + positionText + " person to get the book '" + book.getBookName() + "'.";
        } catch (Exception e) {
            return "An error occurred while borrowing the book: " + e.getMessage();
        }
    }

    private String getPositionText(int order) {
        return IntStream.of(1, 2, 3)
                .boxed()
                .collect(Collectors.toMap(
                        pos -> pos,
                        pos -> pos == 1 ? "first" : pos == 2 ? "second" : "third"
                ))
                .getOrDefault(order, order + "th");
    }
}
