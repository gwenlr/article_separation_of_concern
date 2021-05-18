package tech.article.soc.example5;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.DetailedBook;
import tech.article.soc.model.NewBookDTO;

public interface BookConverter {

    @NotNull
    DetailedBook convertToDetailedBook(@NotNull NewBookDTO book);
}
