package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblVoteOption;
import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteOptionRepository extends JpaRepository<TblVoteOption,Integer> {
    @Query(name = "TotalVoteForIssueMapping",nativeQuery = true)
    List<TotalVoteForIssue> countTotalVotes(Integer issueId, Integer roundNumber);

    @Query(nativeQuery = true,value = "select count(*) from tbl_users,tbl_round,tbl_users_vote,tbl_issue where tbl_users.user_id = tbl_users_vote.user_id and\n" +
            "tbl_users_vote.round_id = tbl_round.round_id and tbl_round.issue_id = tbl_issue.issue_id and tbl_issue.issue_id = ? and tbl_round.round_number = ?")
    public int totalVote(int issueId, int roundNo);

    @Query(nativeQuery = true,value = "select tbl_users_vote.user_id from tbl_users_vote,tbl_vote_option where\n" +
            "tbl_users_vote.user_vote_id = tbl_vote_option.user_vote_id and tbl_vote_option.preference = 1 and tbl_vote_option.option_id = ?")
    public int[] userVoteForLeastOption(int optionId);

    @Query(name = "getNewOptionList",nativeQuery = true)
    public List<TotalVoteForIssue> getNextPreferenceOfLeastOptionUser(int nextPreference,int issueId,int roundNo,int[] users);
}
