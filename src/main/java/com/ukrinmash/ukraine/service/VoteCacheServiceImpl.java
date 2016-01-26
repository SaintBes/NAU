package com.ukrinmash.ukraine.service;

import com.ukrinmash.ukraine.dao.VotesCacheDAO;
import com.ukrinmash.ukraine.domain.VotesCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admssa on 14.12.2015.
 */
@Service
@Transactional
public class VoteCacheServiceImpl implements VoteCacheService {

    @Autowired
    VotesCacheDAO votesCacheDAO;

    public VoteCacheServiceImpl() {
    }

    @Override
    public Long addVoteCache(VotesCache votesCache) {
        return votesCacheDAO.createVoteCache(votesCache);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VotesCache> findByDocRatingId(Long docRatingId) {
        return votesCacheDAO.findVotesCacheByRatingId(docRatingId);
    }
}
