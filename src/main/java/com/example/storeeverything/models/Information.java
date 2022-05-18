package com.example.storeeverything.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name="information")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "information_id")
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    @Length(min = 3, message = "*Tytuł musi zawierać conajmniej 3 znaki")
    private String title;

    @Column(name = "content")
    @Length(min = 5, max = 500, message = "*Treść powinna zawierać od 5 do 500 znaków.")
    private String content;

    @Column(name = "addDate")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date addDate;

    @Column(name = "category")
    private String category;

    @Column(name = "isShared")
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
