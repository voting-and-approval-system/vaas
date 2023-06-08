package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblUsersVote;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.repository.UserVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserVoteService {
    @Autowired
    UserVoteRepository userVoteRepository;

    public List<TblUsersVote> showUserVote() throws DataNotFoundException {
        List<TblUsersVote> usersVotes = userVoteRepository.findAll();
        if (usersVotes.isEmpty()) {
            throw new DataNotFoundException("No Data Found");
        }
        return usersVotes;
    }

    public TblUsersVote saveUserVote(TblUsersVote usersVote) throws Exception {
        try {
            return userVoteRepository.save(usersVote);
        } catch (Exception e) {
            throw new Exception("Data Not Inserted");
        }
    }

    public List<TblUsersVote> showUserVoteByUserId(Integer id) throws DataNotFoundException {
        List<TblUsersVote> tblUsersVotes = userVoteRepository.findByUserId(id);
        if(tblUsersVotes.isEmpty()){
            throw new DataNotFoundException("No Data Found For Given UserId " + id);
        }
        return tblUsersVotes;
    }

    public List<String> showUserVoteForIssue(Integer id) {
        return userVoteRepository.ShowUserVoteForIssue(id);
    }

    public Integer countVoteForRound(int issueId,int roundNumber){
        return userVoteRepository.countVoteForRound(issueId,roundNumber);
    }
}
