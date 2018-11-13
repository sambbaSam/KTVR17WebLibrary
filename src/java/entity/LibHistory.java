package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Sanata
 */
@Entity
public class LibHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne// - (cascade = CascadeType.MERGE,orphanRemoval = true) - каскад для Магазина
    private Book book;
    @OneToOne
    private Reader reader;
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookIssued;
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookReturn;

    public LibHistory() {
    }
    public LibHistory(Book book, Reader reader, Date bookIssued, Date bookReturn) {
        this.book = book;
        this.reader = reader;
        this.bookIssued = bookIssued;// vida4a knigi
        this.bookReturn = bookReturn;//vozvrat knigi
    }
        
    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getBookIssued() {
        return bookIssued;
    }

    public void setBookIssued(Date bookIssued) {
        this.bookIssued = bookIssued;
    }

    public Date getBookReturn() {
        return bookReturn;
    }

    public void setBookReturn(Date bookReturn) {
        this.bookReturn = bookReturn;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.book);
        hash = 17 * hash + Objects.hashCode(this.reader);
        hash = 17 * hash + Objects.hashCode(this.bookIssued);
        hash = 17 * hash + Objects.hashCode(this.bookReturn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibHistory other = (LibHistory) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        if (!Objects.equals(this.bookIssued, other.bookIssued)) {
            return false;
        }
        if (!Objects.equals(this.bookReturn, other.bookReturn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdm = new SimpleDateFormat("dd.mm.yyyy");//dlja dati vida4i knigi
        if(bookReturn!=null)//dlja dati vozvrata knigi
            return "LibHistory{" + "id=" + id + ", book=" + book.getNameBook() + ", reader=" + reader.getName()+""+reader.getSurname() + ", bookIssued=" + sdm.format(bookIssued) + ", bookReturn=" + sdm.format(bookReturn) + '}';
        else 
            return "LibHistory{" + "id=" + id + ", book=" + book.getNameBook() + ", reader=" + reader.getName()+""+reader.getSurname() + ", bookIssued=" + sdm.format(bookIssued)+'}';
        
    }
   
    
}
