package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblUser;
import com.vaas.vaasbackend.entity.TblUsersVote;
import com.vaas.vaasbackend.repository.UserVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserVoteServiceImpl implements UserVoteService{
    @Autowired
    private UserVoteRepository userVoteRepository;
    @Override
    public List<TblUsersVote> ShowUserVote() {
        return userVoteRepository.findAll();
    }
    @Override
    public TblUsersVote SaveUserVote(TblUsersVote usersVote) {
        return userVoteRepository.save(usersVote);
    }
    @Override
    public List<TblUsersVote> ShowUserVoteByUserId(Integer id) {
        return userVoteRepository.findByUserId(id);
    }
    @Override
    public List<String> ShowUserVoteForIssue(Integer id) {
        return userVoteRepository.ShowUserVoteForIssue(id);
    }
}
