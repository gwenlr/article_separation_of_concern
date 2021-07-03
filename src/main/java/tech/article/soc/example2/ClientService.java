package tech.article.soc.example2;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.Client;

public interface ClientService {

    /**
     * Check if client is registered to the service
     *
     * @param client a client
     * @return <code>true</code> if the client is registered, <code>false</code> otherwise
     */
    boolean isRegisteredClient(@NotNull Client client);

}
