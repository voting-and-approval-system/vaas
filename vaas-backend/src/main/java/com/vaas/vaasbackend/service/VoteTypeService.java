package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblVotesType;

import java.util.List;

public interface VoteTypeService {


    

    TblVotesType saveVoteType(TblVotesType votesType);


    public List<TblVotesType> showUserVoteType();

    

    public TblVotesType updateVoteType(Integer id, TblVotesType votesType);

    public void deleteVoteTypeById(Integer id);
}
