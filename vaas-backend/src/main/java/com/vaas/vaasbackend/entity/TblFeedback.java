package com.vaas.vaasbackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_feedback")
public class TblFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id", nullable = false)
    private Integer id;

    @Size(max = 200)
    @NotNull
    @Column(name = "feedback_description", nullable = false, length = 200)
    private String feedbackDescription;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private TblUser user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "issue_id", nullable = false)
    private TblIssue issue;

    @NotNull
    @Column(name = "feedback_date", nullable = false)
    private LocalDate feedbackDate;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFeedbackDescription() {
        return feedbackDescription;
    }
    public void setFeedbackDescription(String feedbackDescription) {
        this.feedbackDescription = feedbackDescription;
    }
    public TblUser getUser() {
        return user;
    }
    public void setUser(TblUser user) {
        this.user = user;
    }
    public TblIssue getIssue() {
        return issue;
    }
    public void setIssue(TblIssue issue) {
        this.issue = issue;
    }
    public LocalDate getFeedbackDate() {
        return feedbackDate;
    }
    public void setFeedbackDate(LocalDate feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

}