package com.vaas.vaasbackend.entity;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@SqlResultSetMapping(
        name = "TotalVoteForIssueMapping",
        classes = @ConstructorResult(
                targetClass = TotalVoteForIssue.class,
                columns = {
                        @ColumnResult(name = "option_id", type = Integer.class),
                        @ColumnResult(name = "option_title", type = String.class),
                        @ColumnResult(name = "round_number", type = Integer.class),
                        @ColumnResult(name = "total_votes", type = Integer.class),
                        @ColumnResult(name = "preference", type = Integer.class),
                        @ColumnResult(name = "vote_type_title", type = String.class)
                }
        )
)
@org.hibernate.annotations.NamedNativeQuery(name = "TotalVoteForIssueMapping",
        query = "select tbl_option.option_id,tbl_option.option_title,tbl_round.round_number,count(tbl_vote_option.option_id) as total_votes," +
                "tbl_vote_option.preference," +
                "tbl_votes_type.vote_type_title from tbl_option,\n" +
                "tbl_vote_option,tbl_issue,tbl_round,tbl_users_vote,tbl_votes_type where\n" +
                "tbl_option.option_id = tbl_vote_option.option_id and tbl_issue.issue_id = tbl_option.issue_id\n" +
                "and tbl_issue.issue_id = tbl_round.issue_id and tbl_users_vote.user_vote_id = tbl_vote_option.user_vote_id and\n" +
                "tbl_votes_type.vote_type_id = tbl_issue.vote_type_id and \n" +
                "tbl_users_vote.round_id = tbl_round.round_id and tbl_issue.issue_id = ? and tbl_round.round_number = ? and\n" +
                "tbl_issue.issue_is_active = 0 and tbl_round.round_is_active = 0\n" +
                "group by tbl_option.option_id,tbl_option.option_title,vote_type_title,tbl_vote_option.preference,tbl_round.round_number",
        resultSetMapping = "TotalVoteForIssueMapping"
)
@org.hibernate.annotations.NamedNativeQuery(name = "getNewOptionList",
        query = "select tbl_option.option_id,tbl_option.option_title,tbl_round.round_number,count(tbl_vote_option.option_id) as total_votes," +
                "tbl_vote_option.preference,tbl_votes_type.vote_type_title from tbl_option,\n" +
                "tbl_vote_option,tbl_issue,tbl_round,tbl_users_vote,tbl_votes_type where\n" +
                "tbl_option.option_id = tbl_vote_option.option_id and tbl_issue.issue_id = tbl_option.issue_id\n" +
                "and tbl_issue.issue_id = tbl_round.issue_id and tbl_users_vote.user_vote_id = tbl_vote_option.user_vote_id and\n" +
                "tbl_votes_type.vote_type_id = tbl_issue.vote_type_id and tbl_vote_option.preference = ? and\n" +
                "tbl_users_vote.round_id = tbl_round.round_id and tbl_issue.issue_id = ? and tbl_round.round_number = ?" +
                "and tbl_issue.issue_is_active = 0 and tbl_round.round_is_active = 0 and tbl_users_vote.user_id IN(?)\n" +
                "group by tbl_option.option_id,tbl_option.option_title,vote_type_title,tbl_vote_option.preference,tbl_round.round_number",
        resultSetMapping = "TotalVoteForIssueMapping"
)
@Table(name = "tbl_vote_option")
public class TblVoteOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_option_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_vote_id", nullable = false)
    private TblUsersVote userVote;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "option_id", nullable = false)
    private TblOption option;

    @Column(name = "preference")
    private Integer preference;

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

    public Integer getPreference() {
        return preference;
    }

    public void setPreference(Integer preference) {
        this.preference = preference;
    }
}