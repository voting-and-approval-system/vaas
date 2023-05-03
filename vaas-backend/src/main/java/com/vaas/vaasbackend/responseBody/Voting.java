package com.vaas.vaasbackend.responseBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Voting {
    private int userId;
    private int roundId;
    private LocalDate voteDate;
    private List<Integer> optionIds = new ArrayList<>();
    private int preference;

    public Voting() {
    }

    public Voting(int userId, int roundId, LocalDate voteDate, List<Integer> optionIds, int preference) {
        this.userId = userId;
        this.roundId = roundId;
        this.voteDate = voteDate;
        this.optionIds = optionIds;
        this.preference = preference;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public LocalDate getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(LocalDate voteDate) {
        this.voteDate = voteDate;
    }

    public List<Integer> getOptionIds() {
        return optionIds;
    }

    public void setOptionIds(List<Integer> optionIds) {
        this.optionIds = optionIds;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }

    @Override
    public String toString() {
        return "Voting{" +
                "userId=" + userId +
                ", roundId=" + roundId +
                ", voteDate=" + voteDate +
                ", optionId=" + optionIds +
                ", preference=" + preference +
                '}';
    }
}
