package tech.article.soc.example5;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.NewBookDTO;

public interface BookReceptionService {
    void receiveNewBook(@NotNull NewBookDTO newBook);
}
