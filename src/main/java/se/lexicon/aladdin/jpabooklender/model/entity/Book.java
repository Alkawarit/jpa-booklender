package se.lexicon.aladdin.jpabooklender.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

import java.math.BigDecimal;
import java.util.Objects;

import static se.lexicon.aladdin.jpabooklender.model.constants.EntityConstants.GENERATOR;
import static se.lexicon.aladdin.jpabooklender.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class Book {
    @Id
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(name = "id", updatable = false)
    private Integer id;
    @Column(name = "title", unique = true)
    private String title;
    private boolean available;
    private boolean reserved;
    private Integer maxLoanDay;
    private BigDecimal finePerDays;
    private String description;

    public Book() {
    }

    public Book(Integer id, String title, boolean available, boolean reserved, Integer maxLoanDay, BigDecimal finePerDays, String description) {
        this.id = id;
        this.title = title;
        this.available = available;
        this.reserved = reserved;
        this.maxLoanDay = maxLoanDay;
        this.finePerDays = finePerDays;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return available == book.available && reserved == book.reserved && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(maxLoanDay, book.maxLoanDay) && Objects.equals(finePerDays, book.finePerDays) && Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, available, reserved, maxLoanDay, finePerDays, description);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", available=" + available +
                ", reserved=" + reserved +
                ", maxLoanDay=" + maxLoanDay +
                ", finePerDays=" + finePerDays +
                ", description='" + description + '\'' +
                '}';
    }
}
