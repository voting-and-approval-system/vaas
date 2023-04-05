package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblUsersVote;
import com.vaas.vaasbackend.repository.UserVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVoteService {
    @Autowired
    UserVoteRepository userVoteRepository;

    public List<TblUsersVote> showUserVote() {
        return userVoteRepository.findAll();
    }


    public TblUsersVote saveUserVote(TblUsersVote usersVote) {
        return userVoteRepository.save(usersVote);
    }


    public List<TblUsersVote> showUserVoteByUserId(Integer id) {
        return userVoteRepository.findByUserId(id);
    }


    public List<String> showUserVoteForIssue(Integer id) {
        return userVoteRepository.ShowUserVoteForIssue(id);
    }

}
