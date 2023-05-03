package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblUsersVote;
import com.vaas.vaasbackend.entity.TblVoteOption;
import com.vaas.vaasbackend.repository.OptionRepository;
import com.vaas.vaasbackend.repository.RoundRepository;
import com.vaas.vaasbackend.repository.UserVoteRepository;
import com.vaas.vaasbackend.repository.UsersRepository;
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
    OptionRepository optionRepository;
    @Transactional(rollbackOn = Exception.class)
    public Voting insertVotingDetails(Voting voting) throws Exception {
        try{
            TblUsersVote usersVote = new TblUsersVote();
            usersVote.setRound(roundRepository.findById(voting.getRoundId()).get());
            usersVote.setVoteDate(voting.getVoteDate());
            usersVote.setUser(usersRepository.findById(voting.getUserId()).get());
            entityManager.persist(usersVote);

            for(int optionId : voting.getOptionIds()){
                TblVoteOption voteOption = new TblVoteOption();
                voteOption.setUserVote(userVoteRepository.findById(userVoteRepository.lastInsertedRecord()).get());
                voteOption.setOption(optionRepository.findById(optionId).get());
                voteOption.setPreference(voting.getPreference());
                entityManager.persist(voteOption);
            }
            return voting;
        }catch (Exception e){
            throw new Exception("No Voting");
        }
    }

}
