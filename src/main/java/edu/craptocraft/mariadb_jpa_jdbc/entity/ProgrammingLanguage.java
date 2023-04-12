package edu.craptocraft.mariadb_jpa_jdbc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "programming_language")
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_rating")
    private UserRating userRating;

    @ManyToOne
    @JoinColumn(name = "dev_rating")
    private DeveloperRating devRating;

    public ProgrammingLanguage() {
    }

    public ProgrammingLanguage(String name, UserRating userRating, DeveloperRating devRating) {
        this.name = name;
        this.userRating = userRating;
        this.devRating = devRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProgrammingLanguage that = (ProgrammingLanguage) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRating getUserRating() {
        return userRating;
    }

    public void setUserRating(UserRating userRating) {
        this.userRating = userRating;
    }

    public DeveloperRating getDevRating() {
        return devRating;
    }

    public void setDevRating(DeveloperRating devRating) {
        this.devRating = devRating;
    }

    @Override
    public String toString() {
        return "\n\tProgramming Language: " + this.getName() + "\n\tUser Rating: " + this.getUserRating().getRating()
        + "\n\tDeveloper Rating: " + this.getDevRating().getRating() + "\n";
    }

}
