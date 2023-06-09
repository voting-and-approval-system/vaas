package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblVoteOption;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.repository.VoteOptionRepository;
import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteOptionService{
    @Autowired
    VoteOptionRepository voteOptionRepository;

    public List<TotalVoteForIssue> countTotalVotes(Integer issueId, Integer roundNumber) throws DataNotFoundException {
        List<TotalVoteForIssue> totalVoteForIssues = voteOptionRepository.countTotalVotes(issueId,roundNumber);
        if(totalVoteForIssues.isEmpty()){
            throw new DataNotFoundException("No user vote for this round");
        }
        return totalVoteForIssues;
    }

    public List<TblVoteOption> showVoteOption() throws DataNotFoundException {
        List<TblVoteOption> tblVoteOptions = voteOptionRepository.findAll();
        if(tblVoteOptions.isEmpty()){
            throw new DataNotFoundException("No Data Found");
        }
        return tblVoteOptions;
    }

    public TblVoteOption saveVoteOption(TblVoteOption tblVoteOption) throws Exception {
        try{
            return voteOptionRepository.save(tblVoteOption);
        }catch (Exception e){
            throw new Exception("Data Not Inserted");
        }
    }
}
