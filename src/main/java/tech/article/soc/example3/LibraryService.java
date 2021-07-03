package tech.article.soc.example3;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.*;

import java.util.*;

import static org.apache.commons.lang3.Validate.notNull;

public class LibraryService {

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
        notNull(book, "book argument shall not be null");
        notNull(client, "client argument shall not be null");

        if (!clientSet.contains(client))
            throw new UnknownClientException("Client " + client + " is not registered in the library");

        if (!bookSet.contains(book))
            throw new UnknownBookException("Book " + book + " is not registered in the library");

        if (borrowedBookMap.containsKey(client) && borrowedBookMap.get(client).contains(book))
            return;

        boolean borrowedBook = borrowedBookMap.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(it -> it.equals(book));
        if (borrowedBook)
            throw new BookAlreadyBorrowedException("Book " + book + " has already been registered");

        if (!borrowedBookMap.containsKey(client))
            borrowedBookMap.put(client, new HashSet<>());

        Set<Book> borrowedBookSet = borrowedBookMap.get(client);
        borrowedBookSet.add(book);
    }
}