package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblRound;
import com.vaas.vaasbackend.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundServiceImpl implements RoundService{
    @Autowired
    RoundRepository roundRepository;
    @Override
    public List<TblRound> ShowRound() {
        return roundRepository.findAll();
    }

    @Override
    public TblRound SaveRound(TblRound round) {
        return roundRepository.save(round);
    }

    @Override
    public List<TblRound> ShowRoundByIssueId(Integer id) {
        return roundRepository.findByIssueId(id);
    }
}
