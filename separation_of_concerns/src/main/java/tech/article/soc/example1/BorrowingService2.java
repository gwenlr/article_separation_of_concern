package tech.article.soc.example1;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.*;

import java.util.Set;

public interface BorrowingService2 {

    /**
     * Get all available books in the library
     * <p>
     * A book is available if it is registered but not borrowed
     * </p>
     *
     * @return all the books
     */
    @NotNull
    Set<Book> getAvailableBooks();


    /**
     * Borrow a book.
     * <p>
     * Once borrowed, a book is not borrowable until it is returned
     * </p>
     *
     * @param book the book to borrow
     * @throws UnknownBookException         when the book is not registered in the library
     * @throws BookAlreadyBorrowedException when the book has already been registered
     */
    void borrowBook(@NotNull Book book) throws UnknownBookException, BookAlreadyBorrowedException;


    /**
     * Get the clients who has borrowed one or more books
     *
     * @return a list of clients, empty when no book have been borrowed
     */
    @NotNull
    Set<Client> getClientsWithBorrowedBooks();


    /**
     * Return a book to the library
     *
     * @param book the book to return
     * @throws UnknownBookException         when the book is not registered in the library
     * @throws BookAlreadyReturnedException when the book is not borrowed and still in the library
     */
    void returnBook(@NotNull Book book) throws UnknownBookException, BookAlreadyReturnedException;


    /**
     * Check if a book of the library has been borrowed
     *
     * @param book the book to check
     * @return <code>true</code> if the book has been borrowed, <code>false</code> otherwise
     */
    boolean isBookBorrowed(@NotNull Book book);


    /**
     * Get all the books currently borrowed by a client
     *
     * @param client the client of the library
     * @return all books currently borrowed by the client
     * @throws UnknownClientException when the client is not registered in the library
     */
    @NotNull
    Set<Book> getBooksBorrowedByClient(@NotNull Client client) throws UnknownClientException;

}