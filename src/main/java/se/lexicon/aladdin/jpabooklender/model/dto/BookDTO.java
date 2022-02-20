package se.lexicon.aladdin.jpabooklender.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class BookDTO implements Serializable {

    private Integer id;
    private String title;
    private boolean available;
    private boolean reserved;
    private Integer maxLoanDay;
    private BigDecimal finePerDays;
    private String description;
    private List<LoanDTO> loanHistory;

    public BookDTO(Integer id,
                   String title,
                   boolean available,
                   boolean reserved,
                   Integer maxLoanDay,
                   BigDecimal finePerDays,
                   String description,
                   List<LoanDTO> loanHistory) {
        this.id = id;
        this.title = title;
        this.available = available;
        this.reserved = reserved;
        this.maxLoanDay = maxLoanDay;
        this.finePerDays = finePerDays;
        this.description = description;
        this.loanHistory = loanHistory;
    }

    public BookDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Integer getMaxLoanDay() {
        return maxLoanDay;
    }

    public void setMaxLoanDay(Integer maxLoanDay) {
        this.maxLoanDay = maxLoanDay;
    }

    public BigDecimal getFinePerDays() {
        return finePerDays;
    }

    public void setFinePerDays(BigDecimal finePerDays) {
        this.finePerDays = finePerDays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LoanDTO> getLoanHistory() {
        return loanHistory;
    }

    public void setLoanHistory(List<LoanDTO> loanHistory) {
        this.loanHistory = loanHistory;
    }
}
