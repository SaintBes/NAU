package com.ukrinmash.ukraine.domain;

import javax.persistence.*;

@Entity
public class DocRating {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ratingId;
    @Column(precision=10, scale=2)
    private double rating;

    private int voters;

    public DocRating() {
    }

    public long getRatingId() {
        return ratingId;
    }

    public void setRatingId(long ratingId) {
        this.ratingId = ratingId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVoters() {
        return voters;
    }

    public void setVoters(int voters) {
        this.voters = voters;
    }
}
