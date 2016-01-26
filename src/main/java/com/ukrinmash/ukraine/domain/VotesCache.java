package com.ukrinmash.ukraine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by admssa on 14.12.2015.
 */
@Entity
public class VotesCache {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long voteId;

    private String sesscionId;
    private Long docRatingId;

    public VotesCache() {
    }

    public VotesCache(String sesscionId, Long docRatingId) {
        this.sesscionId = sesscionId;
        this.docRatingId = docRatingId;
    }



    public long getVoteId() {
        return voteId;
    }

    public String getSesscionId() {
        return sesscionId;
    }

    public Long getDocRatingId() {
        return docRatingId;
    }
}
