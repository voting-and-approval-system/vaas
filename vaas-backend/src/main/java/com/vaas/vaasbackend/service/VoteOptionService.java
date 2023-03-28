package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;

import java.util.List;

public interface VoteOptionService {
    public List<TotalVoteForIssue> countTotalVotes(Integer issueId, Integer roundNumber);
}
