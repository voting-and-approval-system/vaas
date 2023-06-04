package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblIssue;
import com.vaas.vaasbackend.entity.TblRound;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoundService {
    @Autowired
    RoundRepository roundRepository;

    public List<TblRound> showRound() {
        return roundRepository.findAll();
    }

    public TblRound showRound(Integer id) throws DataNotFoundException {
        Optional<TblRound> asset = roundRepository.findById(id);
        if (!asset.isPresent()) {
            throw new DataNotFoundException("Round Not Available For Id " + id);
        }
        return asset.get();
    }

    public TblRound saveRound(TblRound round) {
        return roundRepository.save(round);
    }

    public List<TblRound> showRoundByIssueId(Integer id) {
        return roundRepository.findByIssueId(id);
    }

    public List<TblRound> roundUserNotVote(Integer id) throws DataNotFoundException {
        List<TblRound> rounds = roundRepository.roundUserNotVote(id);
        if (rounds.isEmpty()) {
            throw new DataNotFoundException("No Round Found");
        }
        return rounds;
    }

    public List<TblRound> roundWithDeactiveIssues() throws DataNotFoundException {
        List<TblRound> rounds = roundRepository.roundWithDeactiveIssues();
        if (rounds.isEmpty()) {
            throw new DataNotFoundException("No Round Found");
        }
        return rounds;
    }

    public List<TblRound> deactiveRounds() throws DataNotFoundException {
        List<TblRound> rounds = roundRepository.deactiveRounds();
        if (rounds.isEmpty()) {
            throw new DataNotFoundException("No Round Found");
        }
        return rounds;
    }

    public List<TblRound> activeRounds() throws DataNotFoundException {
        List<TblRound> rounds = roundRepository.activeRounds();
        if (rounds.isEmpty()) {
            throw new DataNotFoundException("No Round Found");
        }
        return rounds;
    }

    public TblRound updateRoundIsActive(Integer roundId, boolean isActive) throws DataNotFoundException {
        TblRound round = roundRepository.findById(roundId)
                .orElseThrow(() -> new DataNotFoundException("Round not found with ID: " + roundId));
        round.setRoundIsActive(isActive);
        return roundRepository.save(round);
    }

    public Integer lastRoundNumber(Integer issueId){
        return roundRepository.lastRoundNumber(issueId);
    }
}
