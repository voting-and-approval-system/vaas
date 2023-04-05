package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblVotesType;
import com.vaas.vaasbackend.repository.VoteTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VoteTypeService {

    @Autowired
    private VoteTypeRepository voteTypeRepository;





    public TblVotesType saveVoteType(TblVotesType votesType) {
        return voteTypeRepository.save(votesType);
    }


    public List<TblVotesType> showUserVoteType() {
        return voteTypeRepository.findAll();
    }


    public TblVotesType updateVoteType(Integer id, TblVotesType votesType) {
        TblVotesType depDB = voteTypeRepository.findById(id).get();

        if (Objects.nonNull(votesType.getVoteTypeTitle()) &&
                !"".equalsIgnoreCase(votesType.getVoteTypeTitle())){
            depDB.setVoteTypeTitle(votesType.getVoteTypeTitle());
        }

        if (Objects.nonNull(votesType.getVoteTypeDescription()) &&
                !"".equalsIgnoreCase(votesType.getVoteTypeDescription())){
            depDB.setVoteTypeDescription(votesType.getVoteTypeDescription());
        }

        return voteTypeRepository.save(depDB);
    }


    public void deleteVoteTypeById(Integer id) {
        voteTypeRepository.deleteById(id);
    }


}
