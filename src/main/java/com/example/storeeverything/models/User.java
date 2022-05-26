package com.example.storeeverything.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "user")
public class  User {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "*Proszę podać poprawny adres email")
    @NotBlank(message = "*Proszę podać email")
    private String email;

    @Column(name = "password", nullable = false)
    @Length(min = 5, message = "*Hasło powinno zawierać co najmniej 5 znaków")
    @NotBlank(message = "*Proszę podać hasło")
    @JsonIgnore
    private String password;

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 3, max = 20, message = "*Nazwa użytkownika powinna mieć 3-20 znaków")
    @NotBlank(message = "*Proszę podać nazwę użytkownika")
    private String username;

    @Column(name = "name")
    @Length(min = 3, max = 20, message = "*Imię powinno mieć 3-20 znaków")
    @NotBlank(message = "*Proszę podać imie")
    @Pattern(regexp = "^[A-Z][a-z]{3,19}$", message = "Pierwsza litera musi być wielka :)")
    private String name;

    @Column(name = "last_name")
    @Length(min = 3, max = 50, message = "*Nazwisko powinno mieć 3-50 znaków")
    @NotBlank(message = "*Prosze podać nazwisko")
    @Pattern(regexp = "^[A-Z][a-z]{3,50}$", message = "Pierwsza litera musi być wielka :)")
    private String lastName;

    @Column(name="age", nullable=false)
    @Min(value = 18, message = "Musisz mieć skończone 18 lat. Jesteś za malutki żeby przechowywać notatki :)")
    private int age;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user")
    private Collection<Information> informations;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Collection<Role> roles;

    public User() {
    }

    public User(String email, String password, String username, String name, String lastName, int age) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
