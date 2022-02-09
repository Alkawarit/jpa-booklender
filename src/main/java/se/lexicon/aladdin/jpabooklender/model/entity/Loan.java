  package se.lexicon.aladdin.jpabooklender.model.entity;

  import org.hibernate.annotations.GenericGenerator;

  import javax.persistence.*;
  import java.math.BigDecimal;
  import java.time.LocalDate;
import java.time.LocalDateTime;
  import java.time.Period;
  import java.util.Objects;

  import static se.lexicon.aladdin.jpabooklender.model.constants.EntityConstants.GENERATOR;
  import static se.lexicon.aladdin.jpabooklender.model.constants.EntityConstants.UUID_GENERATOR;

  @Entity
  public class Loan {
    @Id
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(name = "id", updatable = false)
  private long id;
  private LocalDate loanDate;
  @ManyToOne(
          fetch = FetchType.LAZY
  )
  @JoinColumn(name = "fk_book_id")
  private Book libraryBook;
  @ManyToOne(
          fetch = FetchType.LAZY
  )
  @JoinColumn(name = "fk_library_user_id")
  private LibraryUser libraryUser;
  private boolean  concluded;

      public Loan() {
      }

      public Loan(long id, LocalDate localDate, boolean consluded) {
          this.id = id;
          this.loanDate = loanDate;
          this. concluded = consluded;
      }


      public boolean isOverDue(){
          LocalDate dueDate = loanDate.plusDays(libraryBook.getMaxLoanDay());
          return LocalDate.now().isAfter(dueDate);
      }


      public BigDecimal getFine(){
          BigDecimal fine = BigDecimal.ZERO;
          if(isOverDue()){
              Period period = Period.between(loanDate.plusDays(libraryBook.getMaxLoanDay()), LocalDate.now());
              long daysOverdue = period.getDays();
              fine = BigDecimal.valueOf(libraryBook.getFinePerDays().longValue() * daysOverdue);        }
          return fine;
      }


      public long getId() {
          return id;
      }

      public void setId(long id) {
          this.id = id;
      }

      public LocalDate getLocalDate() {
          return loanDate;
      }

      public void setLocalDate(LocalDate localDate) {
          this.loanDate = localDate;
      }


      public void setConcluded(boolean consluded) {
          this.concluded = consluded;
      }

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Loan loan = (Loan) o;
          return id == loan.id && loanDate.equals(loan.loanDate);
      }

      @Override
      public int hashCode() {
          return Objects.hash(id, loanDate);
      }

      @Override
      public String toString() {
          return "Loan{" +
                  "id=" + id +
                  ", localDate=" + loanDate +
                  '}';
      }
  }
