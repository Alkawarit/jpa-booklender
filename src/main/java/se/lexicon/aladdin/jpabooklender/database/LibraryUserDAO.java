package se.lexicon.aladdin.jpabooklender.database;

import org.springframework.data.repository.query.Param;
import se.lexicon.aladdin.jpabooklender.model.entity.Book;
import se.lexicon.aladdin.jpabooklender.model.entity.LibraryUser;

import java.util.Optional;

public interface LibraryUserDAO {

    // Add ability to find by email

     Optional<LibraryUser> findByEmail (@Param("email") String email);


}
