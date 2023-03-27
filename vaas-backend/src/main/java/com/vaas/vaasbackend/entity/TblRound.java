package com.vaas.vaasbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_round")
public class TblRound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "round_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "issue_id", nullable = false)
    private TblIssue issue;

    @Column
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