package tech.article.soc.example1;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.*;

import java.util.Set;

public interface LibraryService {

    /**
     * Get all books in the library
     *
     * @return all the books in the library, may be empty
     */
    @NotNull
    Set<Book> getAllBooks();

    /**
     * Register a new client into the library.
     *
     * <p>A registered client is allowed to borrow some books</p>
     *
     * @param client the client to register
     * @throws ClientAlreadyRegisteredException if the client is already registered
     */
    void registerClient(@NotNull Client client) throws ClientAlreadyRegisteredException;


    /**
     * Unregister a client from the library
     *
     * @param client the client to unregister
     * @throws UnknownClientException when the client is not registered in the library
     */
    void unregisterClient(@NotNull Client client) throws UnknownClientException;

    /**
     * Check if a client is registered in the library
     *
     * @param client the client which registration has to be checked
     * @return <code>true</code> if the client is registered in the library, <code>false</code> otherwise
     */
    boolean isClientRegistered(Client client);


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
     * Register a book to the library
     *
     * @param book the book to register
     * @throws BookAlreadyRegisteredException when a book is already registered in the library
     */
    void registerBook(@NotNull Book book) throws BookAlreadyRegisteredException;

    /**
     * Check if a book has been registered into the library
     *
     * @param book the book to analyse
     * @return <code>true</code> if the book has been registered (whatever it is borrowed or not), <code>false</code> if the book does belongs to the library
     */
    boolean isBookRegistered(@NotNull Book book);

    /**
     * Return a book to the library
     *
     * @param book the book to return
     * @throws UnknownBookException         when the book is not registered in the library
     * @throws BookAlreadyReturnedException when the book is not borrowed and still in the library
     */
    void returnBook(@NotNull Book book) throws UnknownBookException, BookAlreadyReturnedException;

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
     * Unregister a book from the library.
     * <p>
     * An unregistered book cannot be borrowed anymore
     * </p>
     *
     * @param book the book to unregister
     * @throws UnknownBookException when the book is not registered in the library
     */
    void unregisterBook(@NotNull Book book) throws UnknownBookException;

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


    /**
     * Get all the clients currently registered in the library
     *
     * @return all the clients registered in the library
     */
    @NotNull
    Set<Client> getAllClients();
}