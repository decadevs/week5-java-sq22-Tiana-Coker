package bookLibrary.model;

public class Book {
    //my library consist of books
    private int bookId;
    private String bookName;
    private int initialCopies;
    private int currentNoOfCopies;

   //CONSTRUCTOR
    public Book(int bookId, String bookName, int initialCopies, int currentNoOfCopies ) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.initialCopies = initialCopies;
        this.currentNoOfCopies = currentNoOfCopies;
    }
//GETTERS AND SETTERS
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getInitialCopies() {
        return initialCopies;
    }

    public void setInitialCopies(int initialCopies) {
        this.initialCopies = initialCopies;
    }

    public int getCurrentNoOfCopies() {
        return currentNoOfCopies;
    }

    public void setCurrentNoOfCopies(int currentNoOfCopies) {
        this.currentNoOfCopies = currentNoOfCopies;
    }
}
