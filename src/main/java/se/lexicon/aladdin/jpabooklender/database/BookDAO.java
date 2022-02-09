package se.lexicon.aladdin.jpabooklender.database;

import org.springframework.data.repository.query.Param;
import se.lexicon.aladdin.jpabooklender.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {

    // Find by reserved status
    //b. Find by available status
    //c. Find by title.
List<Book> findByReservedStatus (@Param("reserved") boolean reserved);

List<Book> findByAvailableStatus (@Param("available") boolean available);

List<Book> findByTitle (@Param("title") String title);

}
