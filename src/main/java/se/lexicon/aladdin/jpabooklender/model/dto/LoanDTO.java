package se.lexicon.aladdin.jpabooklender.model.dto;


import se.lexicon.aladdin.jpabooklender.database.BookDAO;
import se.lexicon.aladdin.jpabooklender.database.LibraryUserDAO;
import se.lexicon.aladdin.jpabooklender.model.entity.Book;
import se.lexicon.aladdin.jpabooklender.model.entity.LibraryUser;

import java.io.Serializable;
import java.time.LocalDate;

public class LoanDTO implements Serializable {

    private long id;
    private LocalDate loanDate;
    private BookDAO libraryBook;
    private LibraryUserDAO libraryUser;
    private boolean  concluded;

    public LoanDTO(long id,
                   LocalDate loanDate,
                   BookDAO libraryBook,
                   LibraryUserDAO libraryUser,
                   boolean concluded) {
        this.id = id;
        this.loanDate = loanDate;
        this.libraryBook = libraryBook;
        this.libraryUser = libraryUser;
        this.concluded = concluded;
    }

    public LoanDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public BookDAO getLibraryBook() {
        return libraryBook;
    }

    public void setLibraryBook(BookDAO libraryBook) {
        this.libraryBook = libraryBook;
    }

    public LibraryUserDAO getLibraryUser() {
        return libraryUser;
    }

    public void setLibraryUser(LibraryUserDAO libraryUser) {
        this.libraryUser = libraryUser;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public void setConcluded(boolean concluded) {
        this.concluded = concluded;
    }
}
