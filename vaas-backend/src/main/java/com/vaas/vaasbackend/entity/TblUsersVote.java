package com.vaas.vaasbackend.entity;



import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_users_vote")
public class TblUsersVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_vote_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private TblUser user;

    @ManyToOne
    @JoinColumn(name = "round_id", nullable = false)
    private TblRound round;

    @Column(name = "vote_date", nullable = false)
    private LocalDate voteDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TblUser getUser() {
        return user;
    }

    public void setUser(TblUser user) {
        this.user = user;
    }

    public TblRound getRound() {
        return round;
    }

    public void setRound(TblRound round) {
        this.round = round;
    }

    public LocalDate getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(LocalDate voteDate) {
        this.voteDate = voteDate;
    }

}