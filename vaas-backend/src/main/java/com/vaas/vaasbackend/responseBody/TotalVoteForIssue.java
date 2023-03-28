package com.vaas.vaasbackend.responseBody;

public class TotalVoteForIssue {

    private String optionTitle;
    private int count;

    public TotalVoteForIssue() {
    }

    public TotalVoteForIssue(String optionTitle, int count) {
        this.optionTitle = optionTitle;
        this.count = count;
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

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TotalVoteForIssue{" +
                "optionTitle='" + optionTitle + '\'' +
                ", count=" + count +
                '}';
    }
}
