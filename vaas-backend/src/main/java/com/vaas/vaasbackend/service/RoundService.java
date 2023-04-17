package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblRound;
import com.vaas.vaasbackend.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundService{
    @Autowired
    RoundRepository roundRepository;
    public List<TblRound> showRound() {
        return roundRepository.findAll();
    }
    public TblRound saveRound(TblRound round) {
        return roundRepository.save(round);
    }
    public List<TblRound> showRoundByIssueId(Integer id) {
        return roundRepository.findByIssueId(id);
    }
}
