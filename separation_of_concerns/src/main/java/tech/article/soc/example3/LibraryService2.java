package tech.article.soc.example3;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.*;

import java.util.*;

import static org.apache.commons.lang3.Validate.notNull;

public class LibraryService2 {

    private final Set<Book> bookSet = new HashSet<>();
    private final Set<Client> clientSet = new HashSet<>();
    private final Map<Client, Set<Book>> borrowedBookMap = new HashMap<>();


    /**
     * Borrow a book for a client
     *
     * @param book   the book to borrow
     * @param client the client borrowing the book
     * @throws UnknownBookException         if the book is not registered in the library
     * @throws UnknownClientException       if the client is not registered in the library
     * @throws BookAlreadyBorrowedException if the book has already been registered by another client
     */
    public void borrowBook(@NotNull Book book, @NotNull Client client) throws UnknownBookException, UnknownClientException, BookAlreadyBorrowedException {
        verifyRegisteredClient(client);
        verifyRegisteredBook(book);

        if (isBookAlreadyBorrowedByClient(book, client))
            return;

        verifyBookNotBorrowed(book);

        addBookToClient(book, client);
    }


    private void verifyRegisteredClient(Client client) {
        notNull(client, "client argument shall not be null");
        if (!clientSet.contains(client))
            throw new UnknownClientException("Client " + client + " is not registered in the library");
    }


    private void verifyRegisteredBook(Book book) {
        notNull(book, "book argument shall not be null");
        if (!bookSet.contains(book))
            throw new UnknownBookException("Book " + book + " is not registered in the library");
    }


    private boolean isBookAlreadyBorrowedByClient(@NotNull Book book, @NotNull Client client) {
        Set<Book> borrowedBookSet = borrowedBookMap.getOrDefault(client, Collections.emptySet());
        return borrowedBookSet.contains(book);
    }


    private void verifyBookNotBorrowed(@NotNull Book book) {
        if (isBorrowedBook(book))
            throw new BookAlreadyBorrowedException("Book " + book + " has already been registered");
    }


    private boolean isBorrowedBook(@NotNull Book book) {
        return borrowedBookMap.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(it -> it.equals(book));
    }


    private void addBookToClient(@NotNull Book book, @NotNull Client client) {
        Set<Book> borrowedBookSet = getBooksBorrowedByClient(client);
        borrowedBookSet.add(book);
    }


    private Set<Book> getBooksBorrowedByClient(@NotNull Client client) {
        if (!borrowedBookMap.containsKey(client))
            borrowedBookMap.put(client, new HashSet<>());

        return borrowedBookMap.get(client);
    }
}