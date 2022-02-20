package se.lexicon.aladdin.jpabooklender.model.dto;

import java.io.Serializable;
import java.util.List;

public class LibraryUserDTO implements Serializable {

    private String id;
    private String username;
    private String email;
    private List<LoanDTO> activeLoans;

    public LibraryUserDTO(String id, String username, String email, List<LoanDTO> activeLoans) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.activeLoans = activeLoans;
    }

    public LibraryUserDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<LoanDTO> getActiveLoans() {
        return activeLoans;
    }

    public void setActiveLoans(List<LoanDTO> activeLoans) {
        this.activeLoans = activeLoans;
    }
}

