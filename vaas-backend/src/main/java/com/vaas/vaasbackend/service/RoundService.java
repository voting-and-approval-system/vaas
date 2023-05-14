package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblAsset;
import com.vaas.vaasbackend.entity.TblOption;
import com.vaas.vaasbackend.entity.TblRound;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoundService{
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
            throw new DataNotFoundException("No Options Found");
        }
        return rounds;
    }
}
