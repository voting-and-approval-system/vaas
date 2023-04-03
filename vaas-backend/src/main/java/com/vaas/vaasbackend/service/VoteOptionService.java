package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblVoteOption;
import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;

import java.util.List;

public interface VoteOptionService {
    public List<TotalVoteForIssue> countTotalVotes(Integer issueId, Integer roundNumber);

    public List<TblVoteOption> showVoteOption();

    public TblVoteOption saveVoteOption(TblVoteOption tblVoteOption);
}
