package com.vaas.vaasbackend.responseBody;
public class TotalVoteForIssue {

    private Integer optionId;
    private String optionTitle;

    private Integer roundNumber;
    private Integer count;
    private Integer preference;

    public Integer getPreference() {
        return preference;
    }

    public void setPreference(Integer preference) {
        this.preference = preference;
    }

    private String voteType;

    public TotalVoteForIssue() {
    }

    public TotalVoteForIssue(Integer optionId, String optionTitle, Integer roundNumber, Integer count, Integer preference, String voteType) {
        this.optionId = optionId;
        this.optionTitle = optionTitle;
        this.roundNumber = roundNumber;
        this.count = count;
        this.preference =  preference;
        this.voteType = voteType;
    }

    public String getOptionTitle() {
        return optionTitle;
    }

    public void setOptionTitle(String optionTitle) {
        this.optionTitle = optionTitle;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Integer getCount() {
        return count;
    }

    public String getVoteType() {
        return voteType;
    }

    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    @Override
    public String toString() {
        return "TotalVoteForIssue{" +
                "optionId=" + optionId +
                ", optionTitle='" + optionTitle + '\'' +
                ", roundNumber=" + roundNumber +
                ", count=" + count +
                ", preference=" + preference +
                ", voteType='" + voteType + '\'' +
                '}';
    }
}
