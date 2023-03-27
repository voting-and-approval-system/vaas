package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblUser;
import com.vaas.vaasbackend.entity.TblUsersVote;
import com.vaas.vaasbackend.service.UserVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserVoteController {
    @Autowired
    UserVoteService userVoteService;

    @GetMapping("/uservote")
    public List<TblUsersVote> ShowUserVote(){
        return userVoteService.ShowUserVote();
    }

    @GetMapping("/uservote/user/{id}")
    public List<TblUsersVote> ShowUserVoteByUserId(@PathVariable Integer id){
        return userVoteService.ShowUserVoteByUserId(id);
    }

    @GetMapping("/uservote/uservoteforissue/{id}")
    public List<String> ShowUserVoteForIssue(@PathVariable Integer id){
        return userVoteService.ShowUserVoteForIssue(id);
    }

    @PostMapping("/uservote")
    public TblUsersVote SaveUserVote(@RequestBody TblUsersVote usersVote){
        return userVoteService.SaveUserVote(usersVote);
    }
}
