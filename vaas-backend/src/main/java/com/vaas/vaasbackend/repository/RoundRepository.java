package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoundRepository extends JpaRepository<TblRound,Integer> {
    public List<TblRound> findByIssueId(Integer id);

    @Query(nativeQuery = true,value = "select * from tbl_round where round_is_active = 1 and round_id not in (select tbl_users_vote.round_id from tbl_users_vote where tbl_users_vote.user_id = ?)")
    List<TblRound> roundUserNotVote(Integer id);

    @Query(nativeQuery = true,value = "select * from tbl_round where issue_id in (select issue_id from tbl_issue where issue_is_active = 0)")
    List<TblRound> roundWithDeactiveIssues();

    @Query(nativeQuery = true,value = "select * from tbl_round where round_is_active = 0")
    List<TblRound> deactiveRounds();


    @Modifying
    @Query(nativeQuery = true,value = "UPDATE tbl_round SET round_is_active = 'false' WHERE round_id = ?")
    List<TblRound> setRoundToDeactive(Integer id);

    @Query(nativeQuery = true,value = "select * from tbl_round where round_is_active = 'true'")
    List<TblRound> activeRounds();


}
