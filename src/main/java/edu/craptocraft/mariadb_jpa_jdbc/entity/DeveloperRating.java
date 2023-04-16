package edu.craptocraft.mariadb_jpa_jdbc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "dev_rating")
public class DeveloperRating {
    
    @Id
    @Column(name = "rating")
    private int rating;

    @Column(name = "rating_comment")
    private String ratingComment;

    public DeveloperRating() {
    }

    public DeveloperRating(int rating) {
        this.rating = rating;
    }

    public DeveloperRating(int rating, String ratingComment) {
        this.rating = rating;
        this.ratingComment = ratingComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DeveloperRating that = (DeveloperRating) o;
        return Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRatingComment() {
        return ratingComment;
    }

    public void setRatingComment(String ratingComment) {
        this.ratingComment = ratingComment;
    }

    @Override
    public String toString() {
        return "\t" + this.getRating() + ": " + this.getRatingComment() + "\n";
    }

}
