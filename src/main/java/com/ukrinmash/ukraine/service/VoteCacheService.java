package com.ukrinmash.ukraine.service;

import com.ukrinmash.ukraine.domain.VotesCache;

import java.util.List;

/**
 * Created by admssa on 14.12.2015.
 */
public interface VoteCacheService {

    public Long addVoteCache(VotesCache votesCache);
    public List<VotesCache> findByDocRatingId(Long docRatingId);

}
