package com.example.storeeverything.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name="information")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "information_id")
    private Long id;

    @Column(name = "title", nullable = false)
    @Length(min = 3, message = "*Tytuł musi zawierać conajmniej 3 znaki")
    private String title;

    @Column(name = "content", nullable = false)
    @Length(min = 5, max = 500, message = "*Treść powinna zawierać od 5 do 500 znaków.")
    private String content;

    @Column(name = "addDate", nullable = false)
    @Type(type="date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date addDate;

    @Column(name = "category", nullable = false)
    @Pattern(regexp = "^[a-z]{3,20}$", message = "Kategoria musi składać się tylko z małych liter.")
    private String category;

    @Column(name = "isShared", nullable = false)
    private boolean isShared;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;


    public Information() {
    }

    public Information(String title, String content, Date addDate, String category) {
        this.title = title;
        this.content = content;
        this.addDate = addDate;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Information{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", addDate=" + addDate +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Information that = (Information) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
