package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblUsersVote;
import com.vaas.vaasbackend.entity.TblVoteOption;
import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteOptionRepository extends JpaRepository<TblVoteOption,Integer> {
    @Query(name = "TotalVoteForIssueMapping",nativeQuery = true)
    List<TotalVoteForIssue> countTotalVotes(Integer issueId, Integer roundNumber);
}
