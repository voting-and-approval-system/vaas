package com.vaas.vaasbackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
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