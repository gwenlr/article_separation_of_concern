package tech.article.soc.example4;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tech.article.soc.model.Book;
import tech.article.soc.model.BookJson;

import java.util.List;
import java.util.Set;

import static tech.article.soc.example4.BookJsonHelper.toJson;

public class LibraryRestService2 {

    private ModelLibraryService2 modelLibraryService;

    public void setModelLibraryService(ModelLibraryService2 modelLibraryService) {
        this.modelLibraryService = modelLibraryService;
    }

    /**
     * Get the available books
     *
     * @return a list of books ordered by title
     */
    @GetMapping("/books/available")
    public ResponseEntity<List<BookJson>> getAvailableBooks() {
        Set<Book> availableBookSet = modelLibraryService.getAvailableBooks();

        List<BookJson> orderedJsonBookList = toJson(availableBookSet);

        if( orderedJsonBookList.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(orderedJsonBookList);
    }
}