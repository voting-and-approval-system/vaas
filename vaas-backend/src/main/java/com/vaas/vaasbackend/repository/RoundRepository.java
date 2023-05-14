package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoundRepository extends JpaRepository<TblRound,Integer> {
    public List<TblRound> findByIssueId(Integer id);

    @Query(nativeQuery = true,value = "select * from tbl_round where round_id not in (select tbl_users_vote.round_id from tbl_users_vote where tbl_users_vote.user_id = ?)")
    List<TblRound> roundUserNotVote(Integer id);
}
