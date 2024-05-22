package bookLibrary;

import bookLibrary.model.Book;
import bookLibrary.model.Library;
import bookLibrary.model.Person;
import bookLibrary.service.Impl.BookServiceImpl;
import bookLibrary.service.Impl.BookServiceImpl2;
import bookLibrary.service.Impl.LibraryServiceImpl;

public class Main {
    public static void main(String[] args) {
    //CREATE A LIBRARY
    Library library = new Library();

    // CREATE AN INSTANCE OF LIBRARY SERVICE
    LibraryServiceImpl libraryService = new LibraryServiceImpl();

    //CREATE TWO INSTANCES OF BOOKS
    Book book1 = new Book(1,"Java for Beginners",2,5);
    Book book2 = new Book(2,"Intro to Testing",1,1);

    //ADD BOOKS TO LIBRARY
   libraryService.addBook(library,book1);
   libraryService.addBook(library,book2);

    //LET'S SEE THE TOTAL BOOKS IN THE LIBRARY
    System.out.println("Total Books in the library: "+ library.getTotalBooks());


    //CREATE TWO INSTANCES OF PERSON
    Person person1 = new Person("Okoro Esther",false,true,false);
    Person person2 = new Person("Edet Richard",false,true,false);
    Person person3 = new Person("Ogunyemi John",false,false,true);



    //PRIORITY QUEUE IMPLEMENTATION
    BookServiceImpl bookService = new BookServiceImpl();

    //FIRST COME,FIRST SERVE
    BookServiceImpl2 bookService2 = new BookServiceImpl2();

    //BASED ON PRIORITY QUEUE
    bookService.addPersonstoQueue(person1);
    bookService.addPersonstoQueue(person2);
    bookService.addPersonstoQueue(person3);

    //BASED ON FIRST COME FIRST SERVE
    bookService2.addToQueueOnFirstCome(person1);
    bookService2.addToQueueOnFirstCome(person2);
    bookService2.addToQueueOnFirstCome(person3);

    //PRINTING TO SEE WHO GETS THE BOOK
    System.out.println("************************************");
    System.out.println("BASED ON PRIORITY:Teacher First, Senior Second, Junior Last");
    System.out.println("************************************");

    System.out.println(bookService.borrowBook(book1));
    System.out.println(bookService.borrowBook(book1));

    System.out.println("************************************");
    System.out.println("FIRST COME, FIRST SERVE");
    System.out.println("************************************");

    System.out.println(bookService2.getBookOnFirstCome(book1));
    System.out.println(bookService2.getBookOnFirstCome(book1));
    System.out.println(bookService2.getBookOnFirstCome(book1));




    }
}
