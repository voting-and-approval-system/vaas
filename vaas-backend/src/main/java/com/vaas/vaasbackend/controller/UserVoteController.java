package com.vaas.vaasbackend.controller;

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
    public List<TblUsersVote> showUserVote(){
        return userVoteService.showUserVote();
    }

    @GetMapping("/uservote/user/{id}")
    public List<TblUsersVote> showUserVoteByUserId(@PathVariable Integer id){
        return userVoteService.showUserVoteByUserId(id);
    }

    @GetMapping("/uservote/uservoteforissue/{id}")
    public List<String> showUserVoteForIssue(@PathVariable Integer id){
        return userVoteService.showUserVoteForIssue(id);
    }

    @PostMapping("/uservote")
    public TblUsersVote saveUserVote(@RequestBody TblUsersVote usersVote){
        return userVoteService.saveUserVote(usersVote);
    }
}
