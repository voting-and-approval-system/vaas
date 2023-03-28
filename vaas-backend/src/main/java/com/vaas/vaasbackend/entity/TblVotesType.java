package com.vaas.vaasbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_votes_type")
public class TblVotesType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_type_id", nullable = false)
    private Integer id;

    @Column(name = "vote_type_title", nullable = false, length = 80)
    private String voteTypeTitle;

    @Column(name = "vote_type_description", length = 200)
    private String voteTypeDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoteTypeTitle() {
        return voteTypeTitle;
    }

    public void setVoteTypeTitle(String voteTypeTitle) {
        this.voteTypeTitle = voteTypeTitle;
    }

    public String getVoteTypeDescription() {
        return voteTypeDescription;
    }

    public void setVoteTypeDescription(String voteTypeDescription) {
        this.voteTypeDescription = voteTypeDescription;
    }

}