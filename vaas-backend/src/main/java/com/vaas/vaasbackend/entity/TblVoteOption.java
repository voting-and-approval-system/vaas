package com.vaas.vaasbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_vote_option")
public class TblVoteOption {
    @Id
    @Column(name = "vote_option_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_vote_id", nullable = false)
    private TblUsersVote userVote;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
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