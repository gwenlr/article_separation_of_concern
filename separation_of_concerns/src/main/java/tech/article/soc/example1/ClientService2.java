package tech.article.soc.example1;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.Client;
import tech.article.soc.model.ClientAlreadyRegisteredException;
import tech.article.soc.model.UnknownClientException;

import java.util.Set;

public interface ClientService2 {


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
     * Check if a client is registered in the library
     *
     * @param client the client which registration has to be checked
     * @return <code>true</code> if the client is registered in the library, <code>false</code> otherwise
     */
    boolean isClientRegistered(Client client);


    /**
     * Unregister a client from the library
     *
     * @param client the client to unregister
     * @throws UnknownClientException when the client is not registered in the library
     */
    void unregisterClient(@NotNull Client client) throws UnknownClientException;


    /**
     * Get all the clients currently registered in the library
     *
     * @return all the clients registered in the library
     */
    @NotNull
    Set<Client> getAllClients();

}