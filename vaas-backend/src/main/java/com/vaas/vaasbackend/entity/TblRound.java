package com.vaas.vaasbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_round")
public class TblRound {
    @Id
    @Column(name = "round_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "issue_id", nullable = false)
    private TblIssue issue;

    @Column(name = "round_number", nullable = false)
    private Integer roundNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TblIssue getIssue() {
        return issue;
    }

    public void setIssue(TblIssue issue) {
        this.issue = issue;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

}