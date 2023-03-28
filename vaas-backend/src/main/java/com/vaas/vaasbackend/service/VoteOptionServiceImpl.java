package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.repository.VoteOptionRepository;
import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteOptionServiceImpl implements VoteOptionService{
    @Autowired
    VoteOptionRepository voteOptionRepository;
    @Override
    public List<TotalVoteForIssue> countTotalVotes(Integer issueId, Integer roundNumber) {
        return voteOptionRepository.countTotalVotes(issueId,roundNumber);
    }
}