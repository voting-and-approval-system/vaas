package com.vaas.vaasbackend.responseBody;

public class TotalVoteForIssue {

    private String optionTitle;
    private int count;
    private String voteType;

    public TotalVoteForIssue() {
    }

    public TotalVoteForIssue(String optionTitle, int count, String voteType) {
        this.optionTitle = optionTitle;
        this.count = count;
        this.voteType = voteType;
    }

    public String getOptionTitle() {
        return optionTitle;
    }

    public void setOptionTitle(String optionTitle) {
        this.optionTitle = optionTitle;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "TotalVoteForIssue{" +
                "optionTitle='" + optionTitle + '\'' +
                ", count=" + count +
                ", voteType='" + voteType + '\'' +
                '}';
    }

    public String getVoteType() {
        return voteType;
    }

    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
