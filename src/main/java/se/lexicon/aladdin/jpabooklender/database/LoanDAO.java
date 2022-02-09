package se.lexicon.aladdin.jpabooklender.database;

import org.springframework.data.repository.query.Param;
import se.lexicon.aladdin.jpabooklender.model.entity.LibraryUser;
import se.lexicon.aladdin.jpabooklender.model.entity.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanDAO {

    //Find by userId
   // b. Find by bookId
    //c. Find by terminated status

    Optional<Loan> findByUserId (@Param("id") long userId);

    Optional<Loan> findByBookId (@Param("bookId") int bookId);

    List<Loan> findByConcluded (@Param("concluded") boolean concluded);



}
