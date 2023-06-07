package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblFeedback;
import com.vaas.vaasbackend.entity.TblIssue;
import com.vaas.vaasbackend.entity.TblUsersVote;
import com.vaas.vaasbackend.entity.TblVoteOption;
import com.vaas.vaasbackend.errors.UserAlreadyVoteException;
import com.vaas.vaasbackend.repository.*;
import com.vaas.vaasbackend.responseBody.Voting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;

@Service
public class VotingService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private RoundRepository roundRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserVoteRepository userVoteRepository;

    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    OptionRepository optionRepository;

    @Transactional(rollbackOn = Exception.class)
    public Voting insertVotingDetails(Voting voting) throws Exception {
        Integer userId = userVoteRepository.userAlreadyVote(voting.getUserId(), voting.getRoundId());
        if(userId != null){
            throw new UserAlreadyVoteException("User alredy vote for this round");
        }
        try {
            TblUsersVote usersVote = new TblUsersVote();
            usersVote.setRound(roundRepository.findById(voting.getRoundId()).get());
            usersVote.setVoteDate(voting.getVoteDate());
            usersVote.setUser(usersRepository.findById(voting.getUserId()).get());
            entityManager.persist(usersVote);

            for (Voting.VotePreference votePreference : voting.getVotePreferences()) {
                TblVoteOption voteOption = new TblVoteOption();
                voteOption.setUserVote(userVoteRepository.findById(userVoteRepository.lastInsertedRecord()).get());
                voteOption.setOption(optionRepository.findById(votePreference.getOptionId()).get());
                voteOption.setPreference(votePreference.getPreference());
                entityManager.persist(voteOption);
            }
            return voting;
        } catch (Exception e) {
            throw new Exception("No Voting");
        }
    }

}
