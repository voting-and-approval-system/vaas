package com.vaas.vaasbackend.entity;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import jakarta.persistence.*;

@Entity
@org.hibernate.annotations.NamedNativeQuery(name="TotalVoteForIssueMapping",
        query = "select tbl_option.option_title, count(tbl_vote_option.option_id) as total_votes,tbl_votes_type.vote_type_title from tbl_option,\n" +
                "tbl_vote_option,tbl_issue,tbl_round,tbl_users_vote,tbl_votes_type where\n" +
                "tbl_option.option_id = tbl_vote_option.option_id and tbl_issue.issue_id = tbl_option.issue_id\n" +
                "and tbl_issue.issue_id = tbl_round.issue_id and tbl_users_vote.user_vote_id = tbl_vote_option.user_vote_id and\n" +
                "tbl_votes_type.vote_type_id = tbl_issue.vote_type_id and\n" +
                "tbl_users_vote.round_id = tbl_round.round_id and tbl_issue.issue_id = ? and tbl_round.round_number = ?\n" +
                "group by tbl_option.option_title,vote_type_title",
        resultSetMapping="TotalVoteForIssueMapping"
)
@SqlResultSetMapping(
        name = "TotalVoteForIssueMapping",
        classes = @ConstructorResult(
                targetClass = TotalVoteForIssue.class,
                columns = {
                        @ColumnResult(name = "option_title", type = String.class),
                        @ColumnResult(name = "total_votes", type = Integer.class),
                        @ColumnResult(name = "vote_type_title", type = String.class)
                }
        )
)
@Table(name = "tbl_vote_option")
public class TblVoteOption {
    @Id
    @Column(name = "vote_option_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_vote_id", nullable = false)
    private TblUsersVote userVote;

    @ManyToOne
    @JoinColumn(name = "option_id", nullable = false)
    private TblOption option;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TblUsersVote getUserVote() {
        return userVote;
    }

    public void setUserVote(TblUsersVote userVote) {
        this.userVote = userVote;
    }

    public TblOption getOption() {
        return option;
    }

    public void setOption(TblOption option) {
        this.option = option;
    }

}