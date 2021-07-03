package tech.article.soc.example1;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.Book;
import tech.article.soc.model.BookAlreadyRegisteredException;
import tech.article.soc.model.UnknownBookException;

import java.util.Set;

public interface BookService2 {


    /**
     * Get all books in the library
     *
     * @return all the books in the library, may be empty
     */
    @NotNull
    Set<Book> getAllBooks();


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
     * Unregister a book from the library.
     * <p>
     * An unregistered book cannot be borrowed anymore
     * </p>
     *
     * @param book the book to unregister
     * @throws UnknownBookException when the book is not registered in the library
     */
    void unregisterBook(@NotNull Book book) throws UnknownBookException;

}