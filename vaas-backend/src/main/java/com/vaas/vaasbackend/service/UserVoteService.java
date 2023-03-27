package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblUser;
import com.vaas.vaasbackend.entity.TblUsersVote;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserVoteService {
    public List<TblUsersVote> ShowUserVote();

    public TblUsersVote SaveUserVote(TblUsersVote usersVote);

    public List<TblUsersVote> ShowUserVoteByUserId(Integer id);

    public List<String> ShowUserVoteForIssue(Integer id);
}
