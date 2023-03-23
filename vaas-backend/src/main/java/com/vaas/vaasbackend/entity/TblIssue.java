package com.vaas.vaasbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_issue")
public class TblIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id", nullable = false)
    private Integer id;

    @Column(name = "issue_title", nullable = false, length = 80)
    private String issueTitle;

    @Column(name = "issue_description", length = 200)
    private String issueDescription;

    @Column(name = "issue_attachment_path", length = 200)
    private String issueAttachmentPath;

    @Column(name = "allow_multiple_options", nullable = false)
    private Boolean allowMultipleOptions = false;

    @ManyToOne
    @JoinColumn(name = "assetes_id")
    private TblAssete assetes;

    @Column(name = "issue_is_active", nullable = false)
    private Boolean issueIsActive = false;

    @ManyToOne
    @JoinColumn(name = "vote_type_id", nullable = false)
    private TblVotesType voteType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getIssueAttachmentPath() {
        return issueAttachmentPath;
    }

    public void setIssueAttachmentPath(String issueAttachmentPath) {
        this.issueAttachmentPath = issueAttachmentPath;
    }

    public Boolean getAllowMultipleOptions() {
        return allowMultipleOptions;
    }

    public void setAllowMultipleOptions(Boolean allowMultipleOptions) {
        this.allowMultipleOptions = allowMultipleOptions;
    }

    public TblAssete getAssetes() {
        return assetes;
    }

    public void setAssetes(TblAssete assetes) {
        this.assetes = assetes;
    }

    public Boolean getIssueIsActive() {
        return issueIsActive;
    }

    public void setIssueIsActive(Boolean issueIsActive) {
        this.issueIsActive = issueIsActive;
    }

    public TblVotesType getVoteType() {
        return voteType;
    }

    public void setVoteType(TblVotesType voteType) {
        this.voteType = voteType;
    }

}