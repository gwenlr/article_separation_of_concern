package tech.article.soc.example2;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.Book;
import tech.article.soc.model.Client;
import tech.article.soc.model.UnknownClientException;

import java.util.*;

import static org.apache.commons.lang3.Validate.notNull;

public class BorrowingService2 {

    private static final int MAX_BORROWED_BOOK_COUNT = 5;
    private ClientService clientService;
    private final Map<Client, Set<Book>> borrowedBookMap = new HashMap<>();


    /**
     * Check if the client's borrowed books number is the maximum
     *
     * @param client the client borrowing the book
     * @throws UnknownClientException if the client is not registered in the library
     */
    public boolean isMaximumBookBorrowed(@NotNull Client client) {
        verifyClientRegistered(client);
        return getBorrowedBookCount(client) >= MAX_BORROWED_BOOK_COUNT;
    }


    private int getBorrowedBookCount(@NotNull Client client) {
        Set<Book> borrowedBookSet = borrowedBookMap.getOrDefault(client, Collections.emptySet());
        return borrowedBookSet.size();
    }


    private void verifyClientRegistered(@NotNull Client client) {
        notNull(client, "client argument shall not be null");
        if (!clientService.isRegisteredClient(client))
            throw new UnknownClientException("Client " + client + " is not registered in the library");
    }
}