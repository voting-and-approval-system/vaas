package com.vaas.vaasbackend.responseBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Voting {
    public static class VotePreference{
        int optionId;
        int preference;

        public VotePreference() {
        }

        public VotePreference(int optionId, int preference) {
            this.optionId = optionId;
            this.preference = preference;
        }

        public int getOptionId() {
            return optionId;
        }

        public void setOptionId(int optionId) {
            this.optionId = optionId;
        }

        public int getPreference() {
            return preference;
        }

        public void setPreference(int preference) {
            this.preference = preference;
        }

        @Override
        public String toString() {
            return "VotePreference{" +
                    "optionId=" + optionId +
                    ", preference=" + preference +
                    '}';
        }
    }
    private int userId;
    private int roundId;
    private LocalDate voteDate;
    private List<VotePreference> votePreferences = new ArrayList<>();

    public Voting() {
    }

    public Voting(int userId, int roundId, LocalDate voteDate, List<VotePreference> votePreferences) {
        this.userId = userId;
        this.roundId = roundId;
        this.voteDate = voteDate;
        this.votePreferences = votePreferences;
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

    public List<VotePreference> getVotePreferences() {
        return votePreferences;
    }

    public void setVotePreferences(List<VotePreference> votePreferences) {
        this.votePreferences = votePreferences;
    }

    @Override
    public String toString() {
        return "Voting{" +
                "userId=" + userId +
                ", roundId=" + roundId +
                ", voteDate=" + voteDate +
                ", votePreferences=" + votePreferences +
                '}';
    }
}
