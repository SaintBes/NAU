package com.ukrinmash.ukraine.dao;

import com.ukrinmash.ukraine.domain.VotesCache;

import java.util.List;

/**
 * Created by admssa on 14.12.2015.
 */
public interface VotesCacheDAO {
    Long createVoteCache(VotesCache votesCache);
    void updateVoteCache(VotesCache votesCache);
    void deleteVoteCache(VotesCache votesCache);
    VotesCache readVoteCache(Long voteCacheId);
    List<VotesCache> findAllVotesCache();
    List<VotesCache> findVotesCacheByRatingId(Long ratingId);


}
