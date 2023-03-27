package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblRound;

import java.util.List;

public interface RoundService {
    public List<TblRound> ShowRound();

    public TblRound SaveRound(TblRound round);

    public List<TblRound> ShowRoundByIssueId(Integer id);
}
