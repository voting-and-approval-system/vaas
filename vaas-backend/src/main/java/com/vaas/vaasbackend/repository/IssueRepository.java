package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<TblIssue,Integer> {

    public List<TblIssue> findByIssueIsActive(boolean isActive);

    @Query(nativeQuery = true,value = "select tbl_issue.* from tbl_assets,tbl_issue where tbl_issue.assets_id = tbl_assets.assets_id and tbl_issue.issue_is_active = 1 and tbl_assets.assets_id = ?")
    List<TblIssue> getActiveIssueForAssets(Integer assetsId);

    @Query(nativeQuery = true,value = "select top 1 issue_id from tbl_issue order by issue_id desc")
    Integer getIdOfLastAddedIssue();

    @Query(nativeQuery = true,value = "select tbl_issue.* from tbl_issue,tbl_round where tbl_round.issue_id = tbl_issue.issue_id and tbl_round.round_id = ?")
    TblIssue getIssueByRoundId(int roundId);
}
