package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblUsersVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserVoteRepository extends JpaRepository<TblUsersVote,Integer> {
    public List<TblUsersVote> findByUserId(Integer id);
    @Query(nativeQuery = true,value = "select tbl_users.first_name,tbl_users.last_name from tbl_users,tbl_round,tbl_users_vote,tbl_issue where tbl_users.user_id = tbl_users_vote.user_id and\n" +
            "tbl_users_vote.round_id = tbl_round.round_id and tbl_round.issue_id = tbl_issue.issue_id and tbl_issue.issue_id = ?")
    public List<String> ShowUserVoteForIssue(Integer id);

    @Query(nativeQuery = true,value = "select top 1 user_vote_id from tbl_users_vote order by user_vote_id desc")
    public int lastInsertedRecord();

    @Query(nativeQuery = true,value = "select tbl_users.user_id from tbl_users,tbl_users_vote,tbl_round where tbl_users.user_id = tbl_users_vote.user_id and\n" +
            "tbl_round.round_id = tbl_users_vote.round_id and tbl_users.user_id = ? and tbl_round.round_id = ?")
    public Integer userAlreadyVote(int userId,int roundId);

    @Query(nativeQuery = true,value = "select count(tbl_users_vote.user_id) from tbl_users_vote,tbl_issue,tbl_round\n" +
            "where tbl_round.round_id = tbl_users_vote.round_id and tbl_issue.issue_id = tbl_round.issue_id\n" +
            "and tbl_issue.issue_id = ? and tbl_round.round_number = ?")
    Integer countVoteForRound(int issueId,int roundNumber);
}
