package com.vaas.vaasbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_option")
public class TblOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id", nullable = false)
    private Integer id;

    @Column(name = "option_title", nullable = false, length = 80)
    private String optionTitle;

    @Column(name = "option_description", length = 200)
    private String optionDescription;

    @Column(name = "option_attachment_path", length = 200)
    private String optionAttachmentPath;

    @ManyToOne
    @JoinColumn(name = "issue_id", nullable = false)
    private TblIssue issue;

    @Column(name = "option_is_active", nullable = false)
    private Boolean optionIsActive = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptionTitle() {
        return optionTitle;
    }

    public void setOptionTitle(String optionTitle) {
        this.optionTitle = optionTitle;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    public void setOptionDescription(String optionDescription) {
        this.optionDescription = optionDescription;
    }

    public String getOptionAttachmentPath() {
        return optionAttachmentPath;
    }

    public void setOptionAttachmentPath(String optionAttachmentPath) {
        this.optionAttachmentPath = optionAttachmentPath;
    }

    public TblIssue getIssue() {
        return issue;
    }

    public void setIssue(TblIssue issue) {
        this.issue = issue;
    }

    public Boolean getOptionIsActive() {
        return optionIsActive;
    }

    public void setOptionIsActive(Boolean optionIsActive) {
        this.optionIsActive = optionIsActive;
    }

}